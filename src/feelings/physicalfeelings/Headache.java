package feelings.physicalfeelings;

import characters.Person;
import feelings.Feeling;
import interfaces.ICurable;

public class Headache extends Feeling implements ICurable {
    public Headache()
    {
        super("Головная боль");
    }
    @Override
    public void cure(Person person){
        if (person.canFeel(this)){
            System.out.println(person.getName() + " вылечил Головную боль");
            person.removeFeeling(this);
        }
    }

}
