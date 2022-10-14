package src;

public class Bomb extends Tile {


    public Bomb(int xCoord, int yCoord) {
        super.xCoord = xCoord;
        super.yCoord = yCoord;
        super.type = "bomb";
        super.correctFlag = false;


    }

    @Override
    public boolean getCorrectFlag() {
        return correctFlag;
    }


}
