package mpplibrary.exception;

public class MemberNotFoundException extends Exception {

    public MemberNotFoundException(String message){
        super(message);
    }

    public MemberNotFoundException(){
        super("Member is not found");
    }
}
