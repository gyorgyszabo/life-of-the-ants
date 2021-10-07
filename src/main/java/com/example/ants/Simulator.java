package com.example.ants;

import com.example.ants.colony.Colony;
import java.util.Scanner;

public class Simulator {

    private static final int MIN_COLONY_WIDTH = 12;
    private static final int MAX_COLONY_WIDTH = 25;
    private static final int MIN_NUMBER_OF_ANT_PER_CASTE = 1;
    private static final int MAX_NUMBER_OF_ANT_PER_CASTE = 20;
    private static final String ANSI_WHITE = "\033[0;38;5;250m";
    private static final String ANSI_YELLOW = "\033[1;38;5;214m";
    private static final String ANSI_GREEN = "\033[1;38;5;40m";
    private static final String ANSI_RED = "\033[1;38;5;196m";
    private static final String ANSI_BLUE = "\033[1;38;5;33m";

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(ANSI_YELLOW + "- Life of the Ants -");
        int colonyWidth = getUserInput(ANSI_WHITE + "Colony width: ", MIN_COLONY_WIDTH, MAX_COLONY_WIDTH);
        int numberOfWorkers = getUserInput("Number of " + ANSI_GREEN + "Workers" + ANSI_WHITE + ": ",
                MIN_NUMBER_OF_ANT_PER_CASTE, MAX_NUMBER_OF_ANT_PER_CASTE);
        int numberOfSoldiers = getUserInput("Number of " + ANSI_RED + "Soldiers" + ANSI_WHITE + ": ",
                MIN_NUMBER_OF_ANT_PER_CASTE, MAX_NUMBER_OF_ANT_PER_CASTE);
        int numberOfDrones = getUserInput("Number of " + ANSI_BLUE + "Drones" + ANSI_WHITE + ": ",
                MIN_NUMBER_OF_ANT_PER_CASTE, MAX_NUMBER_OF_ANT_PER_CASTE);
        System.out.println();
        Colony colony = new Colony(colonyWidth);
        colony.generateAnts(numberOfWorkers, numberOfSoldiers, numberOfDrones);
        colony.display();
        while (true) {
            if (SCANNER.nextLine().equalsIgnoreCase("q")) {
                System.exit(0);
            }
            colony.update();
            colony.display();
        }
    }

    private static int getUserInput(String textToPrint, int minValue, int maxValue) {
        while (true) {
            System.out.print("\n" + textToPrint);
            String userInput = SCANNER.nextLine();
            if (userInput.equalsIgnoreCase("q")) {
                System.exit(0);
            }
            try {
                int userInputInt = Integer.parseInt(userInput);
                if (userInputInt >= minValue && userInputInt <= maxValue) {
                    return userInputInt;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please provide a number!");
                continue;
            }
            System.out.println("The number must be between " + minValue + " and " + maxValue + "!");
        }
    }

}
