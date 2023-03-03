package testingCode.guessingGame;

import java.util.Random;

public class GuessingGame {
    private final int randomNumber = new Random().nextInt(10) + 1;
    private int counter = 0;
    public String guess(int guessedNumber) {
        counter++;
        String tryText = counter == 1 ? "try" : "tries";
        String winningMsg = String.format("You got it in %d %s", counter, tryText);

        if (counter == 4 && guessedNumber != getRandomNumber()) {
            return String.format("You didn't get it and you've had %d %s. Game Over.", counter, tryText);
        } else if (counter > 4) {
            return "Sorry, you are limited to only 4 tries. Your game is over.";
        }
        return guessedNumber == getRandomNumber() ? winningMsg : "You didn't get it";
    }

    public int getRandomNumber() {
        return randomNumber;
    }
}
