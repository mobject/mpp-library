package mpplibrary.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import mpplibrary.dto.AuthorDto;
import mpplibrary.dto.BookDto;
import mpplibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AddNewBookController {
    public TextField isbnField;
    public TextField titleField;
    private int maxCheckoutPeriodInDays = 17;

    public TextField authorFirstName;
    public TextField authorLastName;
    public TextField authorPhone;
    public TextArea authorBio;

    public TextField authorStreet;
    public TextField authorCity;
    public TextField authorState;
    public TextField authorZipCode;


    @Autowired
    private BookService bookService;

    public void submitNewBookRequest(javafx.event.ActionEvent actionEvent) throws IOException {
        BookDto bookDto = new BookDto(isbnField.getText(), titleField.getText(), maxCheckoutPeriodInDays);
        AuthorDto authorDto = new AuthorDto(authorFirstName.getText(), authorLastName.getText(), authorPhone.getText(), authorBio.getText(), authorStreet.getText(), authorCity.getText(), authorState.getText(), Integer.parseInt(authorZipCode.getText()));
       bookService.addBook(bookDto, authorDto);
    }


    public void maxCheckoutDaySelectionActionFor17(ActionEvent actionEvent) {
        this.maxCheckoutPeriodInDays = 17;
    }

    public void maxCheckoutDaySelectionActionFor21(ActionEvent actionEvent) {
        this.maxCheckoutPeriodInDays = 21;
    }
}
