package admin.controller;
import java.io.IOException;

import admin.databasehelper.AccountDBHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AdminFormController {
    @FXML
    private AnchorPane Pane_AdminForm;

    @FXML
    private TextField txtPhoneNumber;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Button btnLogIn1;

    @FXML
    private Button btnForgotAccount;

    @FXML
    void onClickForgotAccount(ActionEvent event) {
      
    }

    @FXML
    void onClickLogIn(ActionEvent event) throws IOException {
         String phone = txtPhoneNumber.getText();
        String password = txtPassword.getText();
        AccountDBHelper.AdminLoginIn(phone, password); 
    }
  
}