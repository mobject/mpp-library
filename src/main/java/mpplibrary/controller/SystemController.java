package mpplibrary.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mpplibrary.MPPFXMLLoader;
import mpplibrary.model.User;
import mpplibrary.service.UserService;
import mpplibrary.service.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SystemController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserSession userSession;

    @FXML
    private Text errorMessage;
    @FXML
    public PasswordField passwordField;
    @FXML
    public TextField userIdField;

    public void login(javafx.event.ActionEvent actionEvent) throws IOException {
        try {
            User user = userService.checkLogin(userIdField.getText(), passwordField.getText());
            userSession.setUser(user);
            FXMLLoader fxmlLoader = new MPPFXMLLoader(getClass().getResource("../gui/home.fxml"));
            Scene scene = ((Button) actionEvent.getSource()).getScene();
            Stage primaryStage = (Stage) (scene.getWindow());
            GridPane pane = fxmlLoader.load();
            Scene newScene = new Scene(pane, 800, 500);
            primaryStage.setScene(newScene);
        } catch (Exception e) {
            e.printStackTrace();
            errorMessage.setText(e.getMessage());
        }
    }
}
