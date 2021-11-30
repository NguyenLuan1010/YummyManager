package admin.controller.acountcontroller;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import admin.databasehelper.AccountDBHelper;
import admin.frontend.Navigator;
import admin.model.Account;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ConfirmEmailController {
    @FXML
    private TextField txtEmail;

    @FXML
    private Button btnOk;

    @FXML
    private Button btnCancel;

    @FXML
    void onClickCancel(ActionEvent event) throws IOException {
        Navigator.getInstance().goToLOGIN();
    }

    @FXML
    void onClickOk(ActionEvent event) throws MessagingException {
        String email = txtEmail.getText();
        int flag = 0;
        List<Account> listAccount = AccountDBHelper.getAllAccount();
        loop: for (Account acc : listAccount) {
            if (email.isEmpty()) {
                  flag = 1;
            }else if(!AccountDBHelper.checkEmailRegex(email)){
                  flag = 2;
            }else if(!email.equals(acc.getEmail())){
                  flag = 3;
            }else{
                  AccountDBHelper.sendMail(email);
                  
            }
        }
    }

}
