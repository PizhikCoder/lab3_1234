package interfaces;

import characters.Person;
import entities.Furniture;
import entities.SmallThing;

import java.util.List;

public interface IContainable {
    Boolean containThing(SmallThing thing);
    void shiftThings(Person person, IContainable to, SmallThing... things);
    void shiftThings(Person person, IContainable to, List<SmallThing> things);
    void addThing(Person person, SmallThing thing);
    List<SmallThing> getThings();
    void removeThing(Person person, SmallThing thing);
    String getName();
}
