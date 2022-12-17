package entities;

import interfaces.IBreakable;
import interfaces.ICanMove;
import places.Place;

public class Furniture implements ICanMove, IBreakable {
    private String name;
    private Boolean isFlying = false;
    private Boolean isBroken = false;
    private Boolean isLying = false;
    private Boolean isHanging = false;
    private Place place;

    public Furniture(String name){
        this.name = name;
    }

    public void setPlace(Place place){
        this.place = place;
    }
    public String getName(){
        return name;
    }

    @Override
    public Boolean getIsFlying() {
        return isFlying;
    }

    @Override
    public Boolean getIsHanging() {
        return isHanging;
    }

    @Override
    public Boolean getIsLying() {
        return isLying;
    }

    @Override
    public void setIsFlying(Boolean isFlying) {
        this.isFlying = isFlying;
    }

    @Override
    public void setIsLying(Boolean isLying) {
        this.isLying = isLying;
    }

    @Override
    public void setIsHanging(Boolean isHanging) {
        this.isHanging = isHanging;
    }

    @Override
    public void broke() {
        this.isBroken = true;
    }

    @Override
    public void repair() {
        this.isBroken = false;
    }

    @Override
    public Boolean getIsBroken() {
        return isBroken;
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
        Furniture obj = (Furniture) otherObject;
        return (obj).name == name && place.equals(obj.place);
    }
}
