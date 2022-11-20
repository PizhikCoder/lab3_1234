package feelings;

public abstract class Feeling {
    private String name;
    public Feeling(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject){
            return  true;
        }
        if (otherObject == null){
            return false;
        }
        if (getClass() != otherObject.getClass()){
            return false;
        }

        return ((Feeling) otherObject).name == name;
    }
}
