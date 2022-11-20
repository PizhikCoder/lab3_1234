import characters.Znayka;
import entities.*;
import feelings.MoodLevels;
import feelings.mentalfeelings.Laziness;
import feelings.mentalfeelings.Mood;
import feelings.physicalfeelings.Dizziness;
import feelings.physicalfeelings.Headache;
import interfaces.IContainable;
import interfaces.ICurable;
import interfaces.IWallowable;
import places.ClosedPlace;
import places.TimeOfDay;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClosedPlace room = new ClosedPlace("Znayka's room", TimeOfDay.MORNING, new Bed("Znayka's bed"), new Cupboard("Znayka's cupboard", new UnusableEntity("Химические вещества")), new Table("Znayka's table", new UnusableEntity("Books")),new Windowsill("Znayka's windowsill"));
        Znayka znayka = Znayka.getObj();
        znayka.wakeUp();
        znayka.addFeeling(new Laziness());
        Laziness.lazyAbout(znayka, "встать с кровати");
        znayka.addFeeling(new Headache());
        znayka.addFeeling(new Dizziness());
        znayka.wallow((IWallowable) room.getEntityByName("Znayka's bed"));
        znayka.treat((ICurable) znayka.getFeeling(new Headache()));
        ((Bed)room.getEntityByName("Znayka's bed")).getUp(znayka);
        znayka.doExercises();
        znayka.treat((ICurable) znayka.getFeeling(new Dizziness()));
        znayka.removeFeeling(new Dizziness());
        room.clean(znayka);
        List<Entity> entities = new ArrayList<>(((IContainable)room.getEntityByName("Znayka's table")).getEntities());
        ((IContainable)room.getEntityByName("Znayka's table")).shiftEntities(znayka,(IContainable)room.getEntityByName("Znayka's cupboard"), entities);
        Mood.changeMood(znayka, MoodLevels.GREAT);
    }
}