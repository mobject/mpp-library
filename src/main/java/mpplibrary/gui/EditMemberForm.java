package mpplibrary.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import mpplibrary.controller.ManageMemberController;
import mpplibrary.model.Member;
import mpplibrary.util.SpringBeansUtil;

public class EditMemberForm extends Stage {

	//Font define
	private static final String FONT = "Tahoma";
	//Label constant
	protected static final String LBL_EDIT_LIBRARY_MEMBER = "Edit Library Member";
	protected static final String LBL_MEMBER_ID = "Member ID";
	protected static final String LBL_FIRST_NAME = "First Name";
	protected static final String LBL_LAST_NAME = "Last Name";
	protected static final String LBL_STREET = "Street";
	protected static final String LBL_CITY = "City";
	protected static final String LBL_STATE = "State";
	protected static final String LBL_ZIP = "Zip";
	protected static final String LBL_PHONE = "Phone Number";
	//Button constant
	protected static final String BTN_EDIT = "EDIT";
	//Error constant
	protected static final String ERROR_EMPTY_FIELD = " is empty.";
	protected static final String ERROR_EXISTED_MEMBER = "Member does not exist";
	private static final String BTN_SEARCH = "SEARCH";
	protected static final String UPDATE_SUCCESSFULLY = "Updated member <?> successfully";
	private ManageMemberController manageMemberController = null;
	int row = 0;
	
	public EditMemberForm() {
		//Initialize Controller
		manageMemberController = SpringBeansUtil.getBean(ManageMemberController.class);
		
		GridPane gridPane = createMemberFormPane();
		addUIControls(gridPane);
		Scene scene = new Scene(gridPane, 800, 500);
        this.setScene(scene);
	}
	
	private GridPane createMemberFormPane() {
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.setPadding(new Insets(25, 25, 25, 25));

		return gridPane;
	}

	private void addUIControls(GridPane gridPane) {
		
		// Search Member section
		Text sceneTitle = new Text(LBL_EDIT_LIBRARY_MEMBER);
		sceneTitle.setFont(Font.font(FONT, FontWeight.NORMAL, 20));
		gridPane.add(sceneTitle, 0, row, 2, 1);
		row++;
		// Member ID
		Label lbl_memberIdSearch = new Label(LBL_MEMBER_ID);
		gridPane.add(lbl_memberIdSearch, 0, row);
		TextField txtMemberId = new TextField();
		gridPane.add(txtMemberId, 1, row);
		//Button in the same line	
		Button btnSearch = new Button(BTN_SEARCH);
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btnSearch);
		gridPane.add(hbBtn, 2, row);
		row++;
		// Message place
		final Text msgTarget = new Text();
		gridPane.add(msgTarget, 1, row);
		row++;		
		
