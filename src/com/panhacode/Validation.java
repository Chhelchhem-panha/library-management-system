package com.panhacode;

import java.util.Scanner;

public class Validation {
    public int getValidate(String message, String regex, int minValue, int maxValue, Scanner scanner) {
        int userInput;
        while (true) {
            System.out.print(message);
            String input = scanner.next();

            if (input.matches(regex)) {
                userInput = Integer.parseInt(input);
                if (userInput >= minValue && userInput <= maxValue) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a valid integer within the specified range " +
                            "(" + minValue + " - " + maxValue + ").");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        return userInput;
    }
}
