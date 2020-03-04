package mpplibrary;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(){
        super("Book not found.");
    }
}
