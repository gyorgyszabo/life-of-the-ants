package com.example.ants.geometry;

public enum Direction {

    NORTH(0, -1),
    EAST(1, 0),
    SOUTH(0, 1),
    WEST(-1, 0);

    private final int MOVE_X;
    private final int MOVE_Y;

    Direction(int moveX, int moveY) {
        this.MOVE_X = moveX;
        this.MOVE_Y = moveY;
    }

    public int getMoveX() {
        return MOVE_X;
    }

    public int getMoveY() {
        return MOVE_Y;
    }

    public static Direction getDirectionById(int id) {
        return values()[id];
    }

    public static Direction getNextDirectionLeft(Direction direction) {
        switch (direction) {
            case NORTH:
                return WEST;
            case WEST:
                return SOUTH;
            case SOUTH:
                return EAST;
            case EAST:
        }
        return NORTH;
    }

}
