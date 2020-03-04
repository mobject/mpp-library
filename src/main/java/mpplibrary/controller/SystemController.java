package mpplibrary.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mpplibrary.MPPFXMLLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SystemController {
    public PasswordField passwordField;
    public TextField userIdField;
    @FXML
    private Button loginButton;

    public void login(javafx.event.ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new MPPFXMLLoader(getClass().getResource("../gui/home.fxml"));
        Scene scene = ((Button) actionEvent.getSource()).getScene();
        Stage primaryStage = (Stage) (scene.getWindow());
        GridPane pane = fxmlLoader.load();

        Scene newScene = new Scene(pane, 800, 500);
        primaryStage.setScene(newScene);
    }


}
