package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class HomeController {

    @FXML
    private Button checkoutButton;

    public void checkoutPressed(ActionEvent actionEvent) throws IOException {

    }

    public void checkoutAction(javafx.event.ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/checkout.fxml"));
        Stage vBox = fxmlLoader.load();
//        Stage stage = new Stage();
//        stage.initModality(Modality.WINDOW_MODAL);
//        Scene scene = new Scene(vBox);
//        stage.setScene(scene);
//        stage.setTitle("Checkout Book");
//        stage.show();
        vBox.show();
    }
}
