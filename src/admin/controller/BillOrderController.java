package admin.controller;
import java.io.IOException;

import admin.frontend.Navigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class BillOrderController {
    @FXML
    private TableView<?> tblBillOrder;

    @FXML
    private TableColumn<?, ?> tcDateTime;

    @FXML
    private TableColumn<?, ?> tcBillCode;

    @FXML
    private TableColumn<?, ?> tcTableID;

    @FXML
    private TableColumn<?, ?> tcTotalOfDishes;

    @FXML
    private TableColumn<?, ?> tcPrice;

    @FXML
    private TableColumn<?, ?> tcStatus;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnSeeDetails;

    @FXML
    private Button btnSortBy;

    @FXML
    private Button btnSetStatus;

    @FXML
    private TextField txtSearch;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnSearch;

    @FXML
    void onClickBack(ActionEvent event) throws IOException {
        Navigator.getInstance().goToAdminHome();
    }

    @FXML
    void onClickCancel(ActionEvent event) {
         System.exit(0);
    }

    @FXML
    void onClickSearch(ActionEvent event) {

    }

    @FXML
    void onClickSeeDetails(ActionEvent event) {

    }

    @FXML
    void onClickSetStatus(ActionEvent event) {

    }

    @FXML
    void onClickSortBy(ActionEvent event) {

    }
}
