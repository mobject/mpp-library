package mpplibrary.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import mpplibrary.gui.MessagePopup;
import mpplibrary.model.Member;
import mpplibrary.service.ManageMemberService;
import mpplibrary.util.Validation;

@Component
public class EditMemberController {

	protected static final String ERROR_EXISTED_MEMBER = "Member does not exist";
	protected static final String UPDATE_SUCCESSFULLY = "Updated member <?> successfully";
	
    @Autowired
    private ManageMemberService manageMemberService;
    
    // Search section
    @FXML
    private TextField txtMemberId;
    @FXML
    private Text lblMessageSearch;
    
    
    // Update section
    @FXML
    private TextField txtMemberId1;
    
    @FXML
    private TextField txtFirstName;
    
    @FXML
    private TextField txtLastName;
    
    @FXML
    private TextField txtStreet;
    
    @FXML
    private TextField txtCity;
    
    @FXML
    private TextField txtState;
    
    @FXML
    private TextField txtZip;
    
    @FXML
    private TextField txtPhone;
    
    @FXML
    private Text lblMessageEdit;
    
    private List<TextField> textFields = new ArrayList<>();
    
    @FXML
    public void initialize() {
		//initial for validation textfields
		textFields.add(txtMemberId);
    	textFields.add(txtFirstName);
    	textFields.add(txtLastName);
    	textFields.add(txtStreet);
    	textFields.add(txtCity);
    	textFields.add(txtState);
    	textFields.add(txtZip);
    	textFields.add(txtPhone);
    } 
    
   public void searchMemberAction(ActionEvent actionEvent) {
    	try {
    		lblMessageEdit.setText("");
    		//validation field
    		if (!Validation.checkTextBoxEmpty(txtMemberId)) {
    			if (!manageMemberService.isMemberExist(Integer.parseInt(txtMemberId.getText()))) {
    				MessagePopup.displayError(ERROR_EXISTED_MEMBER);
    				Validation.clearFields(textFields);
    				txtMemberId.requestFocus();

    			} else {
    				//Fill data to edit 
    				fillDataToForm();
    			}
    			
    		}
    		
		} catch (Exception e) {
			e.printStackTrace();
			lblMessageEdit.setText(e.getMessage());
		}
    	
    }
    
    public void updateMemberAction(ActionEvent actionEvent) {
    	try {
    		//validate
    		if (!Validation.isEmptyAllFields(textFields)) {
    			//save member information
    			manageMemberService.updateMember(txtMemberId1.getText(), txtFirstName.getText(), txtLastName.getText(), txtPhone.getText(),
				txtStreet.getText(), txtCity.getText(), txtState.getText(), txtZip.getText());
    			lblMessageEdit.setText(UPDATE_SUCCESSFULLY.replace("?", String.valueOf(txtMemberId1.getText())));
    			lblMessageEdit.setFill(Color.BLUE);
    			
    			//reset and ready for new adding
    			Validation.clearFields(textFields);
				txtMemberId.requestFocus();
    		}
		} catch (Exception e) {
			e.printStackTrace();
			lblMessageEdit.setText(e.getMessage());
		}
    }
    
    
    private void fillDataToForm() {
		
    	//Member member = manageMemberService.findById(Integer.parseInt(memberId)).orElse(null);
    	Member member = manageMemberService.getMemberById(Integer.parseInt(txtMemberId.getText()));
    			
    	if (member!=null) {
    		txtMemberId1.setText(txtMemberId.getText());
    		txtFirstName.setText(member.getFirstName());
			txtLastName.setText(member.getLastName());
			txtPhone.setText(member.getPhone());
			txtStreet.setText(member.getAddress().getStreet());
			txtCity.setText(member.getAddress().getCity());
			txtState.setText(member.getAddress().getState());
			txtZip.setText(String.valueOf(member.getAddress().getZip()));
    	}
    }
    
}
