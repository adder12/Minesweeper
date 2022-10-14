import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import src.Difficulty;

import java.util.Scanner;


public class DifficultyTest {
    Difficulty testDifficulty = new Difficulty(10, 10, 10);

    @Test
    public void testgameLengthGetter() {
        Assertions.assertEquals(10, testDifficulty.getGameLength(), "The gameLength was incorrect");
    }

    @Test
    public void testgameHeightGetter() {
        Assertions.assertEquals(10, testDifficulty.getGameHeight(), "The game height was incorrect");
    }

    @Test
    public void testbombGetter() {
        Assertions.assertEquals(10, testDifficulty.getBombs(), "The Number of bombs was incorrect");
    }

}
