package admin.controller.acountcontroller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import admin.databasehelper.AccountDBHelper;
import admin.frontend.Navigator;
import admin.model.Account;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class EditAccountController implements Initializable {

    public static Account Account;

    @FXML
    private ChoiceBox<String> cbStatus;

    @FXML
    private Button btnSubmit;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtName;

    @FXML
    private ChoiceBox<String> cbType;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbStatus.getItems().add("Lock");
        cbStatus.getItems().add("UnLock");
        cbStatus.setValue("UnLock");

        cbType.getItems().add("Admin");
        cbType.getItems().add("Employee");
        cbType.setValue("Employee");

        loadData(Account);

    }

    @FXML
    void onClickSubmit(ActionEvent event) throws IOException {
        boolean resultUpdate = AccountDBHelper.EditAccount(txtName.getText(), txtEmail.getText(), txtPassword.getText(),
                cbType.getValue(), cbStatus.getValue(), Account.getId());
        if (resultUpdate) {
            Navigator.getInstance().showAlert(AlertType.INFORMATION, "Edit acc Completed");
            Navigator.getInstance().goToAccountHome();
        } else {
            Navigator.getInstance().showAlert(AlertType.ERROR, "Edit acc failed");
        }
    }

    public void loadData(Account Acc) {
        cbStatus.setValue(Acc.getStatus());
        cbType.setValue(Acc.getType());
        txtName.setText(Acc.getUserName());
        txtPassword.setText(Acc.getPassword());
        txtEmail.setText(Acc.getEmail());

    }

}
