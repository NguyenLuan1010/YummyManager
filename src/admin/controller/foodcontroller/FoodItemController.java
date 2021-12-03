package admin.controller.foodcontroller;

import admin.model.FoodItem_model;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class FoodItemController {

    @FXML
    private ImageView imgFood;

    @FXML
    private Label FoodName;

    @FXML
    private Label FoodPrice;

    @FXML
    void clickItem(MouseEvent event) {
        System.out.println(FoodName.getText());
    }

    public void setData( FoodItem_model items ) {
        Image img = new Image(getClass().getResourceAsStream("../../image/"+items.getImgFood()));
        imgFood.setImage(img);
        FoodName.setText(items.getNameFood());
        FoodPrice.setText(String.valueOf(items.getPriceFood())+" $");
    }
}
