package admin.controller;
import java.io.IOException;

import admin.frontend.Navigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
public class AccountController {
    @FXML
    private TableView<?> tblAccountScene;

    @FXML
    private TableColumn<?, ?> tcName;

    @FXML
    private TableColumn<?, ?> tcPhoneNumber;

    @FXML
    private TableColumn<?, ?> tcPassword;

    @FXML
    private TableColumn<?, ?> tcType;

    @FXML
    private TableColumn<?, ?> tcStatus;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnAddAccount;

    @FXML
    private Button btnEditAccount;

    @FXML
    private Button btnDeleteAccount;

    @FXML
    private Button btnUnlockAccount;

    @FXML
    private Button btnLockAccount;

    @FXML
    private Button btnCancel;

    @FXML
    private TextField txtSearch;

    @FXML
    private Button btnSearch;

    @FXML
    void onClickAddAccount(ActionEvent event) {

    }

    @FXML
    void onClickBack(ActionEvent event) throws IOException {
        Navigator.getInstance().goToAdminHome();
    } 

    @FXML
    void onClickCancel(ActionEvent event) {
       System.exit(0);
    }

    @FXML
    void onClickDeleteAccount(ActionEvent event) {

    }

    @FXML
    void onClickEditAccount(ActionEvent event) {

    }

    @FXML
    void onClickLockAccount(ActionEvent event) {

    }

    @FXML
    void onClickSearch(ActionEvent event) {

    }

    @FXML
    void onClickUnlockAccount(ActionEvent event) {

    }
}
