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
import mpplibrary.service.ManageMemberService;
import mpplibrary.util.Validation;

@Component
public class AddMemberController {

	protected static final String ADD_SUCCESSFULLY = "Added member ID <?> successfully";
	
    @Autowired
    private ManageMemberService manageMemberService;
    
    @FXML
    private Text lblMessage;
    
    @FXML
    private TextField txtMemberId;
    
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
    
    List<TextField> textFields = new ArrayList<>();;
    
    @FXML
    public void initialize() {
    	//Add upcoming member Id
		String newMemberId = String.valueOf(manageMemberService.getLatestMemberID()+1);
		txtMemberId.setText(newMemberId); 
		
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
    
    public void addMemberAction(ActionEvent actionEvent) {
    	try {
    		//validate
    		if (!Validation.isEmptyAllFields(textFields)) {
    			//save member information
    			manageMemberService.createMember(txtFirstName.getText(), txtLastName.getText(), txtPhone.getText(),
				txtStreet.getText(), txtCity.getText(), txtState.getText(), txtZip.getText());
    			//MessagePopup.displaySuccess(ADD_SUCCESSFULLY.replace("?", String.valueOf(getLatestMemberId())));
    			lblMessage.setText(ADD_SUCCESSFULLY.replace("?", String.valueOf(manageMemberService.getLatestMemberID())));
    			lblMessage.setFill(Color.BLUE);
    			
    			//reset and ready for new adding
    			//clear fields to blank
    			Validation.clearFields(textFields);
				txtFirstName.requestFocus();
				txtMemberId.setText("Member " + (manageMemberService.getLatestMemberID()+1));
    		}
		} catch (Exception e) {
			//e.printStackTrace();
			lblMessage.setText(e.getMessage());
		}
    }
    
    
    
}
