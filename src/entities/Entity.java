package entities;

import feelings.Feeling;
import places.Place;

public abstract class Entity {
    private String name;
    private Place place;

    public Entity(String name){
        this.name = name;
    }

    public void setPlace(Place place){
        this.place = place;
    }
    public String getName(){
        return name;
    }
    public Place getPlace()
    {
        return place;
    }

    @Override
    public String toString() {
        return getName() + " расположен в " + place.getName();
    }
    @Override
    public boolean equals(Object otherObject) {
        if(this == otherObject){
            return true;
        }
        if (otherObject == null){
            return false;
        }
        if (getClass() != otherObject.getClass()){
            return false;
        }
        Entity obj = (Entity) otherObject;
        return (obj).name == name && place.equals(obj.place);
    }
}
