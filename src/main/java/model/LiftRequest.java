package model;


import constant.Direction;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LiftRequest {
    private int startFloor;
    private int endFloor;
    private Direction direction;
    public LiftRequest(int startFloor,int endFloor){
        this.startFloor = startFloor;
        this.endFloor = endFloor;
        direction = getDirection();
    }
    public Direction getDirection(){
        if(endFloor > startFloor) return Direction.UP;
        if(startFloor > endFloor) return Direction.Down;
        else return Direction.Idle;
    }

}
