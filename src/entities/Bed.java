package entities;

import characters.Person;
import interfaces.ICleanable;
import interfaces.IWallowable;

public class Bed extends Furniture implements ICleanable, IWallowable {
    public Bed(String name)
    {
        super(name);
    }
    public void getUp(Person person)
    {
        System.out.println(person.getName() + " встал с " + getName());
    }
    public void lieDown(Person person)
    {
        System.out.println(person.getName() + " лег на " + getName());
    }

    @Override
    public void wallow(Person person)
    {
        System.out.println(person.getName() + " валяется на " + getName());
    }
    @Override
    public void clean(Person person)
    {
        System.out.println(person.getName() + " заправил " + getName());
    }
}
