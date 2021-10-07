package com.example.ants.model;

import com.example.ants.colony.Colony;
import com.example.ants.geometry.Position;
import java.util.Random;

public abstract class Ant {

    protected final Colony colony;
    protected final Position position;
    protected static final Random RANDOM = new Random();

    public Ant(Colony colony, Position position) {
        this.colony = colony;
        this.position = position;
    }

    public abstract void move();

    public Position getPosition() {
        return position;
    }

}
