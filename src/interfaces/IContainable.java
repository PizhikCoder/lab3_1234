package interfaces;

import characters.Person;
import entities.Entity;

import java.util.List;

public interface IContainable {
    Boolean containEntity(Entity entity);
    void shiftEntities(Person person, IContainable to, Entity ... entities);
    void shiftEntities(Person person, IContainable to, List<Entity> entities);
    void addEntity(Person person, Entity entity);
    List<Entity> getEntities();
    void removeEntity(Person person, Entity entity);
    String getName();
}
