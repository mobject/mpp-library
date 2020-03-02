package mpplibrary.controller;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mpplibrary.gui.CheckoutRecordForm;
import mpplibrary.gui.EditMemberForm;
import mpplibrary.gui.ManageMemberForm;

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
    
    
    //Member actions
    public void addMemberAction(javafx.event.ActionEvent actionEvent) throws IOException {
        Stage stage = new ManageMemberForm();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.show();
    }
    
    public void editMemberAction(javafx.event.ActionEvent actionEvent) throws IOException {
        Stage stage = new EditMemberForm();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.show();
    }
    
    //Checkout Record History
    public void checkoutRecordAction(javafx.event.ActionEvent actionEvent) throws IOException {
        Stage stage = new CheckoutRecordForm();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.show();
    }
    
}
