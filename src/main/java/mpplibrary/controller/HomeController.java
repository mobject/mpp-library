package mpplibrary.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mpplibrary.MPPFXMLLoader;
import mpplibrary.service.UserSession;

@Component
public class HomeController {

    @FXML
    public Button addBookCopyButton;
    @FXML
    public Button addMemberButton;
    @FXML
    public Button editMemberButton;

    @FXML
    public Button addBookButton;
    @FXML
    public Button editBookButton;
    @FXML
    public Button checkoutRecordsButton;
    @FXML
    private Button checkoutButton;

    @Autowired
    private UserSession userSession;

    @FXML
    void initialize(){

        if (userSession.hasAdminPermission()){
            checkoutButton.setDisable(true);
            checkoutRecordsButton.setDisable(true);
        }

        if (userSession.hasLibrarianPermission()){
            editBookButton.setDisable(true);
            addBookButton.setDisable(true);
            addMemberButton.setDisable(true);
            editMemberButton.setDisable(true);
        }
    }

    public void checkoutAction(javafx.event.ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new MPPFXMLLoader(getClass().getResource("../gui/checkout.fxml"));
        Stage vBox = fxmlLoader.load();
        vBox.show();
    }

    public void addBookAction(javafx.event.ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new MPPFXMLLoader(getClass().getResource("../gui/add_book.fxml"));
        GridPane gridPane = fxmlLoader.load();
        ScrollPane scrollPane = new ScrollPane(gridPane);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);
        Stage stage = new Stage();
        Scene scene = new Scene(scrollPane, 800, 500);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(scene);
        stage.show();
    }

    public void editBookAction(javafx.event.ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new MPPFXMLLoader(getClass().getResource("../gui/lookup_book_for_edit.fxml"));
        GridPane gridPane = fxmlLoader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(gridPane, 800, 500);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(scene);
        stage.show();
    }

    public void addBookCopyAction(javafx.event.ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new MPPFXMLLoader(getClass().getResource("../gui/lookup_book_for_add_copy.fxml"));
        GridPane gridPane = fxmlLoader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(gridPane, 800, 500);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(scene);
        stage.show();


    }


    //Member actions
    public void addMemberAction(javafx.event.ActionEvent actionEvent) throws IOException {
        //Stage stage = new ManageMemberForm();
        //stage.initModality(Modality.WINDOW_MODAL);
        //stage.show();
    	
    	FXMLLoader fxmlLoader = new MPPFXMLLoader(getClass().getResource("../gui/add_member.fxml"));
    	GridPane gridPane = fxmlLoader.load();
    	Stage stage = new Stage();
    	stage.setTitle("Add New Member");
    	Scene scene = new Scene(gridPane, 800, 500);
    	stage.initModality(Modality.WINDOW_MODAL);
    	stage.setScene(scene);
    	stage.show();
    	
    }

    public void editMemberAction(javafx.event.ActionEvent actionEvent) throws IOException {
        //Stage stage = new EditMemberForm();
        //stage.initModality(Modality.WINDOW_MODAL);
        //stage.show();
    	
    	FXMLLoader fxmlLoader = new MPPFXMLLoader(getClass().getResource("../gui/edit_member.fxml"));
    	GridPane gridPane = fxmlLoader.load();
    	Stage stage = new Stage();
    	stage.setTitle("Edit Member");
    	Scene scene = new Scene(gridPane, 800, 500);
    	stage.initModality(Modality.WINDOW_MODAL);
    	stage.setScene(scene);
    	stage.show();
    }

    //Checkout Record History
    public void checkoutRecordAction(javafx.event.ActionEvent actionEvent) throws IOException {
        //Stage stage = new CheckoutRecordForm();
        //stage.initModality(Modality.WINDOW_MODAL);
        //stage.show();
    	
    	//FXMLLoader fxmlLoader = new MPPFXMLLoader(getClass().getResource("../gui/checkout_record.fxml"));
        //Stage vBox = fxmlLoader.load();
        //vBox.show();
    	
    	FXMLLoader fxmlLoader = new MPPFXMLLoader(getClass().getResource("../gui/checkout_record.fxml"));
    	GridPane gridPane = fxmlLoader.load();
    	Stage stage = new Stage();
    	stage.setTitle("Checkout Record of Member");
    	Scene scene = new Scene(gridPane, 800, 500);
    	stage.initModality(Modality.WINDOW_MODAL);
    	stage.setScene(scene);
    	stage.show();
    	
    }

}
