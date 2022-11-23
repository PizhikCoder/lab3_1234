package places;

import characters.Person;
import entities.Furniture;

public class OpenedPlace extends Place{
    private WeatherType weather;
    public OpenedPlace(String name, TimeOfDay time, WeatherType weather, Furniture... entities) {
        super(name, PlaceType.OPENED, time, entities);
        this.weather = weather;
    }
    public WeatherType getWeather(){
        return weather;
    }
    public void setWeather(WeatherType weather){
        this.weather = weather;
        System.out.printf("В %s погода стала %s\n", getName(), weather);
    }
    @Override
    public void clean(Person person) {
        System.out.println(person.getName() + " подмел в " + getName());
        super.clean(person);
    }
}
