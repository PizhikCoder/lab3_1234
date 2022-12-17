import actions.Action;
import characters.Znayka;
import entities.*;
import feelings.Feeling;
import feelings.MoodLevels;
import feelings.mentalfeelings.Laziness;
import feelings.physicalfeelings.Dizziness;
import feelings.physicalfeelings.Headache;
import interfaces.IContainable;
import interfaces.ICurable;
import interfaces.IWallowable;
import places.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Znayka znayka = Znayka.getObj();


        Laboratory laboratory = new Laboratory("Лаборатория Знайки", TimeOfDay.MORNING, 23);
        Laboratory.Liquid water = laboratory.new Liquid("Вода");
        Laboratory.Liquid acid = laboratory.new Liquid("Кислота");
        Laboratory.Reagent moonStone = laboratory.new Reagent("Лунный камень");
        laboratory.explore(znayka, moonStone);
        acid.submerge(moonStone);
        water.submerge(moonStone);
        acid.pullOutReagent(moonStone);
        water.submerge(moonStone.setIsSwimming(true));
        water.pullOutReagent(moonStone);
        laboratory.heat(TypeOfHeating.FIRE, 300, moonStone);
        System.out.println("Температура "+ moonStone.getName() + " стала: " + moonStone.getTemperature());
        laboratory.heat(TypeOfHeating.TIGLA, 20, moonStone);
        moonStone.loseHeat(200);
        System.out.println("Температура "+ moonStone.getName() + " стала: " + moonStone.getTemperature());

        ClosedPlace room = new ClosedPlace("Znayka's room", TimeOfDay.MORNING, new Bed("Znayka's bed"), new Wardrobe("Znayka's wardrobe", new SmallThing("Химические вещества")), new Table("Znayka's table", new SmallThing("Books")),new Windowsill("Znayka's windowsill"), new Furniture("Люстра"), new Furniture("Стул"));
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
        laboratory.removeReagent(moonStone);
        ((Table)room.getFurnitureByName("Znayka's table")).addThing(znayka, moonStone);
        List<SmallThing> entities = new ArrayList<>(((IContainable)room.getFurnitureByName("Znayka's table")).getThings());
        ((IContainable)room.getFurnitureByName("Znayka's table")).shiftThings(znayka,(IContainable)room.getFurnitureByName("Znayka's wardrobe"), entities);
        znayka.setMood(MoodLevels.GREAT);
        room.openTheDoor(znayka);
        OpenedPlace a = new OpenedPlace("Лужайка", room.getTime(), WeatherType.WINDY, new Furniture("Зонт"));
        znayka.go(room, a);
        a.setWeather(WeatherType.RAINY);
        znayka.go(a, room);
        Action.bandOver(znayka);

        Feeling lightLaziness = new Feeling("Легкое головокружение"){};//We are creating an object of abstract class by using anonymous class
        znayka.addFeeling(lightLaziness);
        znayka.removeFeeling(znayka.getFeeling(lightLaziness));


        Action.unbend(znayka);

        Action.takeOff(znayka);
        Action.takeOff(room.getFurnitureByName("Стул"));
        Action.bump(znayka, room.getFurnitureByName("Стул"));
        Action.fell(znayka);
        Action.breakSomething(room.getFurnitureByName("Стул"), room.getFurnitureByName("Люстра"));
        Action.getUp(znayka);
        Action.fell(room.getFurnitureByName("Стул"));
        Action.raise(znayka, room.getFurnitureByName("Стул"));
        Action.repair(znayka, room.getFurnitureByName("Люстра"));

        ((Bed)room.getFurnitureByName("Znayka's bed")).lieDown(znayka);


        znayka.addFeeling(new Headache());
        znayka.sleep();


    }
}