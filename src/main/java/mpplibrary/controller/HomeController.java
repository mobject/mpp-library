package mpplibrary.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mpplibrary.MPPFXMLLoader;
import mpplibrary.gui.CheckoutRecordForm;
import mpplibrary.gui.EditMemberForm;
import mpplibrary.gui.ManageMemberForm;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class HomeController {

    @FXML
    private Button checkoutButton;



    public void checkoutPressed(ActionEvent actionEvent) throws IOException {

    }

    public void checkoutAction(javafx.event.ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new MPPFXMLLoader(getClass().getResource("../gui/checkout.fxml"));
        Stage vBox = fxmlLoader.load();
        vBox.show();
    }

    public void addBookAction(javafx.event.ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../gui/add_book.fxml"));
        GridPane gridPane = fxmlLoader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(gridPane, 800, 500);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(scene);
        stage.show();
    }

    public void editBookAction(javafx.event.ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../gui/lookup_book_for_edit.fxml"));
        GridPane gridPane = fxmlLoader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(gridPane, 800, 500);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(scene);
        stage.show();
    }

    public void addBookCopyAction(javafx.event.ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../gui/lookup_book_for_add_copy.fxml"));
        GridPane gridPane = fxmlLoader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(gridPane, 800, 500);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(scene);
        stage.show();


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
