package service;

import constant.Direction;
import model.Lift;

public class IdleLiftState extends LiftState{
    public IdleLiftState(Lift lift) {
        super(lift);
    }

    public int timeToReachFloor(int floor, Direction direction) {
        return 0;
    }

    public Direction getDirection() {
        return null;
    }
}
