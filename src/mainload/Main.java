package mainload;
import java.io.IOException;

import frontend.Navigator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application{
    public static void main(String[] args)  {
       launch(args);
    }
    @Override
    public void start(Stage stage) throws IOException{
        stage.initStyle(StageStyle.TRANSPARENT);
        Navigator.getInstance().setState(stage);
        Navigator.getInstance().goToLOGIN();
    }   
}
