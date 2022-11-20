package places;

import characters.Person;
import entities.Entity;
import feelings.Feeling;
import interfaces.ICleanable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class Place {
    private PlaceType type;
    private TimeOfDay time;
    private String name;
    private List<Entity> entities;

    {
        name = "Место(имя не указано)";
        time = TimeOfDay.DAY;
    }

    public Place(String name, PlaceType type, TimeOfDay time, Entity ... entities) {
        this.name = name;
        this.type = type;
        this.time = time;
        this.entities = entities == null ? new ArrayList<Entity>() : new ArrayList<>(List.of(entities));
        setPlaces();
    }

    public Entity getEntityByName(String name){
        for (Entity i: entities){
            if(i.getName() == name){
                return i;
            }
        }
        return null;
    }
    private void setPlaces(){
        for (Entity i: entities){
            i.setPlace(this);
        }
    }
    public void clean(Person person) {
        for(Entity i:entities) {
            if (ICleanable.class.isAssignableFrom(i.getClass()))
            {
                ((ICleanable) i).clean(person);
            }
        }
    }



    public void addEntity(Entity entity, Person person){
        entities.add(entity);
        System.out.printf("%.s принес %.s в %.s", person.getName(), entity.getName(), getName());
    }

    public void removeEntity(Entity entity, Person person){
        entities.remove(entity);
        System.out.printf("%.s вынес %.s из %.s", person.getName(), entity.getName(), getName());
    }

    public void changeTime(TimeOfDay time){
        this.time = time;
        System.out.println("Наступил " + time);
    }

    public String getName(){
        return name;
    }

    @Override
    public int hashCode () {
        return Objects.hash(type, time, name, entities);
    }
}
