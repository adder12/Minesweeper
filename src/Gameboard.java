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
        this.gameBoard = generateBoard(gameLength, gameHeight, bombCount);
        displayBoardFull(this.gameBoard);

    }

    public Gameboard(Difficulty difficulty) {
        this.bombCount = difficulty.getBombs();
        this.gameLength = difficulty.getGameLength();
        this.gameHeight = difficulty.getGameHeight();
        this.gameBoard = generateBoard(gameLength, gameHeight, bombCount);
        displayBoardFull(this.gameBoard);


    }

    public static Tile[][] generateBoard(int gameLength, int gameHeight, int bombCount) {
        int count = bombCount;
        //System.out.println(gameLength + "" + gameHeight);
        double temp = gameLength * gameHeight;
        double bombChance = count / temp;

        System.out.println(bombChance);
        double randChance;
        //Tile[][] board = new Tile[gameLength + 2][gameHeight + 2];
        Tile[][] board = emptyBoard(gameLength, gameHeight);

        // displayBoardFull(board);
        //  System.out.println("Empty generated");
        do {


            for (int i = 1; i <= gameLength; i++) {

                for (int j = 1; j <= gameHeight; j++) {
                    randChance = Math.random();

                    //   System.out.println(randChance);
                    // System.out.println(bombChance);
                    //board[0][j] = new NullTile(0, j);
                    // board[gameLength + 1][j] = new NullTile(gameHeight + 1, j);
                    if (randChance < bombChance && count != 0 && board[i][j].type != "Bomb") {
                        board[i][j] = new Bomb(i, j);
                        count--;
                        //   System.out.println("bomb placed");
                    } else if (board[i][j].type != "bomb") {
                        //   System.out.println(i + "  " + j);
                        board[i][j] = new SafeTile(i, j);
                    }
                }
            }
           /* for (int k = 0; k <= gameLength + 1; k++) {
                board[k][gameHeight + 1] = new NullTile(k, gameHeight + 1);
           } */
            //  displayBoardFull(board);
            //System.out.println("First pass done");
            // System.out.println(bombCount);
        } while (count != 0);
        // System.out.println("gen finished");
        return board;
    }

    public static Tile[][] emptyBoard(int length, int height) {
        Tile[][] board = new Tile[length + 2][height + 2];
        //   System.out.println(board.length);
        //   System.out.println(board[1].length);
        for (int i = 0; i < board.length; i++) {
            // System.out.println("loop 1 count " + i);
            for (int j = 0; j < board[i].length; j++) {
                //System.out.println("loop 2 count " + j);
                board[i][j] = new NullTile(i, j);
            }

        }
        //    System.out.println("loop finished");
        return board;
    }

    public static void displayBoardFull(Tile[][] board) {

        String output = "";

        for (int i = 0; i < board.length; i++) {
            output += "\n";
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].type == "bomb") {
                    output += ANSI.colourRed;
                } else if (board[i][j].type == "Safe") {
                    output += ANSI.colourCyan;
                }
                output += board[i][j].type + ANSI.colourReset + ", ";
            }
        }

        System.out.println(output);
    }


}






