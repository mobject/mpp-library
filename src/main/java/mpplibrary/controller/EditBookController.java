package mpplibrary.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import mpplibrary.dto.AuthorDto;
import mpplibrary.dto.BookDto;
import mpplibrary.gui.MessagePopup;
import mpplibrary.model.Address;
import mpplibrary.model.Author;
import mpplibrary.model.Book;
import mpplibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class EditBookController {

    private Book book;
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
    public RadioButton maxChechoutPeriondInDaysFor17RadioButton;
    public RadioButton maxChechoutPeriondInDaysFor21RadioButton;

    @Autowired
    private BookService bookService;
    private int maxCheckoutPeriodInDays;


    void init(Book book) throws IOException {
        this.book = book;

        maxCheckoutPeriodInDays = book.getMaxCheckoutDate();
        if(maxCheckoutPeriodInDays == 17){
            maxChechoutPeriondInDaysFor17RadioButton.setSelected(true);
        } else {
            maxChechoutPeriondInDaysFor21RadioButton.setSelected(true);
        }

        isbnField.setText(book.getIsbn());
        titleField.setText(book.getTitle());

        Author author = book.getAuthor();
        authorFirstName.setText(author.getFirstName());
        authorLastName.setText(author.getLastName());
        authorPhone.setText(author.getPhone());
        authorBio.setText(author.getShortBio());

        Address address = author.getAddress();
        authorStreet.setText(address.getStreet());
        authorCity.setText(address.getCity());
        authorState.setText(address.getState());
        authorZipCode.setText(String.valueOf(address.getZip()));
    }

    public void submitEditBookRequest(ActionEvent actionEvent) throws IOException {
        try {
            BookDto bookDto = new BookDto(isbnField.getText(), titleField.getText(), maxCheckoutPeriodInDays);
            bookDto.setId(book.getId());
            AuthorDto authorDto = new AuthorDto(authorFirstName.getText(), authorLastName.getText(), authorPhone.getText(), authorBio.getText(), authorStreet.getText(), authorCity.getText(), authorState.getText(), Integer.parseInt(authorZipCode.getText()));
            bookDto.setAuthorDto(authorDto);
            bookService.updateBook(bookDto);
            MessagePopup.displayError("Book information updated successfully.");
        } catch (Exception e){
            MessagePopup.displayError("Can update book.");
        }
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
