package core;

import characters.Person;
import exceptions.ActionException;
import exceptions.NullReagentException;
import exceptions.ReagentDoesNotExistException;
import interfaces.IBreakable;
import interfaces.ICanMove;
import places.Laboratory.Reagent;

import java.util.List;

public class Validation {
    public static class ReagentCheck{
        public static void isNull(Reagent ... reagents) throws NullReagentException{
            if (reagents == null){
                throw new NullReagentException("Было передано null реагентов.");
            }
        }
        public static void isNull(String customContext, Reagent ... reagents) throws NullReagentException{
            if (reagents == null){
                throw new NullReagentException(customContext);
            }
        }
        public static void isExist(Reagent reagent, List<Reagent> reagents) throws ReagentDoesNotExistException{
            for (Reagent r: reagents) {
                if (r.equals(reagent)) {
                    return;
                }
            }
            throw new ReagentDoesNotExistException("Реагент не существует");
        }
        public static void isExist(Reagent reagent, List<Reagent> reagents, String customContext) throws ReagentDoesNotExistException{
            for (Reagent r: reagents) {
                if (r.equals(reagent)) {
                    return;
                }
            }
            throw new ReagentDoesNotExistException(customContext);
        }
    }

    public static class ActionCheck{
        public static void isFlying(ICanMove iCanMove, Boolean targetValue){
            if (iCanMove.getIsFlying() != targetValue){
                throw new ActionException("У объекта " + iCanMove.getName() + " конфликт значений(Ожидалось isFlying: " + targetValue + ", получено: " + !targetValue);

            }
        }
        public static void isLying(ICanMove iCanMove, Boolean targetValue){
            if (iCanMove.getIsLying() != targetValue){
                throw new ActionException("У объекта " + iCanMove.getName() + " конфликт значений(Ожидалось isFlying: " + targetValue + ", получено: " + !targetValue);

            }
        }

        public static void isBandOver(Person person, Boolean targetValue){
            if (person.getIsBandOver() != targetValue){
                throw new ActionException("У объекта " + person.getName() + " конфликт значений(Ожидалось isFlying: " + targetValue + ", получено: " + !targetValue);

            }
        }

        public static void isBroken(IBreakable iBreakable, Boolean targetValue){
            if (iBreakable.getIsBroken() != targetValue){
                throw new ActionException("У объекта " + iBreakable.getName() + " конфликт значений(Ожидалось isFlying: " + targetValue + ", получено: " + !targetValue);

            }
        }
    }

}
