package constant;

public enum Direction {
    UP("UP"),
    Down("DOWN"),
    Idle("IDLE");

    private final String direction;

    Direction(String direction){
        this.direction = direction;
    }

    public String getDirection(){
        return direction;
    }


    @Override
    public String toString(){
        return direction;
    }


}
