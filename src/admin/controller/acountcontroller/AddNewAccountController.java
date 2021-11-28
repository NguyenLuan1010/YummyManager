package admin.controller.acountcontroller;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class AddNewAccountController implements Initializable{
    @FXML
    private TextField txtAccountID;

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
        
    }
    @FXML
    void onClickSubmit(ActionEvent event) {

    }

}
