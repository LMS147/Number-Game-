/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package numberguessinggame;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author masha
 */
public class GuessingGame { private int numberToGuess;
    private int numberOfTries;
    private boolean hasWon;
    private boolean shouldContinue;
    private int[] guesses;

    public GuessingGame() {
        Random random = new Random();
        numberToGuess = random.nextInt(100) + 1;
        numberOfTries = 0;
        hasWon = false;
        shouldContinue = true;
        guesses = new int[10]; // Assuming a maximum of 10 guesses
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess a number between 1 and 100:");

        while (shouldContinue) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            guesses[numberOfTries] = guess;
            numberOfTries++;

            if (guess < numberToGuess) {
                System.out.println("Your guess is too low.");
            } else if (guess > numberToGuess) {
                System.out.println("Your guess is too high.");
            } else {
                hasWon = true;
                shouldContinue = false;
            }

            if (numberOfTries >= guesses.length) {
                shouldContinue = false;
            }
        }

        if (hasWon) {
            System.out.println("Congratulations! You've guessed the number in " + numberOfTries + " tries.");
        } else {
            System.out.println("Game over! The number was " + numberToGuess + ".");
        }

        printGuesses();
        scanner.close();
    }

    private void printGuesses() {
        System.out.println("Your guesses were:");
        for (int i = 0; i < numberOfTries; i++) {
            System.out.print(guesses[i] + " ");
        }
        System.out.println();
    }

    // Getters for unit testing
    public int getNumberToGuess() {
        return numberToGuess;
    }

    public int getNumberOfTries() {
        return numberOfTries;
    }

    public boolean hasWon() {
        return hasWon;
    }

    public boolean shouldContinue() {
        return shouldContinue;
    }

    public int[] getGuesses() {
        return guesses;
    }

    // Methods for unit testing
    public void setNumberToGuess(int numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    public void guess(int guess) {
        guesses[numberOfTries] = guess;
        numberOfTries++;

        if (guess < numberToGuess) {
            System.out.println("Your guess is too low.");
        } else if (guess > numberToGuess) {
            System.out.println("Your guess is too high.");
        } else {
            hasWon = true;
            shouldContinue = false;
        }

        if (numberOfTries >= guesses.length) {
            shouldContinue = false;
        }
    }

    public String getFeedback() {
        if (hasWon) {
            return "Congratulations! You've guessed the number.";
        } else if (!shouldContinue) {
            return "Game over! The number was " + numberToGuess + ".";
        } else {
            return "";
        }
    }
    
}
