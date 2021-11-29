package admin.controller.billcontroller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.NavigableMap;
import java.util.ResourceBundle;

import admin.databasehelper.BillOrderDBHelper;
import admin.frontend.Navigator;
import admin.model.BillOrder_Model;
import admin.model.BillPayment_Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class BillOrderController implements Initializable {
    @FXML
    private AnchorPane MainPane;
    
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
    private TableColumn<BillOrder_Model, String> tcAction;
    @FXML
    private Pane paneSlide1;

    @FXML
    private Button btnBack1;

    @FXML
    private Button btnMainSearch;

    @FXML
    private Pane paneSlide2;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnSearch;

    @FXML
    private AnchorPane paneTranslate;

    @FXML
    private Button btnApply;

    @FXML
    private Button btnCancel;

    @FXML
    private StackPane bill;

    @FXML
    private DatePicker dateStart;

    @FXML
    private DatePicker dateEnd;

    ObservableList<BillOrder_Model> listBill = FXCollections.observableArrayList(BillOrderDBHelper.getAllBillOrder());

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        
        setDataForCellTblBillOrder(listBill,tblBillOrder);
        onclickSeeDetailBill();

        
    }

    @FXML
    void onClickBack(ActionEvent event) throws IOException {
        Navigator.getInstance().goToAdminHome2();
    }

    @FXML
    void onClickCancel(ActionEvent event) {
        System.exit(0);
    }


    private void setDataForCellTblBillOrder(ObservableList<BillOrder_Model> data, TableView<BillOrder_Model> tableView) {
        tblBillOrder.setItems(data);
        tcBillCode.setCellValueFactory(new PropertyValueFactory<BillOrder_Model,String>("BILLID"));

        tcDateTime.setCellValueFactory(new PropertyValueFactory<BillOrder_Model,String>("DATETIME"));

        txTbaleID.setCellValueFactory(new PropertyValueFactory<BillOrder_Model,String>("TABLEID"));

        txDetailBillID.setCellValueFactory(new PropertyValueFactory<BillOrder_Model,String>("DETAILBILLID"));

        txSumOfPrice.setCellValueFactory(new PropertyValueFactory<BillOrder_Model,String>("SUMOFPRICES"));

        tcAction.setCellValueFactory(new PropertyValueFactory<BillOrder_Model,String>("SEEDETAIL"));
    }

    private void onclickSeeDetailBill() {
        BillOrder_Model.SEEDETAIL.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                BillPayment_Controller.billPay = tblBillOrder.getSelectionModel().getSelectedItem();
                Navigator.getInstance().translateSideBarPlus(paneSlide1, paneSlide2, paneTranslate, 0, -600);
                Navigator.getInstance().changePage(bill, "../frontend/BillPayment.fxml");
            }
        });
    }
    @FXML
    void onClickMainSearch(ActionEvent event) {

    }

    @FXML
    void onClickSearch(ActionEvent event) {

    }
}
