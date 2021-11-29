package admin.controller.acountcontroller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import admin.databasehelper.AccountDBHelper;
import admin.frontend.Navigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class AddNewAccountController implements Initializable{

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
        // cbStatus.getItems().add("Lock");
        // cbStatus.getItems().add("UnLock");
        // cbStatus.setValue("UnLock");

        cbType.getItems().add("Admin");
        cbType.getItems().add("Employee");
        cbType.setValue("Employee");
        
    }
    @FXML
    void onClickSubmit(ActionEvent event) throws IOException {
        String IdAcc =  "#"+String.valueOf(Navigator.getInstance().random(10000));
        boolean resultUpdate = AccountDBHelper.addNewAccount(IdAcc,txtName.getText(), txtEmail.getText(), txtPassword.getText(), cbType.getValue());
        if (resultUpdate) {
            Navigator.getInstance().showAlert(AlertType.INFORMATION, "Add new acc Completed");
            Navigator.getInstance().goToAccountHome();
        }else{
            Navigator.getInstance().showAlert(AlertType.ERROR, "Add new acc failed");
        }
    }

}
