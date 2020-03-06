package mpplibrary.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mpplibrary.MPPFXMLLoader;
import mpplibrary.exception.BookNotFoundException;
import mpplibrary.gui.MessagePopup;
import mpplibrary.model.Address;
import mpplibrary.model.Author;
import mpplibrary.model.Book;
import mpplibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LookupBookController {
    public TextField isbnField;
    @Autowired
    private BookService bookService;
    private int maxCheckoutPeriodInDays;


    public void submitLookupBookForEditRequest(ActionEvent actionEvent) throws IOException {
        //TODO Handle submit request.
        try {
            Book book = bookService.findBookByIsbn(isbnField.getText()).orElseThrow(BookNotFoundException::new);
            loadEditBookUI( book );
        } catch (BookNotFoundException e){
            MessagePopup.displayError(e.getMessage());
        }
    }

    private void loadEditBookUI( Book book ) throws IOException {
        FXMLLoader fxmlLoader = new MPPFXMLLoader(getClass().getResource("../gui/edit_book.fxml"));
        GridPane gridPane = fxmlLoader.load();

        EditBookController controller = fxmlLoader.<EditBookController>getController();
        controller.init(book);

        ScrollPane scrollPane = new ScrollPane(gridPane);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);
        Stage stage = new Stage();
        Scene scene = new Scene(scrollPane, 800, 500);
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

    public void maxCheckoutDaySelectionActionFor17(ActionEvent actionEvent) {
        this.maxCheckoutPeriodInDays = 17;
    }

    public void maxCheckoutDaySelectionActionFor21(ActionEvent actionEvent) {
        this.maxCheckoutPeriodInDays = 21;
    }

}
