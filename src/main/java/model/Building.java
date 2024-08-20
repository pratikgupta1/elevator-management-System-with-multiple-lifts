package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Building {
    int floors;
    Lift[] lifts;

    public Building(int floors,int liftCount){
        this.floors = floors;
        this.lifts = new Lift[liftCount];
    }

    public void updateLiftAtIndex(Lift lift, int index){
        lifts[index] = lift;
    }
}
