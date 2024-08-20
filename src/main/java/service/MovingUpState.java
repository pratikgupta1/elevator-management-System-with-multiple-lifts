package service;

import constant.Direction;
import model.Lift;
import model.LiftRequest;

public class MovingUpState extends LiftState{

    public MovingUpState(Lift lift){
        super(lift);
    }

    public int timeToReachFloor(int floor, Direction direction) {
        int liftCurr = lift.getCurrFloor();
        if(direction.getDirection().equalsIgnoreCase(Direction.UP.getDirection())){
            if(floor < liftCurr) return -1;
            return floor - liftCurr;
        }
        int maxFloor = getMaxUpFloor();
        // for opp direction
        int time = maxFloor - liftCurr + maxFloor - floor;
        return time;
    }

    private int getMaxUpFloor(){
        int maxFloor = -1;
        for(LiftRequest liftRequest : lift.getRequests()){
            if(maxFloor < liftRequest.getEndFloor()){
                maxFloor = liftRequest.getEndFloor();
            }
            if(maxFloor < liftRequest.getStartFloor()){
                maxFloor = liftRequest.getStartFloor();
            }
        }
        return maxFloor;
    }

    public Direction getDirection() {
        return null;
    }
}
