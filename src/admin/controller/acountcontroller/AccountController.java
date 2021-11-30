package admin.controller.acountcontroller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import admin.databasehelper.AccountDBHelper;
import admin.frontend.Navigator;
import admin.model.Account;
import javafx.beans.value.ObservableValueBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class AccountController implements Initializable {

    @FXML
    private AnchorPane MainPane;

    @FXML
    private TableView<Account> tblAccount;

    @FXML
    private TableColumn<Account, String> tcAccountID;

    @FXML
    private TableColumn<Account, String> tcName;

    @FXML
    private TableColumn<Account, String> tcEmail;

    @FXML
    private TableColumn<Account, String> tcPassword;

    @FXML
    private TableColumn<Account, String> tcType;

    @FXML
    private TableColumn<Account, String> tcStatus;

    @FXML
    private AnchorPane paneTranslate;

    @FXML
    private StackPane contentArea;

    @FXML
    private Pane paneSlide2;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnBack;

    @FXML
    private Pane paneSlide1;

    @FXML
    private Button btnMainEdit;

    @FXML
    private Button btnMainSearch;

    @FXML
    private Button btnMainAdd;

    @FXML
    private Button btnBack1;

    @FXML
    private AnchorPane paneSearchTranslate;

    @FXML
    private TextField txtSearch;

    @FXML
    private Button btnTopSearch;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnMainDelete;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        paneSearchTranslate.setTranslateY(-300);

        Navigator.getInstance().translateSideBarMinus(paneSlide1, paneSlide2, paneTranslate, -770, 0);
        getAllAccount();

    }

    @FXML
    void onClickAdd(ActionEvent event) {
        Navigator.getInstance().translateSideBarMinus(paneSlide1, paneSlide2, paneTranslate, -770, 0);
    }

    @FXML
    void onClickBack(ActionEvent event) {

    }

    @FXML
    void onClickEdit(ActionEvent event) {
        Navigator.getInstance().translateSideBarMinus(paneSlide1, paneSlide2, paneTranslate, -770, 0);
        
    }

    @FXML
    void onClickMainAdd(ActionEvent event) {
        Navigator.getInstance().translateSideBarPlus(paneSlide1, paneSlide2, paneTranslate, 0, -600);
        Navigator.getInstance().changePage(contentArea, "../frontend/accountfrontend/AddNewAccount.fxml");
    }

    @FXML
    void onClickMainEdit(ActionEvent event) {
        Account Acc = tblAccount.getSelectionModel().getSelectedItem();
        if (Acc != null) {
            EditAccountController.Account = Acc;
            Navigator.getInstance().translateSideBarPlus(paneSlide1, paneSlide2, paneTranslate, 0, -600);
            Navigator.getInstance().changePage(contentArea, "../frontend/accountfrontend/EditAccount.fxml");
        }else{
            Navigator.getInstance().showAlert(AlertType.ERROR, "Choose a Account to edit");
        }

    }

    @FXML
    void onClickMainSearch(ActionEvent event) {
        Navigator.getInstance().translateSideYBarPlus(paneSlide1, paneSlide2, paneSearchTranslate,0, -300);
    }

    @FXML
    void onClickSearch(ActionEvent event) {
        Navigator.getInstance().translateSideYBarMinus(paneSlide1,paneSlide2, paneSearchTranslate,-300,0);
    }

    @FXML
    void onClickTableView(MouseEvent event) {
        Navigator.getInstance().translateSideYBarMinus(paneSlide1,paneSlide2, paneSearchTranslate,-300,0);
    }

    @FXML
    void onClickTopSearch(ActionEvent event) {

    }

    @FXML
    void onClickDelete(ActionEvent event) {

    }

    @FXML

    void onClickMainDelete(ActionEvent event) {

    }
    private void getAllAccount() {
        ObservableList<Account> listAcc = FXCollections.observableArrayList(AccountDBHelper.getAllAccount());
        tblAccount.setItems(listAcc);
        tcAccountID.setCellValueFactory(CellData -> CellData.getValue().getIdProperty());
        tcEmail.setCellValueFactory(CellData -> CellData.getValue().getEmailProperty());
        tcName.setCellValueFactory(CellData -> CellData.getValue().getUserNameProperty());
        tcPassword.setCellValueFactory(CellData -> CellData.getValue().getPasswordProperty());
        tcStatus.setCellValueFactory(CellData -> CellData.getValue().getStatusProperty());
        tcType.setCellValueFactory(CellData -> CellData.getValue().getTypeProperty());


    }


}
