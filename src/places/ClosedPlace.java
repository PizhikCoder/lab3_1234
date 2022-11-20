package places;

import characters.Person;
import entities.Entity;

public class ClosedPlace extends Place{

    public ClosedPlace(String name, TimeOfDay time, Entity... entities) {
        super(name, PlaceType.CLOSED, time,entities);
    }

    @Override
    public void clean(Person person) {
        System.out.println(person.getName() + " подмел пол в " + getName());
        super.clean(person);
    }
}
