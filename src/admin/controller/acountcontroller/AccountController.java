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
    private Button btnMessage;

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
    private Button btnMainMessage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
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
    void onClickMainMessage(ActionEvent event) {

    }

    @FXML
    void onClickMainSearch(ActionEvent event) {

    }

    @FXML
    void onClickMessage(ActionEvent event) {

    }

    @FXML
    void onClickSearch(ActionEvent event) {

    }

    @FXML
    void onClickTableView(MouseEvent event) {

    }
}
