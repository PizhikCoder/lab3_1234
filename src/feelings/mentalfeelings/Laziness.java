package feelings.mentalfeelings;

import characters.Person;
import feelings.Feeling;

public class Laziness extends Feeling {

    public Laziness() {
        super("Лень");
    }
    public static void lazyAbout(Person person, String about)
    {
        if (person.canFeel(new Laziness())){
            System.out.println(person.getName() + " ленится " + about);
        }
    }
}
