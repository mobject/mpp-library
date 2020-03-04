package mpplibrary.controller;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mpplibrary.dto.AuthorDto;
import mpplibrary.dto.BookDto;
import mpplibrary.exception.RuleSetException;
import mpplibrary.exception.RuleSetFactory;
import mpplibrary.gui.MessagePopup;
import mpplibrary.model.Address;
import mpplibrary.model.Author;
import mpplibrary.model.Book;
import mpplibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

@Component
public class EditBookController {

    private Book dbBook;
    public TextField isbnField;
    public TextField titleField;
    public TextField authorZipCode;
    public TextField authorState;
    public TextField authorCity;
    public TextField authorStreet;
    public TextArea authorBio;
    public TextField authorPhone;
    public TextField authorLastName;
    public TextField authorFirstName;
    public RadioButton maxChechoutPeriondInDaysFor7RadioButton;
    public RadioButton maxChechoutPeriondInDaysFor21RadioButton;

    @Autowired
    private BookService bookService;
    private int maxCheckoutPeriodInDays;


    void init(Book book) throws IOException {
        this.dbBook = book;

        maxCheckoutPeriodInDays = book.getMaxCheckoutDate();
        if(maxCheckoutPeriodInDays == 17){
            maxChechoutPeriondInDaysFor7RadioButton.setSelected(true);
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
            bookDto.setId(dbBook.getId());
            AuthorDto authorDto = new AuthorDto(authorFirstName.getText(), authorLastName.getText(), authorPhone.getText(), authorBio.getText(), authorStreet.getText(), authorCity.getText(), authorState.getText(), authorZipCode.getText());
            RuleSetFactory.getRuleSet(authorDto).applyRules(authorDto);
            bookDto.setAuthorDto(authorDto);

            RuleSetFactory.getRuleSet(authorDto).applyRules(authorDto);
            RuleSetFactory.getRuleSet(bookDto).applyRules(bookDto);

            Optional<Book> bookO = bookService.findBookByIsbn(bookDto.getIsbn());
            if(bookO.isPresent()) {
                Book book = bookO.get();
                if(book.getId() != dbBook.getId()) {
                    throw new RuleSetException("Duplicate ISBN. This is already used on another book.");
                }
            }


            bookService.updateBook(bookDto);
            MessagePopup.displaySuccess("Book information updated successfully.");
            Scene scene = ((Button) actionEvent.getSource()).getScene();
            Stage primaryStage = (Stage) (scene.getWindow());
            primaryStage.close();
        } catch (Exception e){
            MessagePopup.displayError("Cannot update book.");
        }
    }



    public void submitAddCopyRequest(ActionEvent actionEvent) {
        // TODO Handle submit request.
    }

    public void maxCheckoutDaySelectionActionFor7(ActionEvent actionEvent) {
        this.maxCheckoutPeriodInDays = 17;
    }

    public void maxCheckoutDaySelectionActionFor21(ActionEvent actionEvent) {
        this.maxCheckoutPeriodInDays = 21;
    }

}
