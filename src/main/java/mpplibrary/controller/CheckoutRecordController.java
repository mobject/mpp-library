package mpplibrary.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import mpplibrary.dto.CheckoutRecordDTO;
import mpplibrary.gui.MessagePopup;
import mpplibrary.model.CheckoutRecord;
import mpplibrary.service.CheckoutService;
import mpplibrary.util.Validation;

@Controller
public class CheckoutRecordController {
	
	protected static final String ERROR_EXISTED_MEMBER = "Member does not checkout";
	
	@Autowired
	private CheckoutService checkoutService;
	
	@FXML
    private TextField txtMemberId;
	
    @FXML
    private TableView checkoutRecordTableView;
    
    
    public void checkoutRecordAction(ActionEvent actionEvent) {
    	
    	
    	if (Validation.checkTextBoxEmpty(txtMemberId)) {
    		checkoutRecordTableView.getItems().clear();
			
        } else {
        	
        	if (!checkoutService.existByIdMember(Integer.parseInt(txtMemberId.getText()))) {
				MessagePopup.displayError(ERROR_EXISTED_MEMBER);
				checkoutRecordTableView.getItems().clear();
			} else {
				try  {
					//Fill data to tableview 
					checkoutRecordTableView.setItems(tableFill(txtMemberId.getText()));
				} catch (Exception e) {
					MessagePopup.displayError("Cannot fill checkout Records");
				}
			}
        	
        }
        
    }
    
    private ObservableList<CheckoutRecordDTO> tableFill(String memberId) {  
        ObservableList<CheckoutRecordDTO> listData = FXCollections.observableArrayList();
        
        List<CheckoutRecord> checkoutRecords = checkoutService.findCheckoutRecordsByMemberId(Integer.parseInt(memberId));
        List<CheckoutRecordDTO> list = new ArrayList<>();
        for (CheckoutRecord checkoutRecord: checkoutRecords) {
        	CheckoutRecordDTO checkoutRecordDTO = new CheckoutRecordDTO(checkoutRecord);
        	list.add(checkoutRecordDTO);
        }
        listData.addAll(list);
        return listData;
    }
    

}
