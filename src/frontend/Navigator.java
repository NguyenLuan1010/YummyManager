package frontend;

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
    private double x, y;
    private static final String LOG_IN = "LogInUI.fxml";
    private static final String ADMIN_HOME = "AdminHomeUI.fxml";
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
   public void showAlert(AlertType type, String title){
    Alert alert = new Alert(type);
    alert.setContentText(title);
    alert.show();
   }
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
