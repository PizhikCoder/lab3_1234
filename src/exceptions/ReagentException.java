package exceptions;

public class ReagentException extends Exception{
    private String context;
    public ReagentException(String context){
        this.context = context;
    }
    public String getContext(){
        return context;
    }

}
