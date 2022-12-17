package exceptions;

public class NullReagentException extends ReagentException{
    private String context;
    public NullReagentException(String context){
        super(context);
    }
}
