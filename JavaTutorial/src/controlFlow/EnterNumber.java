package controlFlow;

import java.util.Random;
import java.util.Scanner;

public class EnterNumber {

    public static final int MAX_ALLOWED_TRIES = 4;

    public static void main(String[] args) {
        int randomNum = new Random().nextInt(10) + 1;
        System.out.printf("Random number is %d.%n", randomNum);
        String guessedNumText = null;
        int wrongGuessCount = 1;
        while (!"q".equals(guessedNumText) && wrongGuessCount <= MAX_ALLOWED_TRIES) {
            guessedNumText = System.console().readLine("Please guess a number between 1 and 10 inclusively: ");
            if (guessedNumText.matches("-?\\d{1,2}")) {
                int guessedNum = Integer.parseInt(guessedNumText);
                if (guessedNum == randomNum) {
                    String tryText = wrongGuessCount == 1 ? "try" : "tries";
                    System.out.printf("The random number was %d. You got it in %d %s!%n", randomNum, wrongGuessCount, tryText);
                    return;
                } else {
                    System.out.printf("You didn't get it!%n");
                    wrongGuessCount++;
                }
            }
        }
        if (wrongGuessCount >= MAX_ALLOWED_TRIES) {
            System.out.printf("You've had %d incorrect guesses. The random number is %d. Ending program now!", wrongGuessCount-1, randomNum);
        }
    }
}
