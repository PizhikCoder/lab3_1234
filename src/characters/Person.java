package characters;

import entities.Furniture;
import feelings.Feeling;
import feelings.MoodLevels;
import interfaces.ICurable;
import interfaces.IWallowable;
import places.Place;

import java.util.ArrayList;
import java.util.List;

public abstract class Person {
    private String name;
    private List<Feeling> feelings;
    private MoodLevels moodLevel;
    private Boolean isSleep;

    public Person(String name, Feeling ... feelings){
        this.name = name;
        isSleep = false;
        moodLevel = MoodLevels.NORMAL;
        if (feelings == null){
            this.feelings = new ArrayList<>();
        }
        else{
            this.feelings = new ArrayList<>(List.of(feelings));
        }
    }
    public void setMood(MoodLevels moodLevel){
        this.moodLevel = moodLevel;
        System.out.printf("у %s настроение сменилось на %s\n", getName(), moodLevel);
    }
    public MoodLevels getMood(){
        return moodLevel;
    }

    public String getName() {
        return name;
    }

    public void addFeeling(Feeling feeling){
        if (!canFeel(feeling)){
            feelings.add(feeling);
            System.out.println(getName() + " получил чувство: " + feeling.getName());
        }
    }

    public void wakeUp(){
        System.out.println(getName() + " проснулся.");
        isSleep = false;
    }

    public void sleep(){
        System.out.println(getName() + " заснул.");
        isSleep = true;
    }

    public Boolean canFeel(Feeling feeling){
        for(Feeling i: feelings){
            if (i.equals(feeling)){
                return true;
            }
        }
        return false;
    }

    public void removeFeeling(Feeling feeling){
        if (canFeel(feeling)){
            feelings.remove(feeling);
            System.out.println(getName() + " избавляется от " + feeling.getName());
        }
    }

    public Feeling getFeeling(Feeling feeling){
        for(Feeling i: feelings){
            if(i.equals(feeling)){
                return i;
            }
        }
        return null;
    }

    public void treat(ICurable iCurable){
        iCurable.cure(this);
    }

    public void wallow(IWallowable place) {
        place.wallow(this);
    }

    public void doExercises(){
        System.out.println(getName() + " сделал утреннюю зарядку.");
    }

    public void washUp(){
        System.out.println(getName() + " умылся.");
    }
    public void go(Place from, Place to){
        System.out.println(getName() + " ушел из " + from.getName() + " в " + to.getName());
    }
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
        return (obj).getName() == name;
    }
}
