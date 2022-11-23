package entities;

import characters.Person;
import interfaces.ICleanable;
import interfaces.IContainable;

import java.util.ArrayList;
import java.util.List;

public class Windowsill extends Furniture implements ICleanable, IContainable {
    private List<SmallThing> things;

    public Windowsill(String name, SmallThing... things) {
        super(name);
        this.things = things == null ? new ArrayList<SmallThing>() : new ArrayList<>(List.of(things));
    }

    @Override
    public void clean(Person person){
        System.out.println(person.getName() + " протер влажной тряпочкой " + getName());
    }

    @Override
    public List<SmallThing> getThings(){
        return things;
    }

    @Override
    public Boolean containThing(SmallThing thing) {
        for(SmallThing i: things){
            if(i.equals(thing)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void removeThing(Person person, SmallThing thing){
        if(containThing(thing)){
            things.remove(thing);
            System.out.printf("%s убрал %s с %s\n", person.getName(), thing.getName(), getName());
        }
    }

    @Override
    public void addThing(Person person, SmallThing thing) {
        if (!containThing(thing)){
            things.add(thing);
            System.out.printf("%s положил %s на %s\n", person.getName(), thing.getName(), getName());
        }
    }

    @Override
    public void shiftThings(Person person, IContainable to, SmallThing... things) {
        if (things != null){
            for(SmallThing thing : things){
                removeThing(person, thing);
                to.addThing(person, thing);
            }
        }
    }


    @Override
    public void shiftThings(Person person, IContainable to, List<SmallThing> things) {
        if (things != null){
            for(SmallThing thing : things){
                removeThing(person, thing);
                to.addThing(person, thing);
            }
        }
    }

}
