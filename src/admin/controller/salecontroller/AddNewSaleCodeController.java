package admin.controller.salecontroller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
public class AddNewSaleCodeController {
    @FXML
    private TextField txtSaleCode;

    @FXML
    private ChoiceBox<?> cbStatus;

    @FXML
    private Button btnSubmit;

    @FXML
    private ChoiceBox<?> cbDiscount;

    @FXML
    private DatePicker dpStartDay;

    @FXML
    private DatePicker dpEndDay;

    @FXML
    private TextArea txtDecription;

    @FXML
    void onClickSubmit(ActionEvent event) {

    }

}
