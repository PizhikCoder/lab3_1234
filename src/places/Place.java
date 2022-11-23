package places;

import characters.Person;
import entities.Furniture;
import interfaces.ICleanable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Place {
    private TimeOfDay time;
    private String name;
    private List<Furniture> furnitures;

    public Place(String name, TimeOfDay time, Furniture... furnitures) {
        this.name = name;
        this.time = time;
        this.furnitures = furnitures == null ? new ArrayList<>() : new ArrayList<>(List.of(furnitures));
        setPlaces();
    }

    public Furniture getFurnitureByName(String name){
        for (Furniture i: furnitures){
            if(i.getName() == name){
                return i;
            }
        }
        return null;
    }
    private void setPlaces(){
        for (Furniture i: furnitures){
            i.setPlace(this);
        }
    }
    public void clean(Person person) {
        for(Furniture i: furnitures) {
            if (ICleanable.class.isAssignableFrom(i.getClass()))
            {
                ((ICleanable) i).clean(person);
            }
        }
    }

    public void addFurniture(Furniture furniture, Person person){
        furnitures.add(furniture);
        System.out.printf("%s принес %s в %s", person.getName(), furniture.getName(), getName());
    }

    public void removeFurniture(Furniture furniture, Person person){
        furnitures.remove(furniture);
        System.out.printf("%s вынес %s из %s", person.getName(), furniture.getName(), getName());
    }

    public void changeTime(TimeOfDay time){
        this.time = time;
        System.out.println("Наступил " + time);
    }
    public TimeOfDay getTime(){
        return time;
    }

    public String getName(){
        return name;
    }

    @Override
    public int hashCode () {
        return Objects.hash(time, name, furnitures);
    }
}
