package controller;

import service.LiftService;

public class LiftController {

    LiftService liftService;
    public LiftController(LiftService liftService){
        this.liftService = liftService;
    }

    public void createBuildingLift(int floors,int liftCount){
        liftService.createBuildingLift(floors, liftCount);
    }

    public int addRequest(int startFloor, int endFloor){
        return liftService.requestLift(startFloor,endFloor);
    }

}
