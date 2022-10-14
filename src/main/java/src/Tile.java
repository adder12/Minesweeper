package src;

public class Tile {

    protected int xCoord;
    protected int yCoord;
    protected int state; // 0 - hidden, 1 - revealed, 2 - flagged
    protected String type;
    protected boolean correctFlag;
    protected boolean neighbourMethodCheck;
    protected String[] neighbours = new String[8];
    protected int nearbyBombs;

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

    public int getyCoord() {
        return this.yCoord;
    }

    public int getNearbyBombs() {

        return nearbyBombs;
    }

    public boolean getCorrectFlag() {
        return this.correctFlag;

    }

    public Tile(int xCoord, int yCoord/*, Tile type*/) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;

    }

    public Tile() {
        state = 0;
        neighbourMethodCheck = false;

    }

    public void setNeighbourMethodCheck() {
        neighbourMethodCheck = !neighbourMethodCheck;
    }

    public boolean getNeighbourMethodCheck() {
        return neighbourMethodCheck;
    }

    public int getState() {


        return state;
    }

    public void setState(int state) {
        this.state = state;

    }

    public void neighborCount() {
        for (String neighborType : neighbours) {

            if (neighborType.equals("bomb")) {
                this.nearbyBombs++;
            }
        }
    }

    public void displayNeighbors() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < neighbours.length; i++) {

            output.append(neighbours[i]);
            output.append(" ");


        }
        System.out.println(this.xCoord + " " + this.yCoord + output);
    }


    public void setCorrectFlag() {
        this.correctFlag = !this.correctFlag;
    }
}
