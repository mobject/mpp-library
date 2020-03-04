package mpplibrary.controller;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mpplibrary.dto.AuthorDto;
import mpplibrary.dto.BookDto;
import mpplibrary.exception.RuleSetException;
import mpplibrary.exception.RuleSetFactory;
import mpplibrary.gui.MessagePopup;
import mpplibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AddNewBookController {
    public TextField isbnField;
    public TextField titleField;
    private int maxCheckoutPeriodInDays = 7;

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
       try {
           BookDto bookDto = new BookDto(isbnField.getText(), titleField.getText(), maxCheckoutPeriodInDays);
           AuthorDto authorDto = new AuthorDto(authorFirstName.getText(), authorLastName.getText(), authorPhone.getText(), authorBio.getText(), authorStreet.getText(), authorCity.getText(), authorState.getText(), authorZipCode.getText());
           bookDto.setAuthorDto(authorDto);

           RuleSetFactory.getRuleSet(authorDto).applyRules(authorDto);
           RuleSetFactory.getRuleSet(bookDto).applyRules(bookDto);

           if (bookService.findBookByIsbn(bookDto.getIsbn()).isPresent()) {
               throw new RuleSetException("Duplicate ISBN. This is already used on another book.");
           }


           bookService.addBook(bookDto);

           bookService.addBook(bookDto);

           MessagePopup.displaySuccess("Book added successfully.");

           Scene scene = ((Button) actionEvent.getSource()).getScene();
           Stage primaryStage = (Stage) (scene.getWindow());
           primaryStage.close();
       }catch (Exception ex ){
           ex.printStackTrace();
           if(ex instanceof RuleSetException){
               MessagePopup.displayError(ex.getMessage());
           } else {
               MessagePopup.displayError("Failed to add book.");
           }
       }
    }


    public void maxCheckoutDaySelectionActionFor7(ActionEvent actionEvent) {
        this.maxCheckoutPeriodInDays = 7;
    }

    public void maxCheckoutDaySelectionActionFor21(ActionEvent actionEvent) {
        this.maxCheckoutPeriodInDays = 21;
    }
}
