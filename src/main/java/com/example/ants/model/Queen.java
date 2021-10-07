package com.example.ants.model;

import com.example.ants.colony.Colony;
import com.example.ants.geometry.Position;

public class Queen extends Ant {

    private int matingCounter;

    public Queen(Colony colony, Position position) {
        super(colony, position);
        matingCounter = 50 + RANDOM.nextInt(51);
    }

    @Override
    public void move() {
        if (matingCounter > 0) {
            matingCounter--;
        }
    }

    public boolean isMating() {
        if (matingCounter == 0) {
            matingCounter = 50 + RANDOM.nextInt(51);
            return true;
        }
        return false;
    }

    public int getMatingCounter() {
        return matingCounter;
    }

}
