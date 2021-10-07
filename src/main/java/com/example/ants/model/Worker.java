package com.example.ants.model;

import com.example.ants.colony.Colony;
import com.example.ants.geometry.Direction;
import com.example.ants.geometry.Position;

public class Worker extends Ant {

    public Worker(Colony colony, Position position) {
        super(colony, position);
    }

    @Override
    public void move() {
        while (true) {
            Direction direction = Direction.getDirectionById(RANDOM.nextInt(4));
            int newPositionX = position.getX() + direction.getMoveX();
            int newPositionY = position.getY() + direction.getMoveY();
            if (newPositionX >= 0 && newPositionX < colony.getWidth() && newPositionY >= 0 && newPositionY < colony.getWidth()) {
                position.setX(newPositionX);
                position.setY(newPositionY);
                break;
            }
        }
    }

}
