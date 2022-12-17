package interfaces;

public interface ICanMove {
    String getName();
    Boolean getIsFlying();
    Boolean getIsHanging();
    Boolean getIsLying();
    void setIsFlying(Boolean isFlying);
    void setIsLying(Boolean isLying);
    void setIsHanging(Boolean isHanging);
}
