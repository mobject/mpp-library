package mpplibrary.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import mpplibrary.dto.CheckoutRecordDTO;
import mpplibrary.model.CheckoutRecord;
import mpplibrary.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheckoutController {

    @Autowired
    private CheckoutService checkoutService;

    @FXML
    private TableView checkoutRecordsTableView;

    public void checkOutAction(ActionEvent actionEvent) {
        CheckoutRecord checkoutRecord = checkoutService.checkoutBook("tisbn", 1);
        ObservableList<CheckoutRecordDTO> items = FXCollections.observableArrayList();
        CheckoutRecordDTO dto = new CheckoutRecordDTO(checkoutRecord);
        items.add(dto);
        checkoutRecordsTableView.setItems(items);
    }

}
