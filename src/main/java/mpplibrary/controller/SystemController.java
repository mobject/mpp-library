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

import java.io.IOException;

public class SystemController {
    public PasswordField passwordField;
    public TextField userIdField;
    @FXML
    private Button loginButton;

    public void login(javafx.event.ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../gui/home.fxml"));
        GridPane gridPane = fxmlLoader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(gridPane, 800, 500);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(scene);
        stage.show();
    }


}
