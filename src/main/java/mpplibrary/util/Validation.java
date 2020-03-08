package mpplibrary.util;

import java.util.List;

import javafx.scene.control.TextField;
import mpplibrary.gui.MessagePopup;

public class Validation {

	public static final String ERROR_EMPTY_FIELD = "Field is empty";
	
	public static void clearFields(List<TextField> textFields) {
	    //clear fields to blank
		for (TextField textField : textFields) {
			textField.clear();
		}

	}
	    
	 public static boolean isEmptyAllFields(List<TextField> textFields) {
	     for (TextField textField : textFields) {	
	    	 if (checkTextBoxEmpty(textField))
	    		 return true;
	     }
	    	
	    return false;
	    }
	    
	    
	   public static boolean checkTextBoxEmpty(TextField txtField) {
			if (txtField.getText().isEmpty()) {
				txtField.requestFocus();
				MessagePopup.displayError(ERROR_EMPTY_FIELD);
				return true;
			} else {
				return false;
			}
		}
	    
	
}
