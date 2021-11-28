package admin.frontend;

import java.io.IOException;

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
    private static final String LOG_IN = "LogInUI.fxml";
    private static final String BILL_ORDER = "BillOrderUI.fxml";
    private static final String FOOD_MENU = "FoodMenuUI.fxml";
    private static final String SALE_DETAILS = "SaleDetailsUI.fxml";
    private static final String TABLE_MAP = "tablefrontend/TableMapUI2.fxml";
    private static final String ADMINHOME = "AdminHomeUI2.fxml";
    private static final String ACCOUNT_HOME = "frontend/AccountHomeUI2.fxml";

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
        alert.show();
    }

    public void translateSideBarPlus(Pane pane1, Pane pane2, AnchorPane paneTranslate) {
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(Duration.seconds(0.5));
        translateTransition.setNode(paneTranslate);
        translateTransition.setToX(0);
        translateTransition.play();
        paneTranslate.setTranslateX(-600);
        translateTransition.setOnFinished(event -> {
            pane1.setVisible(false);
            pane2.setVisible(true);
        });
    }
    public void translateSideBarMinus(Pane pane1, Pane pane2, AnchorPane paneTranslate) {
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(Duration.seconds(0.3));
        translateTransition.setNode(paneTranslate);
        translateTransition.setToX(-770);
        translateTransition.play();
        paneTranslate.setTranslateX(0);
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
}
