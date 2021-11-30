package admin.controller.acountcontroller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import admin.frontend.Navigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class AccountController implements Initializable {

    @FXML
    private AnchorPane MainPane;

    @FXML
    private TableView<?> tblAccount;

    @FXML
    private TableColumn<?, ?> tcAccountID;

    @FXML
    private TableColumn<?, ?> tcName;

    @FXML
    private TableColumn<?, ?> tcEmail;

    @FXML
    private TableColumn<?, ?> tcPassword;

    @FXML
    private TableColumn<?, ?> tcType;

    @FXML
    private TableColumn<?, ?> tcStatus;

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
    }

    @FXML
    void onClickAdd(ActionEvent event) {

    }

    @FXML
    void onClickBack(ActionEvent event) {

    }

    @FXML
    void onClickEdit(ActionEvent event) {

    }

    @FXML
    void onClickMainAdd(ActionEvent event) {

    }

    @FXML
    void onClickMainEdit(ActionEvent event) {

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


}
