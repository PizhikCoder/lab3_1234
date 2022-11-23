import characters.Znayka;
import entities.*;
import feelings.MoodLevels;
import feelings.mentalfeelings.Laziness;
import feelings.physicalfeelings.Dizziness;
import feelings.physicalfeelings.Headache;
import interfaces.IContainable;
import interfaces.ICurable;
import interfaces.IWallowable;
import places.ClosedPlace;
import places.OpenedPlace;
import places.TimeOfDay;
import places.WeatherType;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClosedPlace room = new ClosedPlace("Znayka's room", TimeOfDay.MORNING, new Bed("Znayka's bed"), new Wardrobe("Znayka's wardrobe", new SmallThing("Химические вещества")), new Table("Znayka's table", new SmallThing("Books")),new Windowsill("Znayka's windowsill"));
        Znayka znayka = Znayka.getObj();
        znayka.wakeUp();
        znayka.addFeeling(new Laziness());
        Laziness.lazyAbout(znayka, "встать с кровати");
        znayka.addFeeling(new Headache());
        znayka.addFeeling(new Dizziness());
        znayka.wallow((IWallowable) room.getFurnitureByName("Znayka's bed"));
        znayka.treat((ICurable) znayka.getFeeling(new Headache()));
        ((Bed)room.getFurnitureByName("Znayka's bed")).getUp(znayka);
        znayka.doExercises();
        znayka.treat((ICurable) znayka.getFeeling(new Dizziness()));
        znayka.removeFeeling(new Dizziness());
        room.clean(znayka);
        List<SmallThing> entities = new ArrayList<>(((IContainable)room.getFurnitureByName("Znayka's table")).getThings());
        ((IContainable)room.getFurnitureByName("Znayka's table")).shiftThings(znayka,(IContainable)room.getFurnitureByName("Znayka's wardrobe"), entities);
        znayka.setMood(MoodLevels.GREAT);
        room.openTheDoor(znayka);
        OpenedPlace a = new OpenedPlace("Лужайка", room.getTime(), WeatherType.WINDY, new Furniture("Зонт"));
        znayka.go(room, a);
        a.setWeather(WeatherType.RAINY);
        znayka.addFeeling(new Headache());
        znayka.go(a, room);
        ((Bed)room.getFurnitureByName("Znayka's bed")).lieDown(znayka);
        znayka.sleep();

    }
}