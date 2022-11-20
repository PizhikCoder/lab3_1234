package characters;

import feelings.Feeling;
import feelings.physicalfeelings.Headache;
import interfaces.ICurable;

public class Znayka extends Person{
    private static Znayka obj;
    private Znayka()
    {
        super("Знайка");
    }
    public static Znayka getObj(){
        if (obj == null){
            obj = new Znayka();
            return obj;
        }
        return obj;
    }

    @Override
    public void treat(ICurable iCurable) {
        if(canFeel((Feeling)iCurable )){
            if(iCurable instanceof Headache headache){
                System.out.println("Знайка игнорирует Головную боль.");
                removeFeeling(headache);
            }
            else{
                iCurable.cure(this);
            }
        }
    }
}
