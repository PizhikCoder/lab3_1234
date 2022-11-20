package places;

import characters.Person;
import entities.Entity;

public class OpenedPlace extends Place{

    public OpenedPlace(String name, TimeOfDay time, Entity... entities) {
        super(name, PlaceType.OPENED, time, entities);
    }
    @Override
    public void clean(Person person) {
        System.out.println(person.getName() + " подмел в " + getName());
        super.clean(person);
    }
}
