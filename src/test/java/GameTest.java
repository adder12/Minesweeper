import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import src.GameClass;
import src.Tile;

public class GameTest {
    GameClass testGame = new GameClass(10, 10, 10);


    @Test
    public void testBombCount() {
        Assertions.assertEquals(10, testGame.getBombCount(), "The bomb count was incorrect");
    }

    @Test
    public void testFlagCount() {
        Assertions.assertEquals(10, testGame.getFlagCount(), "The flag count was incorrect");
    }

    @Test
    public void testGameHeightGetter() {
        Assertions.assertEquals(10, testGame.getGameHeight(), "Game height getter failed");
    }

    @Test
    public void testGameLengthGetter() {
        Assertions.assertEquals(10, testGame.getGameLength(), "Game length getter failed");
    }

   /* @Test
    public void testChangeFlagCount() {
        testGame.changeFlagCount(-1);
        Assertions.assertEquals(9, testGame.getFlagCount(), "The change flagCount method has failed");
    }*/

    @Test
    public void changeBombCount() {
        testGame.changeBombCount(-1);
        Assertions.assertEquals(9, testGame.getBombCount(), "The change Bomb method has failed");
    }

    @Test
    public void testEmptyBoard() {
        Tile[][] testBoard = new Tile[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

            }

        }


    }
}

