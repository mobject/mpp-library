package mpplibrary.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import mpplibrary.dto.CheckoutRecordDTO;
import mpplibrary.model.CheckoutRecord;
import mpplibrary.service.CheckoutService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheckoutController {

    @FXML
    private TextField memberIdField;

    @FXML
    private TextField isbnField;

    @Autowired
    private CheckoutService checkoutService;

    @FXML
    private TableView checkoutRecordsTableView;

    public void checkOutAction(ActionEvent actionEvent) {
        String isbn = isbnField.getText();
        String memberId = memberIdField.getText();

        CheckoutRecord checkoutRecord = checkoutService.checkoutBook(isbn, Integer.valueOf(memberId));
        CheckoutRecordDTO dto = new CheckoutRecordDTO(checkoutRecord);

        ObservableList<CheckoutRecordDTO> items = checkoutRecordsTableView.getItems();
        if (items != null && items.size() == 0) {
            items = FXCollections.observableArrayList();
        }
        items.add(dto);
        checkoutRecordsTableView.setItems(items);
    }
    
    public List<CheckoutRecord> findCheckoutRecordsByMemberId(int memberId) {
    	return checkoutService.findCheckoutRecordsByMemberId(memberId);
    	
    }
    

}
