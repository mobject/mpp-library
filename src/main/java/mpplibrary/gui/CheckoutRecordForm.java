package mpplibrary.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import mpplibrary.model.CheckoutHistory;

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

	private static final String FONT = "Tahoma";
	
	// attributes
	//private TableView<CheckoutRecordForm> table = new TableView<>();
	private TableView<CheckoutHistory> table = new TableView<>();
	
	/*
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle(LBL_CHECKOUT_RECORD);
		//stage.setWidth(900);
        //stage.setHeight(500);
		//stage.setResizable(false);
	    //stage.setMaximized(true);
	    //stage.setFullScreen(true);
		GridPane gridPane = createMemberFormPane();
		addUIControls(gridPane);
		Scene scene = new Scene(gridPane, 800, 500);
        stage.setScene(scene);
		stage.show();
		
	}
	*/
	
	public CheckoutRecordForm() {
		GridPane gridPane = createMemberFormPane();
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
		gridPane.setPadding(new Insets(50, 25, 25, 25));

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
                	table.setItems(tableFill());
                	msgTarget.setText("");
                }
				
			}
		});
		
		//Grid section
		final Label label = new Label(LBL_HISTORY_CHECKOUT);
        label.setFont(new Font(FONT, 15));
        label.setTextFill(Color.BLUEVIOLET);
        gridPane.add(label, 0, row);
        row++;
        //TODO
              
		table.setEditable(false);
				
		TableColumn<CheckoutHistory, String> isbn  = new TableColumn<>(COL_TITLE_ISBN);
		//isbn.setResizable(true);
		isbn.setMinWidth(40);
		isbn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
		
		TableColumn<CheckoutHistory, String> bookName  = new TableColumn<>(COL_TITLE_BOOKNAME);
		bookName.setMinWidth(80);
		bookName.setCellValueFactory(new PropertyValueFactory<>("bookName"));
		
		TableColumn<CheckoutHistory, String> author  = new TableColumn<>(COL_TITLE_AUTHOR);
		author.setMinWidth(80);
		author.setCellValueFactory(new PropertyValueFactory<>("authorName"));
		
		//Date column has 2 sub-column
		TableColumn<CheckoutHistory, String> date  = new TableColumn<>(COL_TITLE_DATE);
		//checkoutDate.setMinWidth(100);
		
		TableColumn<CheckoutHistory, String> checkoutDate  = new TableColumn<>(COL_TITLE_CHECKOUT_DATE);
		checkoutDate.setMinWidth(65);
		checkoutDate.setCellValueFactory(new PropertyValueFactory<>("checkoutDate"));
		
		TableColumn<CheckoutHistory, String> dueDate = new TableColumn<>(COL_TITLE_DUE_DATE);
		dueDate.setMinWidth(35);
		dueDate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
		
		date.getColumns().addAll(checkoutDate, dueDate);
		
		table.getColumns().addAll(isbn, bookName, author, date);
		//table.setItems(tableFill());
		
		gridPane.add(table, 0, row, 4, 1);
		
	}
	
	
	
	 public ObservableList<CheckoutHistory> tableFill() {  
	        ObservableList<CheckoutHistory> checkoutHistory = FXCollections.observableArrayList();
	        checkoutHistory.add(new CheckoutHistory("978-3-16-148410-0", "STC Book", "John", "01/30/2020", "02/20/2020"));
	        checkoutHistory.add(new CheckoutHistory("978-3-16-148410-3", "STC Book1", "Marry", "01/29/2020", "02/20/2020"));
	        checkoutHistory.add(new CheckoutHistory("978-3-16-148410-1", "STC Book2", "Tom", "01/30/2020", "02/20/2020"));
	        checkoutHistory.add(new CheckoutHistory("978-3-16-148410-0", "STC Book", "John", "01/30/2020", "02/20/2020"));
	        checkoutHistory.add(new CheckoutHistory("978-3-16-148410-0", "STC Book", "John", "01/30/2020", "02/20/2020"));
	        checkoutHistory.add(new CheckoutHistory("978-3-16-148410-0", "STC Book", "John", "01/30/2020", "02/20/2020"));
	        checkoutHistory.add(new CheckoutHistory("978-3-16-148410-0", "STC Book", "John", "01/30/2020", "02/20/2020"));
	        checkoutHistory.add(new CheckoutHistory("978-3-16-148410-0", "STC Book", "John", "01/30/2020", "02/20/2020"));
	        checkoutHistory.add(new CheckoutHistory("978-3-16-148410-0", "STC Book", "John", "01/30/2020", "02/20/2020"));
	        checkoutHistory.add(new CheckoutHistory("978-3-16-148410-0", "STC Book", "John", "01/30/2020", "02/20/2020"));
	        checkoutHistory.add(new CheckoutHistory("978-3-16-148410-0", "STC Book", "John", "01/30/2020", "02/20/2020"));
	        checkoutHistory.add(new CheckoutHistory("978-3-16-148410-0", "STC Book", "John", "01/30/2020", "02/20/2020"));
	        checkoutHistory.add(new CheckoutHistory("978-3-16-148410-0", "STC Book", "John", "01/30/2020", "02/20/2020"));
	        checkoutHistory.add(new CheckoutHistory("978-3-16-148410-0", "STC Book", "John", "01/30/2020", "02/20/2020"));
	        checkoutHistory.add(new CheckoutHistory("978-3-16-148410-0", "STC Book", "John", "01/30/2020", "02/20/2020"));
	        checkoutHistory.add(new CheckoutHistory("978-3-16-148410-0", "STC Book", "John", "01/30/2020", "02/20/2020"));
	        checkoutHistory.add(new CheckoutHistory("978-3-16-148410-0", "STC Book", "John", "01/30/2020", "02/20/2020"));
	        
	        return checkoutHistory;
	    }
	 
	/*
	public void setData(ObservableList<CheckoutRecordForm> items) {
		ObservableList<CheckoutRecordForm> current = table.getItems();
		if(current != null) {
			current.addAll(items);
		}
		table.setItems(current);
	}
	*/
	
}
