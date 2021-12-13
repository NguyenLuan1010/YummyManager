package yummycode.employee.controller.tablecontroller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import yummycode.admin.frontend.Navigator;
import yummycode.employee.controller.FoodItemController;
import yummycode.employee.controller.FoodMenuController;
import yummycode.employee.controller.paymentcontroller.Payment_controller;
import yummycode.employee.databasehelper.FoodManagerDBHelper;
import yummycode.model.TableMap;

public class TableItem_controller  {

    TableMap infTbl;
    String codeBill;

    @FXML
    private Button textButton;

    @FXML
    void onclickChooseTable(ActionEvent event) throws IOException {
        String addBillCode = FoodManagerDBHelper.getBillCodeOfTable(infTbl.getTableID());
        if (addBillCode == null) {
            codeBill = Navigator.randomAlphaNumeric(4);
            Navigator.getInstance().goTableMapFoodMenu(infTbl, codeBill);
        }else{
            Navigator.getInstance().goTableMapFoodMenu(infTbl, addBillCode);
        }
        // Payment_controller.idTable = infTbl.getTableID();
        
        
    }

    public void setData(TableMap tbl)
    {
        textButton.setText(tbl.getTableID());
        infTbl = tbl;
        
    }

}
