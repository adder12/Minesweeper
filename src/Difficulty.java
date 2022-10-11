public class Difficulty {
    private int gameLength;
    private int gameHeight;
    private int bombs;


    public int getGameLength() {
        return gameLength;
    }

    public void setGameLength(int gameLength) {
        this.gameLength = gameLength;
    }

    public int getGameHeight() {
        return gameHeight;
    }

    public void setGameHeight(int gameHeight) {
        this.gameHeight = gameHeight;
    }

    public int getBombs() {
        return bombs;
    }

    public void setBombs(int bombs) {
        this.bombs = bombs;
    }


    public Difficulty(int gameLength, int gameHeight, int bombs) {
        this.gameLength = gameLength;
        this.gameHeight = gameHeight;
        this.bombs = bombs;
    }
}
