package yummycode.employee.controller;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import yummycode.admin.databasehelper.FoodManagerDBHelper;
import yummycode.admin.frontend.Navigator;
import yummycode.model.FoodItem_model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class FoodMenuController implements Initializable {

    @FXML
    private StackPane paneTranslate;

    @FXML
    private VBox ContentPane;

    @FXML
    private GridPane gridPane;


    @FXML
    private StackPane paneShowFoodOrder;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            int row = 1;
            int col = 0;
            List<FoodItem_model> listItems = new ArrayList<>(FoodManagerDBHelper.getAllItemFood());
            for (FoodItem_model foodItem_model : listItems) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("../../frontend/foodfrontend/FoodItemUI.fxml"));
                VBox vBox = fxmlLoader.load();
                FoodItemController setItem = fxmlLoader.getController();
                setItem.setData(foodItem_model);

                if (col == 5) {
                    col = 0;
                    ++row;
                }
                gridPane.add(vBox, col++, row);
                gridPane.setMargin(vBox, new Insets(12));;
            }
        } catch (Exception e) {
            
        }
    }

    @FXML
    void onclickBill(ActionEvent event) {

    }

    @FXML
    void onclickDessert(ActionEvent event) {

    }

    @FXML
    void onclickDrinks(ActionEvent event) {

    }

    @FXML
    void onclickFoodMain(ActionEvent event) {

    }

    @FXML
    void onclickHotPot(ActionEvent event) {

    }

    @FXML
    void onclickMenu(ActionEvent event) {

    }

    @FXML
    void onclickPosition(ActionEvent event) {

    }

    @FXML
    void onclickSalad(ActionEvent event) {

    }
}
