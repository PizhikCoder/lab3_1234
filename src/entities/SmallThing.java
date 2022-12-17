package entities;

import interfaces.IBreakable;
import interfaces.ICanMove;

public class SmallThing implements ICanMove, IBreakable {
    private String name;
    private Boolean isFlying = false;
    private Boolean isBroken = false;
    private Boolean isLying = false;
    private Boolean isHanging = false;
    public SmallThing(String name) {
        this.name = name;
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
        SmallThing obj = (SmallThing) otherObject;
        return (obj).name.equals(name);
    }
}
