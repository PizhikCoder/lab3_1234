package entities;

import characters.Person;
import interfaces.ICleanable;
import interfaces.IContainable;
import places.Place;

import java.util.ArrayList;
import java.util.List;

public class Windowsill extends Entity implements ICleanable, IContainable {
    private List<Entity> entities;

    public Windowsill(String name, Entity ... entities) {
        super(name);
        this.entities = entities == null ? new ArrayList<Entity>() : new ArrayList<>(List.of(entities));
    }

    @Override
    public void clean(Person person){
        System.out.println(person.getName() + " протер влажной тряпочкой " + getName());
    }

    @Override
    public List<Entity> getEntities(){
        return entities;
    }

    @Override
    public Boolean containEntity(Entity entity) {
        for(Entity i: entities){
            if(i.equals(entity)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void removeEntity(Person person, Entity entity){
        if(containEntity(entity)){
            entities.remove(entity);
            System.out.printf("%s убрал %s с %s\n", person.getName(), entity.getName(), getName());
        }
    }

    @Override
    public void addEntity(Person person, Entity entity) {
        if (!containEntity(entity)){
            entities.add(entity);
            System.out.printf("%s положил %s на %s\n", person.getName(), entity.getName(), getName());
        }
    }

    @Override
    public void shiftEntities(Person person, IContainable to, Entity ... entities) {
        if (entities != null){
            for(Entity entity:entities){
                removeEntity(person, entity);
                to.addEntity(person, entity);
            }
        }
    }


    @Override
    public void shiftEntities(Person person, IContainable to, List<Entity> entities) {
        if (entities != null){
            for(Entity entity:entities){
                removeEntity(person, entity);
                to.addEntity(person, entity);
            }
        }
    }

}
