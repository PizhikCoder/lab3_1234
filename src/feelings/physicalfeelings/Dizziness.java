package feelings.physicalfeelings;

import characters.Person;
import feelings.Feeling;
import interfaces.ICurable;

public class Dizziness extends Feeling implements ICurable {

    public Dizziness() {
        super("Головокружение");
    }
    @Override
    public void cure(Person person){
        if (person.canFeel(this)){
            System.out.println(person.getName() + " вылечил Головокружение");
            person.removeFeeling(this);
        }
    }
}
