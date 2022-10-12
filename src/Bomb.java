public class Bomb extends Tile {


    public Bomb(int xCoord, int yCoord) {
        super.xCoord = xCoord;
        super.yCoord = yCoord;
        super.type = "bomb";
        super.correctFlag = false;


    }


    public boolean getCorrectFlag() {
        return correctFlag;
    }
}
