package yummycode.employee.controller.paymentcontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class PaymentItem_controller {

    @FXML
    private Label TotalPrice;

    @FXML
    private Label tableID;

    @FXML
    private Label member;

    @FXML
    void onclickItem(MouseEvent event) {
        Payment_controller.idTable = tableID.getText();
    }

    public void loadData(double price, String idTbl, int seat) {
        TotalPrice.setText(String.valueOf(price));
        tableID.setText(idTbl);
        member.setText(String.valueOf(seat));
    }

}
