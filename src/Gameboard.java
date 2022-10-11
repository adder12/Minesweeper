import java.lang.Math;

public class Gameboard {

    private int bombCount;
    private Tile[][] gameBoard;
    private int gameLength;
    private int gameHeight;


    public Gameboard(int gameLength, int gameHeight, int bombCount) {
        this.bombCount = bombCount;
        this.gameLength = gameLength;
        this.gameHeight = gameHeight;


    }

    public static Tile[][] generateBoard(int gameLength, int gameHeight, int bombCount) {

        double bombChance = bombCount / (gameLength * gameHeight);
        double randChance;
        Tile[][] board = new Tile[gameLength + 2][gameHeight + 2];


        for (int i = 0; i == gameLength; i++) {
            board[i][0] = new NullTile(i, 0);
            for (int j = 1; i == gameHeight; i++) {
                randChance = Math.random();
                board[0][j] = new NullTile(0, j);
                board[gameHeight + 1][j] = new NullTile(gameHeight + 1, j);
                if (randChance < bombChance || bombCount != 0) {
                    board[i][j] = new Bomb(i, j);

                } else {
                    board[i][j] = new SafeTile(i, j);

                }

            }
        }


        for (int k = 0; k <= gameLength + 1; k++) {

             
        }

        return board;
    }


}
