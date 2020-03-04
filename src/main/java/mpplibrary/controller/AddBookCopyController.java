package mpplibrary.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import mpplibrary.exception.BookNotFoundException;
import mpplibrary.gui.MessagePopup;
import mpplibrary.model.Book;
import mpplibrary.model.BookCopy;
import mpplibrary.service.BookCopyService;
import mpplibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddBookCopyController {
    @FXML
    public TextField isbnField;
    @FXML
    public Button submitNewBookBtn;
    @FXML
    public TextField bookTitle;
    public TextField currentNoOfCopies;
    public TextField noOfNewCopiesField;

    @Autowired
    private BookService bookService;

    @Autowired
    private BookCopyService bookCopyService;

    private String isbn;

    public void initParam(String isbn){
        this.isbn = isbn;
        try {
            Book book = bookService.findBookByIsbn(isbn).orElseThrow(BookNotFoundException::new);
            List<BookCopy> allBookCopy = bookCopyService.findAllBookCopy(isbn);
            bookTitle.setText(book.getTitle());
            isbnField.setText(book.getIsbn());
            currentNoOfCopies.setText(String.valueOf(allBookCopy.size()));
        } catch (BookNotFoundException e) {
            MessagePopup.displayError(e.getMessage());
        }
    }


    public void submitAddCopyRequest(ActionEvent actionEvent) throws Exception {
        try {
            Integer integer = Integer.valueOf(noOfNewCopiesField.getText());
            bookCopyService.addBookCopy(isbn, integer);
            MessagePopup.displaySuccess("Book copies has been added successfully");
        }catch (NumberFormatException ex){
            MessagePopup.displayError("Number of Copies is invalid");
        }

    }
}
