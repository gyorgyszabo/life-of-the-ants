package com.example.ants.colony;

import com.example.ants.model.*;
import com.example.ants.geometry.Position;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringJoiner;

public class Colony {

    private static final String ANSI_WHITE = "\033[0;38;5;250m";
    private static final String ANSI_YELLOW = "\033[1;38;5;214m";
    private static final String ANSI_PURPLE = "\033[1;38;5;171m";
    private static final String ANSI_GREEN = "\033[1;38;5;40m";
    private static final String ANSI_RED = "\033[1;38;5;196m";
    private static final String ANSI_BLUE = "\033[1;38;5;33m";

    private final int width;
    private final Queen queen;
    private final List<Ant> ants = new ArrayList<>();
    private static final Random RANDOM = new Random();

    public Colony(int width) {
        this.width = width;
        queen = new Queen(this, new Position(width / 2, width / 2));
    }

    public void generateAnts(int numberOfWorkers, int numberOfSoldiers, int numberOfDrones) {
        for (int i = 0; i < numberOfWorkers; i++) {
            ants.add(new Worker(this, new Position(randomStartingPosition(), randomStartingPosition())));
        }
        for (int i = 0; i < numberOfSoldiers; i++) {
            ants.add(new Soldier(this, new Position(randomStartingPosition(), randomStartingPosition())));
        }
        for (int i = 0; i < numberOfDrones; i++) {
            ants.add(new Drone(this, new Position(randomStartingPosition(), randomStartingPosition())));
        }
    }

    private int randomStartingPosition() {
        return 1 + RANDOM.nextInt(width - 2);
    }

    public void update() {
        queen.move();
        ants.forEach(Ant::move);
    }

    public void display() {
        char[][] colonyMap = createMap();
        String titleLeftPadding = " ".repeat((width * 2 - 20 ) / 2);
        System.out.println(titleLeftPadding + ANSI_YELLOW + "- Life of the Ants -");
        char lastElementType = 'T';
        for (int i = 0; i < colonyMap.length; i++) {
            StringJoiner stringJoiner = new StringJoiner(" ");
            for (int j = 0; j < colonyMap.length; j++) {
                switch (colonyMap[i][j]) {
                    case '.':
                        stringJoiner.add(lastElementType == '.' ? "." : ANSI_WHITE + ".");
                        lastElementType = '.';
                        break;
                    case 'Q':
                        stringJoiner.add(lastElementType == 'Q' ? "Q" : ANSI_PURPLE + "Q");
                        lastElementType = 'Q';
                        break;
                    case 'W':
                        stringJoiner.add(lastElementType == 'W' ? "W" : ANSI_GREEN + "W");
                        lastElementType = 'W';
                        break;
                    case 'S':
                        stringJoiner.add(lastElementType == 'S' ? "S" : ANSI_RED + "S");
                        lastElementType = 'S';
                        break;
                    case 'D':
                        stringJoiner.add(lastElementType == 'D' ? "D" : ANSI_BLUE + "D");
                        lastElementType = 'D';
                        break;
                }
            }
            System.out.println(stringJoiner);
        }
        System.out.println(ANSI_WHITE + "Queen mating counter: " + queen.getMatingCounter());
    }

    private char[][] createMap() {
        char[][] arrayToReturn = new char[width][width];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                arrayToReturn[i][j] = '.';
            }
        }
        arrayToReturn[queen.getPosition().getY()][queen.getPosition().getX()] = 'Q';
        for (Ant actualAnt : ants) {
            char charToAdd = ' ';
            String caste = actualAnt.getClass().getSimpleName();
            switch (caste) {
                case "Worker":
                    charToAdd = 'W';
                    break;
                case "Soldier":
                    charToAdd = 'S';
                    break;
                case "Drone":
                    charToAdd = 'D';
                    break;
            }
            arrayToReturn[actualAnt.getPosition().getY()][actualAnt.getPosition().getX()] = charToAdd;
        }
        return arrayToReturn;
    }

    public int getWidth() {
        return width;
    }

    public Queen getQueen() {
        return queen;
    }

}
