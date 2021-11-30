package admin.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import javax.mail.MessagingException;

import admin.databasehelper.AccountDBHelper;
import admin.frontend.Navigator;
import admin.model.Account;
import javafx.fxml.Initializable;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Node;

public class SignInController implements Initializable {
  @FXML
  private AnchorPane paneTranslate;

  @FXML
  private TextField txtShowPassword;

  @FXML
  private AnchorPane Pane_AdminForm;

  @FXML
  private TextField txtEmail;

  @FXML
  private PasswordField txtPassword;

  @FXML
  private Button btnLogIn;

  @FXML
  private Button btnForgotAccount;

  @FXML
  private Button btnCancel;

  @FXML
  private Button btnHidden;

  @FXML
  private Pane panePasswordHidden;

  @FXML
  private Button btnPasswordHidden;

  @FXML
  private Pane panePasswordShow;

  @FXML
  private Button btnPasswordShow;

  @FXML
  private Pane paneSeeDetail;

  @FXML
  private Button btnSeeDetail;

  @FXML
  private Pane paneLogInIcon;

  @FXML
  private Button btnLoginIcon;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    txtShowPassword.setVisible(false);
    txtPassword.setVisible(true);
    paneLogInIcon.setVisible(false);
    panePasswordShow.setVisible(false);
    panePasswordHidden.setVisible(true);
    paneTranslate.setTranslateX(0);

  }

  @FXML
  void onClickCancel(ActionEvent event) {
    System.exit(0);
  }

  @FXML
  void onClickForgotAccount(ActionEvent event) throws IOException, MessagingException {
    String email = txtEmail.getText();
    int flag = 1;
    List<Account> listAccount = AccountDBHelper.getAllAccount();
    if (email.isEmpty()) {
      Navigator.getInstance().goToConfirmEmail();
    } else {
      String emailCheck  = " ";
      loop: for (int i = 0 ; i < listAccount.size() ;i++) {
         emailCheck = listAccount.get(i).getEmail();
      }
      if (!AccountDBHelper.checkEmailRegex(email)) {
        Navigator.getInstance().showAlert(AlertType.ERROR, "Email is invalid.Please enter email again!");
      } else if (!email.equals(emailCheck)) {
        Navigator.getInstance().showAlert(AlertType.ERROR, "Email is Wrong!");
      }else {
        AccountDBHelper.sendMail(email);
      }
    }
  }

  @FXML
  void onClickHidden(ActionEvent event) {
    Object Node;
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setIconified(true);
  }

  @FXML
  void onClickLogIn(ActionEvent event) {

  }

  @FXML
  void onClickLoginIcon(ActionEvent event) {
    Navigator.getInstance().translateSideBarMinus(paneSeeDetail, paneLogInIcon, paneTranslate, 0, -470);
  }

  @FXML
  void onClickPasswordHidden(ActionEvent event) {
    txtShowPassword.setVisible(true);
    txtPassword.setVisible(false);
    txtShowPassword.setText(txtPassword.getText());
    panePasswordHidden.setVisible(false);
    panePasswordShow.setVisible(true);
  }

  @FXML
  void onClickPasswordShow(ActionEvent event) {
    txtPassword.setVisible(true);
    txtShowPassword.setVisible(false);
    txtPassword.setText(txtShowPassword.getText());
    panePasswordShow.setVisible(false);
    panePasswordHidden.setVisible(true);
  }

  @FXML
  void onClickSeeDetail(ActionEvent event) {
    Navigator.getInstance().translateSideBarPlus(paneSeeDetail, paneLogInIcon, paneTranslate, 470, 0);
  }

}
