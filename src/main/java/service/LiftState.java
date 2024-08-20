package service;

import constant.Direction;
import model.Lift;

public abstract class LiftState {
    protected Lift lift;
    public LiftState(Lift lift){
        this.lift = lift;
    }
    public void updateFloor(){};
    public void updateDirection(){};
    public abstract int timeToReachFloor(int floor, Direction direction);
    public abstract Direction getDirection();

}
