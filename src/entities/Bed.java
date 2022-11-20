package entities;

import characters.Person;
import com.sun.security.jgss.GSSUtil;
import interfaces.ICleanable;
import interfaces.IWallowable;
import places.Place;

public class Bed extends Entity implements ICleanable, IWallowable {
    public Bed(String name)
    {
        super(name);
    }
    public void getUp(Person person)
    {
        System.out.println(person.getName() + " встал с " + getName());
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
