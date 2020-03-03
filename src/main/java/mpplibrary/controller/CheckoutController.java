package mpplibrary.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import mpplibrary.dto.CheckoutRecordDTO;
import mpplibrary.model.Book;
import mpplibrary.model.BookCopy;
import mpplibrary.model.Member;
import mpplibrary.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CheckoutController {

    @Autowired
    private CheckoutService checkoutService;

    @FXML
    private TableView checkoutRecordsTableView;

    public void checkOutAction(ActionEvent actionEvent) {
        ObservableList<CheckoutRecordDTO> items = FXCollections.observableArrayList();
        CheckoutRecordDTO dto = new CheckoutRecordDTO();
        Member member = new Member();
        member.setFirstName("Minh");
        member.setLastName("Tran");
        dto.setMember(member);
        Book book = new Book();
        book.setTitle("Java in Action");
        book.setIsbn("321321321321321");
        dto.setBook(book);

        BookCopy bookCopy = new BookCopy();
//        bookCopy.setDueDate(LocalDate.now());
//        bookCopy.setCheckoutDate(LocalDate.now());
        dto.setBookCopy(bookCopy);

        items.add(dto);
        checkoutRecordsTableView.setItems(items);
    }

}
