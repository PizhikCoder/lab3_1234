package characters;

import feelings.Feeling;
import feelings.mentalfeelings.Mood;
import interfaces.ICurable;
import interfaces.IWallowable;

import java.util.ArrayList;
import java.util.List;

public abstract class Person {
    private String name;
    private List<Feeling> feelings;

    public Person(String name, Feeling ... feelings){
        this.name = name;
        if (feelings == null){
            this.feelings = new ArrayList<>();
            this.addFeeling(new Mood());
        }
        else{
            this.feelings = new ArrayList<>(List.of(feelings));
            this.feelings.add(new Mood());
        }
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
    }

    public void sleep(){
        System.out.println(getName() + " заснул.");
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
}