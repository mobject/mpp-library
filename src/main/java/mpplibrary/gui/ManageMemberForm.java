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

public class ManageMemberForm extends Stage {

	//Font define
	private static final String FONT = "Tahoma";
	//Label constant
	protected static final String LBL_ADD_NEW_LIBRARY_MEMBER = "Add New Library Member";
	protected static final String LBL_MEMBER_ID = "Member ID";
	protected static final String LBL_FIRST_NAME = "First Name";
	protected static final String LBL_LAST_NAME = "Last Name";
	protected static final String LBL_STREET = "Street";
	protected static final String LBL_CITY = "City";
	protected static final String LBL_STATE = "State";
	protected static final String LBL_ZIP = "Zip";
	protected static final String LBL_PHONE = "Phone Number";
	//Button constant
	protected static final String BTN_CREATE = "CREATE";
	//Error constant
	protected static final String ERROR_EMPTY_FIELD = " is empty.";
	protected static final String ERROR_EXISTED_MEMBER = "Member is existed and cannot create";
	private ManageMemberController manageMemberController =  new ManageMemberController();
	
	
	public ManageMemberForm() {
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
		int row = 0;
		Text sceneTitle = new Text(LBL_ADD_NEW_LIBRARY_MEMBER);
		sceneTitle.setFont(Font.font(FONT, FontWeight.NORMAL, 20));
		gridPane.add(sceneTitle, 0, row, 2, 1);
		row++;
		// Member ID
		Label lbl_memberId = new Label(LBL_MEMBER_ID);
		gridPane.add(lbl_memberId, 0, row);
		TextField txtMemberId = new TextField();
		//int latestMemberId = manageMemberController.getLastestMemberId();
		//txtMemberId.setText("Member "+ latestMemberId);
		txtMemberId.setText("Member ");
		txtMemberId.setVisible(false);
		gridPane.add(txtMemberId, 1, row);
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
		//Button
		Button btnCreate = new Button(BTN_CREATE);
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btnCreate);
        gridPane.add(hbBtn, 1, row);
        row++;
        // Message place
        final Text msgTarget = new Text();
        gridPane.add(msgTarget, 1, row);
        msgTarget.setFill(Color.FIREBRICK);
        //add event for button
        btnCreate.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {

				if (checkTextBoxEmpty(txtMemberId, msgTarget, LBL_MEMBER_ID)) {
                } else if (checkTextBoxEmpty(txtFirstName, msgTarget, LBL_FIRST_NAME)) {
                } else if (checkTextBoxEmpty(txtLastName, msgTarget, LBL_LAST_NAME)) {
                } else if (checkTextBoxEmpty(txtStreet, msgTarget, LBL_STREET)) {
                } else if (checkTextBoxEmpty(txtCity, msgTarget, LBL_CITY)) {
                } else if (checkTextBoxEmpty(txtState, msgTarget, LBL_STATE)) {
                } else if (checkTextBoxEmpty(txtZip, msgTarget, LBL_ZIP)) {
                } else if (checkTextBoxEmpty(txtPhone, msgTarget, LBL_PHONE)) {
                } else {
                	msgTarget.setText("");
                	
                	//Check if MemberID not exist
    				if (isMemberExist(txtFirstName.getText())) {
    					msgTarget.setText(ERROR_EXISTED_MEMBER);
    				} else {
    					// save to file
    					//TODO					
    					//Address address = new Address(txtStreet.getText().trim(), txtCity.getText().trim(), txtState.getText().trim(), Integer.parseInt(txtZip.getText().trim()));
    					//Member member = new Member(txtFirstName.getText().trim(), txtLastName.getText().trim(), txtPhone.getText().trim(), address);
    					//manageMemberController.insertMember(member);
    					
    					//for (Member mem : members)
    					//	System.out.println(mem.toString());
    				}
                }
				
				
        	}
		});

	}

	public static boolean checkTextBoxEmpty(TextField txtField, Text msgTarget, String fieldName) {
		if (txtField.getText().isEmpty()) {
			txtField.requestFocus();
			msgTarget.setText(fieldName + ERROR_EMPTY_FIELD);
            return true;
		} else {
			return false;
		}
	}
	
	private boolean isMemberExist(String memberId) {
		//TODO
		return false;
	}
}
