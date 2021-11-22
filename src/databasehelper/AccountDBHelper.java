package databasehelper;

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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import frontend.Navigator;
import javafx.scene.control.Alert;
import model.Account;

public class AccountDBHelper {
    public static List<Account> getAllAccount() {
        List<Account> listAcc = new ArrayList<>();
       
        try (Connection connect = ConnectDBHelper.getConnect();
        CallableStatement stm  = connect.prepareCall("{call getAllAccount()}");) {
            stm.execute();
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                String id = rs.getString("ACCOUNTID");
                String username = rs.getString("NAME");
                String phone = rs.getString("PHONENUMBER");
                String password = rs.getString("PASSWORD");
                String type = rs.getString("TYPE");
                String status = rs.getString("STATUS");
                Account acc = new Account(id, username,phone, password, type, status);
                listAcc.add(acc);
            }
        } catch (Exception e) {
            System.out.println("Loi:" + e.getMessage());
        }
        return listAcc;
    }

    public static Boolean checkPhoneRegex(String phone) {
        String regex = "^0(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phone);
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

    public static void AdminLoginIn(String phone, String password) throws IOException {
        int flag = 1;
        System.out.print(checkPasswordRegex(password));
        List<Account> listAccount = AccountDBHelper.getAllAccount();
        loop:
        for (Account acc : listAccount) {
            if (phone.isEmpty() || password.isEmpty()) {
                flag = 3;
            } else if (!checkPhoneRegex(phone)) {
                flag = 5;
            } else {
                if (!checkPasswordRegex(password)) {
                    flag = 6;
                } else if (acc.getStatus().equalsIgnoreCase("Locked")) {
                    flag = 2;
                } else if (!phone.equals(acc.getPhone()) || !password.equals(acc.getPassword())) {
                    flag = 4;
                } else {
                    if (acc.getType().equalsIgnoreCase("Admin")) {
                        Navigator.getInstance().goToAdminHome();
                        break loop;
                    }else{
                        flag = 4;
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
                } else if (!username.equals(acc.getUsername()) || !password.equals(acc.getPassword())) {
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
    public static void sendSMS(String username , String password, String to, String message) throws IOException{

     // This URL is used for sending messages
     String myURI = "https://api.bulksms.com/v1/messages";

     // change these values to match your own account
     String myUsername = ""+username+"";
     String myPassword = ""+password+"";
 
     // the details of the message we want to send
     String myData = "{to: \""+to+"\", encoding: \"UNICODE\", body: \""+message+"\"}";
 
     // if your message does not contain unicode, the "encoding" is not required:
     // String myData = "{to: \"1111111\", body: \"Hello Mr. Smith!\"}";
 
     // build the request based on the supplied settings
     URL url = new URL(myURI);
     HttpURLConnection request = (HttpURLConnection) url.openConnection();
     request.setDoOutput(true);
 
     // supply the credentials
     String authStr = myUsername + ":" + myPassword;
     String authEncoded = Base64.getEncoder().encodeToString(authStr.getBytes());
     request.setRequestProperty("Authorization", "Basic " + authEncoded);
 
     // we want to use HTTP POST
     request.setRequestMethod("POST");
     request.setRequestProperty( "Content-Type", "application/json");
 
     // write the data to the request
     OutputStreamWriter out = new OutputStreamWriter(request.getOutputStream());
     out.write(myData);
     out.close();
 
     // try ... catch to handle errors nicely
     try {
       // make the call to the API
       InputStream response = request.getInputStream();
       BufferedReader in = new BufferedReader(new InputStreamReader(response));
       String replyText;
       while ((replyText = in.readLine()) != null) {
         System.out.println(replyText);
       }
       in.close();
     } catch (IOException ex) {
       System.out.println("An error occurred:" + ex.getMessage());
       BufferedReader in = new BufferedReader(new InputStreamReader(request.getErrorStream()));
       // print the detail that comes with the error
       String replyText;
       while ((replyText = in.readLine()) != null) {
         System.out.println(replyText);
       }
       in.close();
     }
     request.disconnect();
   }
}
