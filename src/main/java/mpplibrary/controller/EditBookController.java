package mpplibrary.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mpplibrary.MPPFXMLLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class EditBookController {
    public TextField authorField;
    @FXML
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
    public TextField noOfNewCopiesField;
    public TextField bookTitle;
    public TextField currentNoOfCopies;


    public void submitLookupBookForEditRequest(ActionEvent actionEvent) throws IOException {
        //TODO Handle submit request.

        FXMLLoader fxmlLoader = new MPPFXMLLoader(getClass().getResource("../gui/edit_book.fxml"));
        GridPane gridPane = fxmlLoader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(gridPane, 800, 500);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(scene);
        stage.show();
    }

    public void submitEditBookRequest(ActionEvent actionEvent) throws IOException {
        //TODO Handle submit request.
    }

    public void submitLookupBookForAddCopyRequest(ActionEvent actionEvent) throws IOException {
        //TODO Handle submit request.

        FXMLLoader fxmlLoader = new MPPFXMLLoader(getClass().getResource("../gui/add_copy.fxml"));

        GridPane gridPane = fxmlLoader.load();
        AddBookCopyController controller = fxmlLoader.<AddBookCopyController>getController();
        controller.initParam(isbnField.getText());
        Stage stage = new Stage();
        Scene scene = new Scene(gridPane, 800, 500);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(scene);
        stage.show();
    }

    public void submitAddCopyRequest(ActionEvent actionEvent) {
        // TODO Handle submit request.
    }
}
