package mpplibrary.exception;

public class DuplicateISBNException extends Exception {
    public DuplicateISBNException(){
        super("ISBN already exists on another book.");
    }
}
