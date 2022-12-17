package actions;

import characters.Person;
import core.Validation;
import interfaces.IBreakable;
import interfaces.ICanMove;

public class Action {
    public static void takeOff(ICanMove iCanMove){
        Validation.ActionCheck.isFlying(iCanMove, false);
        System.out.println(iCanMove.getName() + " взлетел.");
        iCanMove.setIsFlying(true);
        iCanMove.setIsLying(false);
    }

    public static void fell(ICanMove iCanMove){
        Validation.ActionCheck.isFlying(iCanMove, true);
        System.out.println(iCanMove.getName() + " упал.");
        iCanMove.setIsFlying(false);
        iCanMove.setIsLying(true);
    }

    public static void raise(Person person, ICanMove iCanMove){
        Validation.ActionCheck.isLying(iCanMove, true);
        System.out.println(person.getName() + " поднял " + iCanMove.getName());
        iCanMove.setIsLying(false);
    }

    public static void getUp(Person person){
        Validation.ActionCheck.isLying(person, true);
        System.out.println(person.getName() + " поднялся.");
        person.setIsLying(false);
    }
    public static void unbend(Person person){
        Validation.ActionCheck.isBandOver(person, true);
        System.out.println(person.getName() + " выпрямился.");
        person.setIsBandOver(false);
    }
    public static void bandOver(Person person){
        Validation.ActionCheck.isBandOver(person, false);
        System.out.println(person.getName() + " наклонился.");
        person.setIsBandOver(true);
    }

    public static void bump(ICanMove iCanMove){
        System.out.println(iCanMove.getName() + " ударился.");
    }

    public static void bump(ICanMove who, ICanMove target){
        System.out.println(who.getName() + " ударился о " + target.getName());
    }

    public static void breakSomething(ICanMove hitter, IBreakable target){
        Validation.ActionCheck.isBroken(target, false);
        System.out.println(hitter.getName() + " сломал " + target.getName());
        target.broke();
    }

    public static void repair(Person person, IBreakable iBreakable){
        Validation.ActionCheck.isBroken(iBreakable, true);
        System.out.println(person.getName() + " починил " + iBreakable.getName());
        iBreakable.repair();
    }

    public static void hang(ICanMove iCanMove){
        if (!iCanMove.getIsHanging()){
            System.out.println(iCanMove.getName() + " повис.");
            iCanMove.setIsHanging(true);
        }
        else {
            System.out.println(iCanMove.getName() + " спустился.");
            iCanMove.setIsHanging(false);
        }
    }
}
