/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package numberguessinggame;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author masha
 */
public class GuessingGameTest {
    
    private GuessingGame game;

    @Before
    public void setup() {
        game = new GuessingGame();
    }

    @Test
    public void testInitialConditions() {
        assertFalse(game.hasWon());
        assertTrue(game.shouldContinue());
        assertEquals(0, game.getNumberOfTries());
    }

    @Test
    public void testGuessTooLow() {
        game.setNumberToGuess(50);
        game.guess(10);
        assertEquals("Your guess is too low.", game.getFeedback());
    }

    @Test
    public void testGuessTooHigh() {
        game.setNumberToGuess(75);
        game.guess(99);
        assertEquals("Your guess is too high.", game.getFeedback());
    }

    @Test
    public void testGuessCorrect() {
        game.setNumberToGuess(50);
        game.guess(50);
        assertTrue(game.hasWon());
        assertEquals("Congratulations! You've guessed the number.", game.getFeedback());
    }

    @Test
    public void testGameOver() {
        for (int i = 0; i < 10; i++) {
            game.guess(i);
        }
        assertFalse(game.shouldContinue());
    }
    
}
