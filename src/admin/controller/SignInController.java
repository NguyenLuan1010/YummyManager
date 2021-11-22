package admin.controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.text.AbstractDocument.Content;

import admin.frontend.Navigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
public class SignInController implements Initializable{
    @FXML
    private Button btnCancel;

    @FXML
    private Button btnHidden;

    @FXML
    private Button btnAdmin;
    
    @FXML
    private Button btnEmployee;
     
    @FXML
    private StackPane contentArea;

    @FXML
    private AnchorPane PaneShow;

    @FXML
    void onClickAdmin(ActionEvent event) throws IOException{
       Navigator.getInstance().changePage(contentArea, "../frontend/AdminFormUI.fxml");
    }

    @FXML
    void onClickCancel(ActionEvent event) {
         System.exit(0);
    }

    @FXML
    void onClickEmployee(ActionEvent event) throws IOException{
        Navigator.getInstance().changePage(contentArea, "../frontend/EmployeeFormUI.fxml");

    }

    @FXML
    void onClickHidden(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Navigator.getInstance().changePage(contentArea, "../frontend/AdminFormUI.fxml");
    }
}
