package places;

import characters.Person;
import core.Validation;
import entities.Furniture;
import entities.SmallThing;
import exceptions.NullReagentException;
import exceptions.ReagentDoesNotExistException;
import exceptions.ReagentException;

import java.util.ArrayList;
import java.util.List;

public class Laboratory extends ClosedPlace{
    List<Reagent> reagents = new ArrayList<>();
    private int temperature;
    public class Reagent extends SmallThing {
        private int weight;
        private int temperature = Laboratory.this.temperature;
        private Boolean isBurning = false;
        private Boolean isSwimming = false;
        private Boolean isSoluble = false;

        public Reagent(String name){
            super(name);
            Laboratory.this.reagents.add(this);
        }

        public void setWeight(int weight){
            this.weight = weight;
        }

        public int getWeight(){
            return weight;
        }

        public Reagent setIsSwimming(Boolean isSwimming){
            this.isSwimming = isSwimming;
            return this;
        }

        public Reagent setIsSoluble(Boolean isSoluble){
            this.isSwimming = isSwimming;
            return this;
        }

        public Reagent setIsBurning(Boolean isBurning){
            this.isSwimming = isSwimming;
            return this;
        }

        public Boolean getIsSwimming(){
            return isSwimming;
        }

        public Boolean getIsBurning(){
            return isBurning;
        }

        public Boolean getIsSoluble(){
            return isSoluble;
        }

        public void setTemperature(int temperature){
            this.temperature = temperature;
        }

        public void loseHeat(int value){
            System.out.println(getName() + " потерял тепловую энергию и охладился на " + value + " градусов." );
            temperature -= value;
        }

        public int getTemperature(){
            return temperature;
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj){
                return true;
            }
            if(getClass() != obj.getClass()){
                return false;
            }
            if (obj == null){
                return false;
            }
            Reagent reagent = (Reagent) obj;
            return super.equals(reagent) && isBurning == reagent.isBurning && isSoluble == reagent.isSoluble && isSwimming == reagent.isSwimming;
        }

