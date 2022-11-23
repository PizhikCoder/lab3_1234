package entities;

public class SmallThing {
    private String name;
    public SmallThing(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
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
        return (obj).name == name;
    }
}
