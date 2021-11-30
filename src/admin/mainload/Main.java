package admin.mainload;

import java.io.IOException;

import javax.mail.MessagingException;

import admin.databasehelper.AccountDBHelper;
import admin.frontend.Navigator;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main  extends Application{
    public static void main(String[] args) throws MessagingException {
      launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        //stage.initStyle(StageStyle.TRANSPARENT);
        Navigator.getInstance().setState(stage);
        Navigator.getInstance().goToAccountHome();
    } 
}
