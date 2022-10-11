public class Tile {

    protected int xCoord;
    protected int yCoord;
    protected int state; // 0 - hidden, 1 - revealed, 2 - flagged
    protected String type;

    //  private Tile type;


    public int[] getCoords() {
        int[] coordArray = new int[2];
        coordArray[0] = this.xCoord;
        coordArray[1] = this.yCoord;
        return coordArray;

    }

    public String getType() {

        return type;

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
        state = 0;
    }

    public int getState() {


        return state;
    }
}
