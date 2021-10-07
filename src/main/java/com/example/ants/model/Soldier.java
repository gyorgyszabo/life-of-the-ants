package com.example.ants.model;

import com.example.ants.colony.Colony;
import com.example.ants.geometry.Direction;
import com.example.ants.geometry.Position;

public class Soldier extends Ant {

    private Direction lastDirection = Direction.getDirectionById(RANDOM.nextInt(4));

    public Soldier(Colony colony, Position position) {
        super(colony, position);
    }

    @Override
    public void move() {
        Direction direction = Direction.getNextDirectionLeft(lastDirection);
        int newPositionX = position.getX() + direction.getMoveX();
        int newPositionY = position.getY() + direction.getMoveY();
        if (newPositionX >= 0 && newPositionX < colony.getWidth() && newPositionY >= 0 && newPositionY < colony.getWidth()) {
            lastDirection = direction;
            position.setX(newPositionX);
            position.setY(newPositionY);
        }
    }

}
