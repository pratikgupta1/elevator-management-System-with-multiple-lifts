package service;

import constant.Direction;
import model.Lift;
import model.LiftRequest;

public class MovingDownState extends LiftState{
    public MovingDownState(Lift lift) {
        super(lift);
    }

    public int timeToReachFloor(int floor, Direction direction) {
        int liftCurr = lift.getCurrFloor();
        if(direction.getDirection().equalsIgnoreCase(Direction.Down.getDirection())){
            if(floor > liftCurr) return -1;
            return  liftCurr - floor;
        }
        int minloor = getMinDownFloor();
        // for opp direction
        int time = liftCurr - minloor + floor - minloor;
        return time;
    }

    private int getMinDownFloor(){
        int minloor = 999;
        for(LiftRequest liftRequest : lift.getRequests()){
            if(minloor > liftRequest.getEndFloor()){
                minloor = liftRequest.getEndFloor();
            }
            if(minloor > liftRequest.getStartFloor()){
                minloor = liftRequest.getStartFloor();
            }
        }
        return minloor;
    }

    public Direction getDirection() {
        return null;
    }
}
