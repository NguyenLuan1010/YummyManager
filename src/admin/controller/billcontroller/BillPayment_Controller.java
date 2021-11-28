package admin.controller.billcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import admin.databasehelper.BillOrderDBHelper;
import admin.model.BillOrder_Model;
import admin.model.BillPayment_Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class BillPayment_Controller implements Initializable {

    public static BillOrder_Model billPay;

    @FXML
    private TableView<BillPayment_Model> tblBillPay;

    @FXML
    private TableColumn<BillPayment_Model, String> colNameFood;

    @FXML
    private TableColumn<BillPayment_Model, Integer> colAmount;

    @FXML
    private TableColumn<BillPayment_Model, Integer> colUnitPrice;

    @FXML
    private TableColumn<BillPayment_Model, Integer> colIntoMoney;

    // -----------------------

    @FXML
    private Label billCode;

    @FXML
    private Label date;

    @FXML
    private Label cashier;

    @FXML
    private Label table;

    @FXML
    private Label total;

    @FXML
    private Label voucher;

    @FXML
    private Label totalPay;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setData();
        setDataForTable();
        System.out.println(billPay.getSUMOFPRICES());
    }

    private void setData() {
        billCode.setText(billPay.getBILLID());
        date.setText(billPay.getDATETIME());
        cashier.setText("Tran Dinh Nam");
        table.setText(billPay.getTABLEID());
    }

    private void setDataForTable() {

        ObservableList<BillPayment_Model> billDetail = FXCollections.observableArrayList();

        billDetail.addAll(BillOrderDBHelper.getDataForBill(billPay.getDETAILBILLID()));
        
        tblBillPay.setItems(billDetail);

        colNameFood.setCellValueFactory(new PropertyValueFactory<>("FOODNAME"));

        colAmount.setCellValueFactory(new PropertyValueFactory<>("FOODQUANTITY"));

        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("FOODPRICE"));

        colIntoMoney.setCellValueFactory(new PropertyValueFactory<>("SUMOFPRICE"));

    }

}
