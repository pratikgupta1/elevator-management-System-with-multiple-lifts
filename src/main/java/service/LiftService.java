package service;

import model.Building;
import model.Lift;
import model.LiftRequest;

import java.util.List;

public class LiftService {

    protected Building building;

    public LiftService(Building building){
        this.building = building;
    }

    // it will return the index of the lift
    public int requestLift(int startFloor, int endFloor){
        LiftRequest liftRequest = new LiftRequest(startFloor,endFloor);

        int liftId = -1;
        int minTimeToReachStart = 1000;
        Lift[] lifts = building.getLifts();
        for(int i = 0 ; i < building.getLifts().length ; i++){
            Lift lift = lifts[i];
            int timeToReachStart = lift.timeToReachFloor(startFloor,lift.getDirection());
            if(timeToReachStart < minTimeToReachStart) {
                minTimeToReachStart = timeToReachStart;
                liftId = i;
            }
        }
        if(liftId >= 0 && liftId < building.getLifts().length){
            List<LiftRequest> liftRequests = lifts[liftId].getRequests();
            liftRequests.add(liftRequest);
            lifts[liftId].updateState(startFloor,endFloor);
            building.setLifts(lifts);
        }
        return liftId;
    }
}
