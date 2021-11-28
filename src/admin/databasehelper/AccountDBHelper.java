package admin.databasehelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.Message ;



import admin.frontend.Navigator;
import javafx.scene.control.Alert;
import admin.model.Account;

public class AccountDBHelper {
    //This function will get all Account from database
    public static List<Account> getAllAccount() {
        List<Account> listAcc = new ArrayList<>();
       
        try (Connection connect = ConnectDBHelper.getConnect();
        CallableStatement stm  = connect.prepareCall("{call getAllAccount()}");) {
            stm.execute();
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                String id = rs.getString("ACCOUNTID");
                String username = rs.getString("NAME");
                String email = rs.getString("EMAIL");
                String password = rs.getString("PASSWORD");
                String type = rs.getString("TYPE");
                String status = rs.getString("STATUS");
                Account acc = new Account(id, username,email, password, type, status);
                listAcc.add(acc);
            }
        } catch (Exception e) {
            System.out.println("Loi:" + e.getMessage());
        }
        return listAcc;
    }
  
 
    public static Boolean checkEmailRegex(String email) {
        String regex = "[a-zA-Z0-9_\\.]{3,20}@[a-zA-Z0-9]{3,10}\\.[a-zA-Z0-9]{2,5}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        boolean match = matcher.matches();
        return match;
    }

    public static Boolean checkPasswordRegex(String password) {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        boolean match = matcher.matches();
        return match;
    }

    public static void AdminLogIn(String email, String password) throws IOException {
        int flag = 1;
        System.out.print(checkPasswordRegex(password));
        List<Account> listAccount = AccountDBHelper.getAllAccount();
        loop:
        for (Account acc : listAccount) {
            if (email.isEmpty() || password.isEmpty()) {
                flag = 3;
            } else if (!checkEmailRegex(email)) {
                flag = 5;
            } else {
                if (!checkPasswordRegex(password)) {
                    flag = 6;
                } else if (acc.getStatus().equalsIgnoreCase("Locked")) {
                    flag = 2;
                } else if (!email.equals(acc.getEmail()) || !password.equals(acc.getPassword())) {
                    flag = 4;
                } else {
                    if (acc.getType().equalsIgnoreCase("Admin")) {
                        Navigator.getInstance().goToAdminHome2();
                        break loop;
                    } 
                }
            }
        }
        if (flag == 2) {
            Navigator.getInstance().showAlert(Alert.AlertType.ERROR,"Your Account is Locked!");
        } else if (flag == 3) {
            Navigator.getInstance().showAlert(Alert.AlertType.ERROR,"Please fill out the form!");
        } else if (flag == 4) {
            Navigator.getInstance().showAlert(Alert.AlertType.ERROR,"Phone number or Password is wrong!");
        } else if (flag == 5) {
            Navigator.getInstance().showAlert(Alert.AlertType.ERROR,"Phone number is invalid");
        } else if (flag == 6) {
            Navigator.getInstance().showAlert(Alert.AlertType.ERROR,"Password must be between 8 and 20 characters. Include numbers, lowercase letters, uppercase letters and do not contain special characters");
        }
    }
    public static void EmployeeLoginIn(String username, String password) throws IOException {
        int flag = 1;
        System.out.print(checkPasswordRegex(password));
        List<Account> listAccount = AccountDBHelper.getAllAccount();
        loop:
        for (Account acc : listAccount) {
            if (username.isEmpty() || password.isEmpty()) {
                flag = 3;
            }  else {
                if (!checkPasswordRegex(password)) {
                    flag = 6;
                } else if (acc.getStatus().equalsIgnoreCase("Locked")) {
                    flag = 2;
                } else if (!username.equals(acc.getUserName()) || !password.equals(acc.getPassword())) {
                    flag = 4;
                } else {
                    if (acc.getType().equalsIgnoreCase("Employee")) {
                        System.out.println("Employee Page");
                        
                    }
                }
            }
        }
        if (flag == 2) {
            Navigator.getInstance().showAlert(Alert.AlertType.ERROR,"Your Account is Locked!");
        } else if (flag == 3) {
            Navigator.getInstance().showAlert(Alert.AlertType.ERROR,"Please fill out the form!");
        } else if (flag == 4) {
            Navigator.getInstance().showAlert(Alert.AlertType.ERROR,"Username or Password is wrong!");
        } else if (flag == 6) {
            Navigator.getInstance().showAlert(Alert.AlertType.ERROR,"Password must be between 8 and 20 characters. Include numbers, lowercase letters, uppercase letters and do not contain special characters");
        }
    }
    //Send mail . Don't Delete this.
/*   public void sendMail() throws Exception{
       Properties properties = new Properties();
       properties.put("mail.smtp.auth", true);
       properties.put("mail.smtp.host","smtp.gmail.com");
       properties.put("mail.smtp.port", 587);
       properties.put("mail.smtp.starttls.enable",true);
       properties.put("mail.transport.protocl", "smtp");

       Session session = Session.getInstance(properties , new Authenticator() {
           @Override
           protected PasswordAuthentication  getPasswordAuthentication(){
            return new PasswordAuthentication("", "");
           }
       });
       Message message = new MimeMessage(session);
       message.setSubject("Email from luan");

       Address addressTo = new InternetAddress("vanluanthcs.com@gmail.com");
       message.setSubject("Meo Meo Meo");
       message.setRecipient(Message.RecipientType.TO, addressTo);
       MimeMultipart multipart = new MimeMultipart();

       MimeBodyPart messageBodyPart= new MimeBodyPart();
       messageBodyPart.setContent("<h1>Hello man</h1>","text/html");
       multipart.addBodyPart(messageBodyPart);
       message.setContent(multipart);

       Transport.send(message);
       
   }  */
}
