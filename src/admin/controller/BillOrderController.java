package admin.controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import admin.databasehelper.BillOrderDBHelper;
import admin.frontend.Navigator;
import admin.model.BillDetail_Model;
import admin.model.BillOrder_Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class BillOrderController implements Initializable {
    @FXML
    private TableView<BillOrder_Model> tblBillOrder;

    @FXML
    private TableColumn<BillOrder_Model, String> tcBillCode;

    @FXML
    private TableColumn<BillOrder_Model, String> tcDateTime;

    @FXML
    private TableColumn<BillOrder_Model, String> txTbaleID;

    @FXML
    private TableColumn<BillOrder_Model, String> txDetailBillID;

    @FXML
    private TableColumn<BillOrder_Model, String> txSumOfPrice;

    @FXML
    private TableColumn<BillOrder_Model, String> tcStatus;

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

    ObservableList<BillOrder_Model> listBill = FXCollections.observableArrayList();

    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listBill.addAll(BillOrderDBHelper.getAllBillOrder());
        tblBillOrder.setItems(listBill);

        tcBillCode.setCellValueFactory(new PropertyValueFactory<>("BILLID"));
        
        tcDateTime.setCellValueFactory(new PropertyValueFactory<>("DATETIME"));
        
        txTbaleID.setCellValueFactory(new PropertyValueFactory<>("TABLEID"));
        
        txDetailBillID.setCellValueFactory(new PropertyValueFactory<>("DETAILBILLID"));
        
        txSumOfPrice.setCellValueFactory(new PropertyValueFactory<>("SUMOFPRICES"));
        
        tcStatus.setCellValueFactory(new PropertyValueFactory<>("BILLSTATUS"));

        
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
