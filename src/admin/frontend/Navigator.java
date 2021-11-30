package admin.frontend;

import java.io.IOException;
import java.util.Random;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Navigator {

    private static Navigator navigator;
    private Stage state;
    private FXMLLoader fxmlloader;
    private static final String LOG_IN = "loginfrontend/LogInUI.fxml";


    private static final String BILL_ORDER = "billfrontend/BillOrderUI2.fxml";
    private static final String FOOD_MENU = "foodfrontend/FoodMenuUI.fxml";
    private static final String SALE_DETAILS = "salefrontend/SaleDetailsUI.fxml";

    private static final String TABLE_MAP = "tablefrontend/TableMapUI2.fxml";
    private static final String ADMINHOME = "AdminHomeUI2.fxml";
    private static final String ACCOUNT_HOME = "accountfrontend/AccountHomeUI2.fxml";
    private static final String CONFIRM_EMAIL = "loginfrontend/confirmEmail.fxml";
    public Navigator() {

    }

    public static Navigator getInstance() {
        if (navigator == null) {
            navigator = new Navigator();
        }
        return navigator;
    }

    public void setState(Stage state) {
        navigator.state = state;
    }

    public void goToLOGIN() throws IOException {
        goToScene("Log In", LOG_IN);
    }


    public void goToBillOrder() throws IOException {
        goToScene("Bill", BILL_ORDER);
    }

    public void goToFoodMenu() throws IOException {
        goToScene("Food", FOOD_MENU);
    }

    public void goToSaleDetails() throws IOException {
        goToScene("Sale", SALE_DETAILS);
    }

    public void goToTableMap() throws IOException {
        goToScene("Table", TABLE_MAP);
    }
    public void goToAdminHome2() throws IOException {
        goToScene("AddNewTable", ADMINHOME);
    }
    public void goToAccountHome() throws IOException {
        goToScene("AcountHome", ACCOUNT_HOME);
    }
    public void goToConfirmEmail() throws IOException {
        goToScene("Confirm Email", CONFIRM_EMAIL);
    }
    
    // Change page on a Scene
    public void changePage(StackPane contentArea, String source) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(source));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(root);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // This alert will show when this function is called.
    public void showAlert(AlertType type, String title) {
        Alert alert = new Alert(type);
        alert.setContentText(title);
        alert.showAndWait();
    }


    public void translateSideBarPlus(Pane pane1, Pane pane2, AnchorPane paneTranslate, int ToX, int TranX) {
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(Duration.seconds(0.5));
        translateTransition.setNode(paneTranslate);
        translateTransition.setToX(ToX);
        translateTransition.play();
        paneTranslate.setTranslateX(TranX);

        translateTransition.setOnFinished(event -> {
            pane1.setVisible(false);
            pane2.setVisible(true);
        });
    }


    //Minus Translate X
    public void translateSideBarMinus(Pane pane1, Pane pane2, AnchorPane paneTranslate,int ToX, int TranX) {
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(Duration.seconds(0.3));
        translateTransition.setNode(paneTranslate);
        translateTransition.setToX(ToX);/*-770*/
        translateTransition.play();
        paneTranslate.setTranslateX(TranX);/*0*/
        translateTransition.setOnFinished(event -> {
            pane1.setVisible(true);
            pane2.setVisible(false);
        });
    }
    //Plus Translate Y
    public void translateSideYBarPlus(Pane pane1, Pane pane2, AnchorPane paneTranslate,int ToX, int TranX) {
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(Duration.seconds(0.5));
        translateTransition.setNode(paneTranslate);
        translateTransition.setToY(ToX);/*0*/
        translateTransition.play();
        paneTranslate.setTranslateY(TranX);/*-600*/
        translateTransition.setOnFinished(event -> {
            pane1.setVisible(false);
            pane2.setVisible(true);
        });
    }
    //Minus Translate Y
    public void translateSideYBarMinus(Pane pane1, Pane pane2, AnchorPane paneTranslate,int ToY, int TranY) {
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(Duration.seconds(0.5));
        translateTransition.setNode(paneTranslate);
        translateTransition.setToY(ToY);/*-770*/
        translateTransition.play();
        paneTranslate.setTranslateY(TranY);
        translateTransition.setOnFinished(event -> {
            pane1.setVisible(true);
            pane2.setVisible(false);
        });
    }
    // Function for change page.
    public void goToScene(String title, String URL) throws IOException {
        fxmlloader = new FXMLLoader(getClass().getResource(URL));
        Parent root = fxmlloader.load();
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        state.setTitle(title);
        state.setScene(scene);
        if (!state.isShowing()) {
            state.show();
        }
    }

    public int random(int number)
    {
        Random random = new Random();
        int randomID = random.nextInt(number)+10000;
        return randomID;
    }
}
