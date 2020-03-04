package mpplibrary.exception;

public class BookNotFoundException extends Exception {
    public BookNotFoundException(){
        super("Book is not found");
    }
}
