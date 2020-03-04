package mpplibrary.gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MessagePopup {
    public static void displayError(String message) {
        Stage stage = new Stage();
        stage.setTitle("Error");
        stage.setAlwaysOnTop(true);
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().add(new Text(message));
        stage.setScene(new Scene(vBox, 300, 100));
        stage.show();
    }

    public static void displaySuccess(String message) {
        Stage stage = new Stage();
        stage.setTitle("Success");
        stage.setAlwaysOnTop(true);
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().add(new Text(message));
        stage.setScene(new Scene(vBox, 300, 100));
        stage.show();
    }
}
