package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class AddNewBookController {
    public TextField authorField;
    public TextField isbnField;
    public TextField titleField;
    public Button submitNewBookBtn;
    public TextField authorZipCode;
    public TextField authorState;
    public TextField authorCity;
    public TextField authorStreet;
    public TextArea authorBio;
    public TextField authorPhone;
    public TextField authorLastName;
    public TextField authorFirstName;


    public void submitNewBookRequest(javafx.event.ActionEvent actionEvent) throws IOException {
        //TODO Handle submit new book request.
    }



}
