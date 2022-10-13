package src;

public class SafeTile extends Tile {

    public SafeTile(int xCoord, int yCoord) {
        super.xCoord = xCoord;
        super.yCoord = yCoord;

        super.type = "Safe";
    }
}
