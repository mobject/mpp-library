package mpplibrary.gui;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import mpplibrary.controller.CheckoutController;
import mpplibrary.controller.ManageMemberController;
import mpplibrary.dto.CheckoutRecordDTO;
import mpplibrary.model.CheckoutRecord;
import mpplibrary.util.SpringBeansUtil;

public class CheckoutRecordForm extends Stage {

	//Constant
	private static final String LBL_CHECKOUT_RECORD = "Checkout Record";
	private static final String LBL_HISTORY_CHECKOUT = "Checked out history:";
	
	private static final String COL_TITLE_ISBN = "ISBN";
	private static final String COL_TITLE_BOOKNAME = "TITLE";
	private static final String COL_TITLE_AUTHOR = "AUTHOR";
	private static final String COL_TITLE_DATE = "DATE";
	private static final String COL_TITLE_CHECKOUT_DATE = "OUT";
	private static final String COL_TITLE_DUE_DATE = "DUE";
	
	private static final String BTN_SEARCH = "SEARCH";
	protected static final String ERROR_EXISTED_MEMBER = "Member does not exist";

	private static final String FONT = "Tahoma";
	
	private TableView<CheckoutRecordDTO> table = new TableView<>();
	private int userId;
	private CheckoutController checkoutController;
	private ManageMemberController manageMemberController;
	
	public CheckoutRecordForm() {
		GridPane gridPane = createMemberFormPane();
		checkoutController = SpringBeansUtil.getBean(CheckoutController.class);
		manageMemberController = SpringBeansUtil.getBean(ManageMemberController.class);
		
		//memberId = SpringBeansUtil.getSession().getMemberId();
		userId = 0;
		
		addUIControls(gridPane);
		Scene scene = new Scene(gridPane, 800, 500);
        this.setScene(scene);
	}
	
	private GridPane createMemberFormPane() {
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		//gridPane.setPrefWidth(1500);
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.setPadding(new Insets(20, 20, 20, 20));

		return gridPane;
	}


	private void addUIControls(GridPane gridPane) {
		int row = 0;
		Text sceneTitle = new Text(LBL_CHECKOUT_RECORD);
		sceneTitle.setFont(Font.font(FONT, FontWeight.NORMAL, 20));
		gridPane.add(sceneTitle, 0, row, 3, 1);
		row++;
		// Member ID
		Label lbl_memberId = new Label(ManageMemberForm.LBL_MEMBER_ID);
		gridPane.add(lbl_memberId, 0, row);
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
		
		btnSearch.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				msgTarget.setFill(Color.FIREBRICK);
				if (ManageMemberForm.checkTextBoxEmpty(txtMemberId, msgTarget, ManageMemberForm.LBL_MEMBER_ID)) {
					table.getItems().clear();
					
                } else {
                	if (!manageMemberController.isMemberExist(Integer.parseInt(txtMemberId.getText()))) {
    					msgTarget.setText(ERROR_EXISTED_MEMBER);
    					msgTarget.setFill(Color.FIREBRICK);
    				} else {
    					//Fill data  
    					table.setItems(tableFill(txtMemberId.getText()));
                    	msgTarget.setText("");
    				}
                	
                }
				
			}
		});
		
		//TableView section
		table.setPrefWidth(500);
		final Label label = new Label(LBL_HISTORY_CHECKOUT);
        label.setFont(new Font(FONT, 15));
        label.setTextFill(Color.BLUEVIOLET);
        gridPane.add(label, 0, row);
        row++;
              
		table.setEditable(false);
				
		TableColumn<CheckoutRecordDTO, String> isbn  = new TableColumn<>(COL_TITLE_ISBN);
		//isbn.setResizable(true);
		isbn.setMinWidth(60);
		//CheckoutRecordDTO dto = new CheckoutRecordDTO(checkoutRecord);
		isbn.setCellValueFactory(new PropertyValueFactory<>("bookIsbn"));
		
		TableColumn<CheckoutRecordDTO, String> bookName  = new TableColumn<>(COL_TITLE_BOOKNAME);
		bookName.setMinWidth(180);
		bookName.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
		
		TableColumn<CheckoutRecordDTO, String> author  = new TableColumn<>(COL_TITLE_AUTHOR);
		author.setMinWidth(80);
		author.setCellValueFactory(new PropertyValueFactory<>("authorName"));
		
		//Date column has 2 sub-column
		TableColumn<CheckoutRecordDTO, String> date  = new TableColumn<>(COL_TITLE_DATE);
		//checkoutDate.setMinWidth(100);
		
		TableColumn<CheckoutRecordDTO, String> checkoutDate  = new TableColumn<>(COL_TITLE_CHECKOUT_DATE);
		checkoutDate.setMinWidth(65);
		checkoutDate.setCellValueFactory(new PropertyValueFactory<>("checkoutDate"));
		
		TableColumn<CheckoutRecordDTO, String> dueDate = new TableColumn<>(COL_TITLE_DUE_DATE);
		dueDate.setMinWidth(35);
		dueDate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
		
		date.getColumns().addAll(checkoutDate, dueDate);
		
		table.getColumns().addAll(isbn, bookName, author, date);
		
		gridPane.add(table, 0, row, 4, 1);
		
	}
	
	
	
	 public ObservableList<CheckoutRecordDTO> tableFill(String memberId) {  
	        ObservableList<CheckoutRecordDTO> listData = FXCollections.observableArrayList();
	        
	        List<CheckoutRecord> checkoutRecords = checkoutController.findCheckoutRecordsByMemberId(Integer.parseInt(memberId));
	        //List<CheckoutRecordDTO> list = checkoutRecords.stream().map(CheckoutRecordDTO::new).collect(Collectors.toList());
	        List<CheckoutRecordDTO> list = new ArrayList<>();
	        for (CheckoutRecord checkoutRecord: checkoutRecords) {
	        	CheckoutRecordDTO checkoutRecordDTO = new CheckoutRecordDTO(checkoutRecord);
	        	list.add(checkoutRecordDTO);
	        }
	        listData.addAll(list);
	        return listData;
	    }
	 
		
}
