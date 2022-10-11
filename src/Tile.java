public class Tile {

    protected int xCoord;
    protected int yCoord;
    protected boolean flagged;
    protected String type;

    //  private Tile type;


    public int[] getCoords() {
        int[] coordArray = new int[2];
        coordArray[0] = this.xCoord;
        coordArray[1] = this.yCoord;
        return coordArray;

    }

    public int getxCoord() {

        return this.xCoord;

    }

    public Tile(int xCoord, int yCoord/*, Tile type*/) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        //  this.type = type;
    }

    public Tile() {
        flagged = false;
    }
}
