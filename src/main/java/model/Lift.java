package model;

import constant.Direction;
import lombok.Getter;
import lombok.Setter;
import service.IdleLiftState;
import service.LiftState;
import service.MovingDownState;
import service.MovingUpState;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Lift {
    int currFloor;
    List<LiftRequest> requests;
    LiftState movingUpState,movingDownState, idleState,state;


    public Lift(){
        currFloor = 0;
        this.requests = new ArrayList<LiftRequest>();
        this.movingUpState = new MovingUpState(this);
        this.movingDownState = new MovingDownState(this);
        this.idleState = new IdleLiftState(this);
        this.state = new IdleLiftState(this);
    }

    public int timeToReachFloor(int floor, Direction direction){
        return state.timeToReachFloor(floor, direction);
    }
    public Direction getDirection(){
        return  state.getDirection();
    }

    public void updateState(int startFloor, int endFloor){
        Direction direction = Direction.Idle;
        if(startFloor < endFloor) direction = Direction.UP;
        if(startFloor > endFloor) direction = Direction.Down;
        switch (direction){
            case UP:
                this.state = movingUpState;
                break;
            case Down:
                this.state = movingDownState;
                break;
            case Idle:
                this.state = idleState;

        }
    }

}
