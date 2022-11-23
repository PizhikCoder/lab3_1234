package places;

import characters.Person;
import entities.Furniture;

public class ClosedPlace extends Place{
    private Boolean isDoorOpened;
    {
        isDoorOpened = false;
    }
    public ClosedPlace(String name, TimeOfDay time, Furniture... entities) {
        super(name, time,entities);
    }
    public Boolean getDoorStatus(){
        return isDoorOpened;
    }
    public void closeTheDoor(Person person) {
        if (isDoorOpened) {
            System.out.println(person.getName() + " закрыл дверь в " + getName());
            isDoorOpened = false;
        }
    }
    public void openTheDoor(Person person){
        if(!isDoorOpened) {
            System.out.println(person.getName() + " открыл дверь в " + getName() );
            isDoorOpened = true;
        }
    }

    @Override
    public void clean(Person person) {
        System.out.println(person.getName() + " подмел пол в " + getName());
        super.clean(person);
    }
}
