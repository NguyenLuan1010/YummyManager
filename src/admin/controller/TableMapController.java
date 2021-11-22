package admin.controller;
import java.io.IOException;

import admin.frontend.Navigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
public class TableMapController {
    @FXML
    private TableView<?> tblTableMap;

    @FXML
    private TableColumn<?, ?> tcTableID;

    @FXML
    private TableColumn<?, ?> tcSitesNumber;

    @FXML
    private TableColumn<?, ?> tcFloorNumber;

    @FXML
    private TableColumn<?, ?> tcStatus;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnSortBy;

    @FXML
    private Button btnSetStatus;

    @FXML
    private TextField txtSearch;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnCancel;

    @FXML
    void onClickAdd(ActionEvent event) {

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
    void onClickEdit(ActionEvent event) {

    }

    @FXML
    void onClickSearch(ActionEvent event) {

    }

    @FXML
    void onClickSetStatus(ActionEvent event) {

    }

    @FXML
    void onClickSortBy(ActionEvent event) {

    }
}
