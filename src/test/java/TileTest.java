import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import src.NullTile;
import src.SafeTile;

import src.Tile;


public class TileTest {
    Tile testTile = new SafeTile(5, 5);


    @Test
    public void testIndividualCoords() {

        Assertions.assertEquals(5, testTile.getxCoord(), "The x Coordinate has been set incorrectly");

        Assertions.assertEquals(5, testTile.getyCoord(), "The y Coordinate has been set incorrectly");


    }

    @Test
    public void testCoordsMethod() {

        int[] test = testTile.getCoords();
        int x = test[0];
        int y = test[1];

        Assertions.assertEquals(5, x, "The x coordinate has been retrieved incorrectly");
        Assertions.assertEquals(5, y, "The Y coordinate has been retrieved incorrectly");


    }


    @Test
    public void testType() {
        Assertions.assertEquals("Safe", testTile.getType(), "The tile type has been set incorrectly");
        testTile = new NullTile(5, 5);

        Assertions.assertEquals("NULL", testTile.getType(), "The tile has not been successfully updated");

    }


    @Test
    public void testCorrectFlag() {

        Assertions.assertFalse(testTile.getCorrectFlag(), "The tiles correct flag is incorrect");
        testTile.setCorrectFlag();
        Assertions.assertTrue(testTile.getCorrectFlag(), "The flag is now set to true");

    }

    @Test
    public void testState() {

        Assertions.assertEquals(0, testTile.getState(), "The state is incorrect");
        testTile.setState(2);
        Assertions.assertEquals(2, testTile.getState(), "The state is incorrect");


    }

    @Test
    public void testNearbyBombs() {

        Assertions.assertEquals(0, testTile.getNearbyBombs(), "The Nearby Bomb count is incorrect");


    }


}
