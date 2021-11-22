package admin.frontend;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Navigator {
    
    private static Navigator navigator;
    private Stage state;
    private FXMLLoader fxmlloader;
    private static double x=0;
    private static double y=0;
    private static final String LOG_IN = "LogInUI.fxml";
    private static final String ADMIN_HOME = "AdminHomeUI.fxml";
    private static final String ACCOUNT_SCENE = "AccountSceneUI.fxml";
    private static final String BILL_ORDER = "BillOrderUI.fxml";
    private static final String FOOD_MENU = "FoodMenuUI.fxml";
    private static final String SALE_DETAILS = "SaleDetailsUI.fxml";
    private static final String TABLE_MAP = "TableMapUI.fxml";
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
    public void goToAdminHome() throws IOException {
        goToScene("Admin Home", ADMIN_HOME);
    }
    public void goToAccountScene() throws IOException {
        goToScene("Account", ACCOUNT_SCENE);
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
    //Change page on a Scene
    public void changePage(StackPane contentArea, String source){
        try {
            Parent root  = FXMLLoader.load(getClass().getResource(source));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(root);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //This alert will show when this function is called.
   public void showAlert(AlertType type, String title){
    Alert alert = new Alert(type);
    alert.setContentText(title);
    alert.show();
   }
   //Function for change page.
    public void goToScene(String title, String URL) throws IOException {
      fxmlloader = new FXMLLoader(getClass().getResource(URL));
        Parent root = fxmlloader.load();
        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {
            navigator.state.setX(event.getSceneX() - x);
            navigator.state.setY(event.getSceneY() - y);
        });
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        state.setTitle(title);
        state.setScene(scene);
        if (!state.isShowing()) {
            state.show();
        }
    }
}
