package mpplibrary.exception;

public class RuleSetException extends RuntimeException {
    public RuleSetException(){
        super("Rule set failed.");
    }
    public RuleSetException(String msg ){
        super(msg);
    }
}
