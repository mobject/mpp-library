package mpplibrary;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(){
        super("Author not found.");
    }
}
