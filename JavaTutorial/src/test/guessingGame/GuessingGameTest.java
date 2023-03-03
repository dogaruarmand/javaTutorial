package guessingGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import testingCode.guessingGame.GuessingGame;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuessingGameTest {

    public static final int GAME_RANDOMMISE_NUMBERS = 100;
    private final int[] rndNumCount = new int[11];
    private GuessingGame game;

    @BeforeEach
    void setUp() {
        game = new GuessingGame();
    }

    @Test
    public void testSimpleWinSituation() {
        int randomNum = game.getRandomNumber();
        String message = game.guess(randomNum);
        assertEquals("You got it in 1 try", message);
    }

    @Test
    public void testOneWrongNegGuessSituation() {
        String message = game.guess(-5);
        assertEquals("You didn't get it", message);
    }

    @Test
    public void testOneWrongPosGuessSituation() {
        int randomNum = game.getRandomNumber();
        String message = game.guess(randomNum + 1);
        assertEquals("You didn't get it", message);
    }

//    @Test
    @Test
    public void testRandomGeneration() {
        // 1 2 3 4 5 6 7 8 9 10
        // 1 1 1 1 0 1 0 1 1  1 appereance time = 10
        for (int counter = 0; counter < GAME_RANDOMMISE_NUMBERS; counter++) {
            GuessingGame game = new GuessingGame();
            int randomNum = game.getRandomNumber();
            rndNumCount[randomNum] = 1;
        }
        int sum = 0;
        for (int counter = 0; counter < 11; counter++) {
            sum+= rndNumCount[counter];
        }
        assertEquals(10, sum);
    }

    @Test
    public void testFourWrongGuesses() {
        makeThreeWrongGuesses();
        String message = game.guess(-3);
        assertEquals("You didn't get it and you've had 4 tries. Game Over.", message);
    }

    @Test
    public void testTenWrongGuesses() {
        makeThreeWrongGuesses();
        makeThreeWrongGuesses();
        makeThreeWrongGuesses();
        game.guess(-3);
        String message = game.guess(-3);
        assertEquals("Sorry, you are limited to only 4 tries. Your game is over.", message);
    }

    @Test
    public void testThreeWrongGuessesAndOneCorrect() {
        makeThreeWrongGuesses();
        int correctAnswer = game.getRandomNumber();
        String message = game.guess(correctAnswer);
        assertEquals("You got it in 4 tries", message);
    }

    private void makeThreeWrongGuesses() {
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
    }

    @Test
    public void testTwoWrongGuessesAndOneCorrect() {
        game.guess(-3);
        game.guess(-3);
        int correctAnswer = game.getRandomNumber();
        String message = game.guess(correctAnswer);
        assertEquals("You got it in 3 tries", message);
    }
}
