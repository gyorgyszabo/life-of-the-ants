package com.example.ants.model;

import com.example.ants.colony.Colony;
import com.example.ants.geometry.Position;

public class Drone extends Ant {

    private final Position queenPosition = colony.getQueen().position;
    private int stayingStepsLeft = 10;

    public Drone(Colony colony, Position position) {
        super(colony, position);
    }

    @Override
    public void move() {
        if (position.getX() == queenPosition.getX() && position.getY() == queenPosition.getY()) {
            if (colony.getQueen().isMating() || stayingStepsLeft < 10 && stayingStepsLeft > 0) {
                stayingStepsLeft--;
                return;
            } else { //NOTE Kick
                stayingStepsLeft = 10;
                switch (RANDOM.nextInt(4)) {
                    case 0:
                        position.setX(0);
                        position.setY(RANDOM.nextInt(colony.getWidth()));
                        return;
                    case 1:
                        position.setX(colony.getWidth() - 1);
                        position.setY(RANDOM.nextInt(colony.getWidth()));
                        return;
                    case 2:
                        position.setX(RANDOM.nextInt(colony.getWidth()));
                        position.setY(0);
                        return;
                    case 3:
                        position.setX(RANDOM.nextInt(colony.getWidth()));
                        position.setY(colony.getWidth() - 1);
                        return;
                }
            }
        }
        int distanceX = Math.abs(position.getX() - queenPosition.getX());
        int distanceY = Math.abs(position.getY() - queenPosition.getY());
        if (distanceX > distanceY) {
            if (position.getX() > queenPosition.getX()) {
                position.setX(position.getX() - 1);
            } else {
                position.setX(position.getX() + 1);
            }
        } else {
            if (position.getY() > queenPosition.getY()) {
                position.setY(position.getY() - 1);
            } else {
                position.setY(position.getY() + 1);
            }
        }
    }

}
