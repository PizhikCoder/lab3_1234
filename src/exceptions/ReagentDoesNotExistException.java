package exceptions;

public class ReagentDoesNotExistException extends ReagentException{
    public ReagentDoesNotExistException(String context){
        super(context);
    }
}
