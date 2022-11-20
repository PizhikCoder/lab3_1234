package feelings.mentalfeelings;

import characters.Person;
import feelings.Feeling;
import feelings.MoodLevels;

public class Mood extends Feeling {
    private MoodLevels level;
    public Mood(MoodLevels level){
        super("Настроение");
        this.level = level;
    }
    public Mood(){
        super("Настроение");
        this.level = MoodLevels.NORMAL;
    }
    public static void changeMood(Person person, MoodLevels level){
        Mood mood = (Mood)person.getFeeling(new Mood());
        mood.level = level;
        System.out.println("У " + person.getName() + " настроение сменилось на " + level);
    }
}
