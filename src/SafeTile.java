public class SafeTile extends Tile {
    boolean revealed;

    public SafeTile(int xCoord, int yCoord) {
        super.xCoord = xCoord;
        super.yCoord = yCoord;

        super.type = "Safe";
    }
}
