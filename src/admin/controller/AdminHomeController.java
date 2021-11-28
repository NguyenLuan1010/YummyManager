package admin.controller;

import java.io.IOException;

import admin.frontend.Navigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


public class AdminHomeController {
   
    @FXML
    private Button btnChart;

    @FXML
    private Button btnAccount;

    @FXML
    private Button btnFoodMenu;

    @FXML
    private Button btnTableMap;

    @FXML
    private Button btnBillOrder;

    @FXML
    private Button btnSale;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnLogOut;

    @FXML
    void onClickATableMap(ActionEvent event) throws IOException {
           Navigator.getInstance().goToTableMap();
    }

    @FXML
    void onClickAccount(ActionEvent event) throws IOException {
          
    }

    @FXML
    void onClickBillOrder(ActionEvent event) throws IOException {
          Navigator.getInstance().goToBillOrder();
    }

    @FXML
    void onClickCancel(ActionEvent event) {
          System.exit(0);
    }

    @FXML
    void onClickChart(ActionEvent event) {

    }

    @FXML
    void onClickFoodMenu(ActionEvent event) throws IOException {
         Navigator.getInstance().goToFoodMenu();
    }

    @FXML
    void onClickLogOut(ActionEvent event) throws IOException {
        Navigator.getInstance().goToLOGIN();
    }

    @FXML
    void onClickSale(ActionEvent event) throws IOException {
        Navigator.getInstance().goToSaleDetails();
    }

}