        @Override
        public String toString() {
            return String.format("Реагент %s\nХарактеристики:\nТемпература: %s\n Вес: %s\nСвойства:\nРасстворяемый: %s\nПлавающий: %s\n Сжигаемый: %s", getName(), getTemperature(), getWeight(), getIsSoluble(), getIsSwimming(), getIsBurning());
        }
    }

    public class Liquid extends Reagent{
        private List<Reagent> reagents = new ArrayList<>();
        public Liquid(String name) {
            super(name);
        }
        public void submerge(Reagent reagent){

            try {
                Validation.ReagentCheck.isExist(reagent, Laboratory.this.reagents, "Реагент отсутствует в лаборатории.");

                if (reagent.isSoluble){
                    System.out.println(reagent.getName() + " расстворен в " + getName());
                }
                else{
                    reagents.add(reagent);
                    System.out.println(reagent.getName() + " помещен в " + getName());
                    Laboratory.this.removeReagent(reagent);
                    if (reagent.isSwimming){
                        System.out.println(reagent.getName() + " плавает в " + getName());
                    }
                    else {
                        System.out.println(reagent.getName() + " утонул в " + getName());
                    }
                }
            }
            catch (ReagentDoesNotExistException ex){
                System.out.println(ex.getContext());
            }
        }
        public void pullOutReagent(Reagent reagent){
            try{
                Validation.ReagentCheck.isExist(reagent, reagents);
                reagents.remove(reagent);
                Laboratory.this.addReagents(reagent);
                System.out.println(reagent.getName() + " вытащен из " + getName());
            }
            catch (ReagentDoesNotExistException ex){
                System.out.println(ex.getContext());
            }
        }
    }

    public class Metal extends Reagent{

        public Metal(String name) {
            super(name);
        }
    }

    public class NonMetal extends Reagent{

        public NonMetal(String name) {
            super(name);
        }
    }

    public Laboratory(String name, TimeOfDay time, int temperature, Furniture... entities) {
        super(name, time, entities);
        this.temperature = temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getTemperature(){
        return temperature;
    }

    public void removeReagent(Reagent reagent){
        try{
            Validation.ReagentCheck.isExist(reagent, reagents);
            reagents.remove(reagent);
        }
        catch(ReagentDoesNotExistException ex){
            System.out.println(ex.getContext());
        }
    }
    public void addReagents(Reagent ... reagents){
        try{
            Validation.ReagentCheck.isNull(reagents);
            for (Reagent reagent: reagents){
                this.reagents.add(reagent);
            }
        }
        catch (NullReagentException ex){
            System.out.println(ex.getContext());
        }
    }

    public List<Reagent> getReagents(){
        return reagents;
    }

    public void explore(Person person, Reagent reagent){
        System.out.println(person.getName() + " изучает " + reagent.getName());
    }

    public void heat (TypeOfHeating typeOfHeating, int temperatureRise, Reagent ... reagents ){
        class Fire{
            private List<Reagent> reagents;

            public Fire(){
                reagents = new ArrayList<>();
            }

            void burn(){
                for(Reagent reagent: reagents){
                    if (reagent.isBurning){
                        System.out.println(reagent.getName() + " сгорел в огне.");
                        reagents.remove(reagent);
                    }
                    else{
                        System.out.println(reagent.getName() + " обожжен в огне и нагрет на " + temperatureRise + " градусов.");
                        reagent.temperature += temperatureRise;
                    }
                }
            }

            public void addReagents(Reagent ... reagents) throws NullReagentException {
                Validation.ReagentCheck.isNull(reagents);
                for (Reagent reagent: reagents){
                    this.reagents.add(reagent);
                    System.out.println(reagent.getName() + " был помещен в костер.");
                    Laboratory.this.removeReagent(reagent);
                }
            }

            public List<Reagent> getReagents(){
                return reagents;
            }

            public void removeReagent(Reagent reagent) {
                for (Reagent r: reagents){
                    if (r.equals(reagent)){
                        reagents.remove(reagent);
                        System.out.println(reagent.getName() + " был убран из костра.");
                        Laboratory.this.addReagents(r);

                        return;
                    }
                }
            }
            public void putOutReagents(){
                reagents.forEach(Laboratory.this::addReagents);
                reagents = null;
                System.out.println("Реагенты убраны из костра.");
            }

        }
        class Tigla{
            private List<Reagent> reagents;

            public Tigla(){
                reagents = new ArrayList<>();
            }

            void heat(){
                for(Reagent reagent: reagents){
                    System.out.println(reagent.getName() + " нагрет в тигле на " +  temperatureRise + " градусов.");
                }
            }

            public void addReagents(Reagent ... reagents) throws NullReagentException {
                Validation.ReagentCheck.isNull(reagents);
                for (Reagent reagent: reagents){
                    this.reagents.add(reagent);
                    System.out.println(reagent.getName() + " был помещен в тиглу.");
                    Laboratory.this.removeReagent(reagent);
                }
            }

            public List<Reagent> getReagents(){
                return reagents;
            }

            public void removeReagent(Reagent reagent){
                for (Reagent r: reagents){
                    if (r.equals(reagent)){
                        reagents.remove(reagent);
                        System.out.println(reagent.getName() + " был убран из тиглы.");
                        Laboratory.this.addReagents(r);
                        return;
                    }
                }
            }

            public void putOutReagents(){
                reagents.forEach(Laboratory.this::addReagents);
                reagents = null;
                System.out.println("Реагенты убраны из тиглы");
            }
        }
        try {
            switch (typeOfHeating){
                case FIRE:
                    Fire fire = new Fire();
                    fire.addReagents(reagents);
                    fire.burn();
                    fire.putOutReagents();
                    break;
                case TIGLA:
                    Tigla tigla = new Tigla();
                    tigla.addReagents(reagents);
                    tigla.heat();
                    tigla.putOutReagents();
                    break;
                default:

            }
        }
        catch (NullReagentException ex) {
            System.out.println(ex.getContext());
        }
    }
}
