package admin.mainload;

import java.io.IOException;
import admin.frontend.Navigator;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        // stage.initStyle(StageStyle.TRANSPARENT);
        Navigator.getInstance().setState(stage);
        Navigator.getInstance().goToTableMap();
    }
}