		//View display edit section
		//addEditMemberGUI(gridPane, txtMemberId, row);
		// Member ID disable
				Label lbl_memberId = new Label(LBL_MEMBER_ID);
				gridPane.add(lbl_memberId, 0, row);
				TextField txtMemberIdDisabled = new TextField();
				//txtMemberId.setText(memberID.getText());
				txtMemberIdDisabled.setDisable(true);
				gridPane.add(txtMemberIdDisabled, 1, row);
				row++;
				// First Name
				Label lblfirstName = new Label(LBL_FIRST_NAME);
				gridPane.add(lblfirstName, 0, row);
				TextField txtFirstName = new TextField();
				gridPane.add(txtFirstName, 1, row);
				row++;
				// Last Name
				Label lbllastName = new Label(LBL_LAST_NAME);
				gridPane.add(lbllastName, 0, row);
				TextField txtLastName = new TextField();
				gridPane.add(txtLastName, 1, row);
				row++;
				// Street
				Label lblStreet = new Label(LBL_STREET);
				gridPane.add(lblStreet, 0, row);
				TextField txtStreet = new TextField();
				gridPane.add(txtStreet, 1, row);
				row++;
				// City
				Label lblCity = new Label(LBL_CITY);
				gridPane.add(lblCity, 0, row);
				TextField txtCity = new TextField();
				gridPane.add(txtCity, 1, row);
				row++;
				// State
				Label lblState = new Label(LBL_STATE);
				gridPane.add(lblState, 0, row);
				TextField txtState = new TextField();
				gridPane.add(txtState, 1, row);
				row++;
				// Zip
				Label lblZip = new Label(LBL_ZIP);
				gridPane.add(lblZip, 0, row);
				TextField txtZip = new TextField();
				gridPane.add(txtZip, 1, row);
				row++;
				// Phone
				Label lblPhone = new Label(LBL_PHONE);
				gridPane.add(lblPhone, 0, row);
				TextField txtPhone = new TextField();
				gridPane.add(txtPhone, 1, row);
				row++;
				//Edit Button
				Button btnEdit = new Button(BTN_EDIT);
		        HBox hbBtnEdit = new HBox(10);
		        hbBtnEdit.setAlignment(Pos.BOTTOM_RIGHT);
		        hbBtnEdit.getChildren().add(btnEdit);
		        gridPane.add(hbBtnEdit, 1, row);
		        row++;
		        // Message place
		        final Text msgTarget2 = new Text();
		        gridPane.add(msgTarget2, 1, row);
		        
		        
		      //add event for search button
		        btnEdit.setOnAction(new EventHandler<ActionEvent>() {
		        	@Override
					public void handle(ActionEvent event) {
		        		// Edit action
		        		//TODO
		        		System.out.println("Edit function here");
		        		if (ManageMemberForm.checkTextBoxEmpty(txtMemberId, msgTarget2, LBL_MEMBER_ID)) {
		                } else if (ManageMemberForm.checkTextBoxEmpty(txtFirstName, msgTarget2, LBL_FIRST_NAME)) {
		                } else if (ManageMemberForm.checkTextBoxEmpty(txtLastName, msgTarget2, LBL_LAST_NAME)) {
		                } else if (ManageMemberForm.checkTextBoxEmpty(txtStreet, msgTarget2, LBL_STREET)) {
		                } else if (ManageMemberForm.checkTextBoxEmpty(txtCity, msgTarget2, LBL_CITY)) {
		                } else if (ManageMemberForm.checkTextBoxEmpty(txtState, msgTarget2, LBL_STATE)) {
		                } else if (ManageMemberForm.checkTextBoxEmpty(txtZip, msgTarget2, LBL_ZIP)) {
		                } else if (ManageMemberForm.checkTextBoxEmpty(txtPhone, msgTarget2, LBL_PHONE)) {
		                } else {
		                	//EDIT member
		                	editMember(txtMemberId.getText(), txtFirstName.getText(), txtLastName.getText(), txtPhone.getText(), txtCity.getText(), txtStreet.getText(), txtState.getText(), txtZip.getText());
		                	msgTarget2.setFill(Color.BLUE);
		        			msgTarget2.setText(UPDATE_SUCCESSFULLY.replace("?", String.valueOf(txtMemberId.getText())));
		        	
		                }	
		        	}

					
				});
		
		
		
        //add event for search button
        btnSearch.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				msgTarget2.setText("");
				if (ManageMemberForm.checkTextBoxEmpty(txtMemberId, msgTarget, LBL_MEMBER_ID)) {
                } else {
                	msgTarget.setText("");
                	txtMemberIdDisabled.setText(txtMemberId.getText());
                	
                	
                	//Check if MemberID not exist
    				if (!manageMemberController.isMemberExist(Integer.parseInt(txtMemberId.getText()))) {
    					msgTarget.setText(ERROR_EXISTED_MEMBER);
    					msgTarget2.setFill(Color.FIREBRICK);
    				} else {
    					//Fill data to edit 
    					fillDataToForm(txtMemberId.getText(), txtFirstName, txtLastName, txtPhone, txtCity, txtStreet, txtState, txtZip);
    					
    				}
                }
				
				
        	}

		});

	}
	
	private void fillDataToForm(String memberId, TextField txtFirstName, TextField txtLastName, TextField txtPhone,
			TextField txtCity, TextField txtStreet, TextField txtState, TextField txtZip) {
		
		//Member member = manageMemberController.findById(Integer.parseInt(memberId)).orElse(null);
		Member member = manageMemberController.getMemberById(Integer.parseInt(memberId));
		
		if (member!=null) {
			txtFirstName.setText(member.getFirstName());
			txtLastName.setText(member.getLastName());
			txtPhone.setText(member.getPhone());
			txtStreet.setText(member.getAddress().getStreet());
			txtCity.setText(member.getAddress().getCity());
			txtState.setText(member.getAddress().getState());
			txtZip.setText(String.valueOf(member.getAddress().getZip()));
		}
		
	}
	
	/*
	private boolean isMemberExist(String memberId) {
		return manageMemberController.isMemberExist(Integer.parseInt(memberId));
	}
	*/
	
	private void editMember(String memberId, String firstName, String lastName,
			String phone, String city, String street, String state, String zip) {
			manageMemberController.updateMember(memberId, firstName, lastName,
					phone, city, street, state, zip);

			
	}
	
	
}
