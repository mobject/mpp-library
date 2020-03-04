package mpplibrary.exception;

public class InvalidLoginException extends Exception {

    public InvalidLoginException(String message){
        super(message);
    }

    public InvalidLoginException(){
        super("UserId or Password is invalid");
    }
}
