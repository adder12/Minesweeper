package src;

public class Gameboard {

    private int bombCount;
    private Tile[][] gameBoard;
    private int gameLength;
    private int gameHeight;

    private int flagCount;

    public void changeFlagCount(int change) {
        this.flagCount += change;
    }

    public int getFlagCount() {
        return flagCount;
    }

    public int getBombCount() {

        return bombCount;

    }

    public int getGameLength() {

        return gameLength;
    }

    public int getGameHeight() {
        return gameHeight;
    }

    public Tile[][] getGameBoard() {
        return gameBoard;


    }

    public void setTileState(int xCoord, int yCoord, int state) {
        this.gameBoard[xCoord][yCoord].state = state;


    }

    public void changeBombCount(int change) {
        this.bombCount += change;
    }

    public Gameboard(int gameLength, int gameHeight, int bombCount) {
        this.bombCount = bombCount;
        this.gameLength = gameLength;
        this.gameHeight = gameHeight;
        this.gameBoard = generateBoard(gameLength, gameHeight, bombCount);
        this.flagCount = bombCount;
        this.displayBoardFull();

    }

    public Gameboard(Difficulty difficulty) {
        this.bombCount = difficulty.getBombs();
        this.gameLength = difficulty.getGameLength();
        this.gameHeight = difficulty.getGameHeight();
        this.gameBoard = generateBoard(gameLength, gameHeight, bombCount);
        checkNeighbor();
        this.flagCount = difficulty.getBombs();
        //  displayBoardFull(this.gameBoard);


    }

    public static Tile[][] generateBoard(int gameLength, int gameHeight, int bombCount) {
        int count = bombCount;
        //System.out.println(gameLength + "" + gameHeight);
        double temp = gameLength * gameHeight;
        double bombChance = count / temp;

        // System.out.println(bombChance);
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
                    if (randChance < bombChance && count != 0 && !board[i][j].type.equals("Bomb")) {
                        board[i][j] = new Bomb(i, j);
                        count--;
                        //   System.out.println("bomb placed");
                    } else if (!board[i][j].type.equals("bomb")) {
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

    public void displayBoardFull() {
        StringBuilder output = new StringBuilder();


        for (int i = 0; i < gameBoard.length; i++) {
            output.append("\n");
            for (int j = 0; j < gameBoard[i].length; j++) {
                if (gameBoard[i][j].type.equals("bomb")) {
                    output.append(ANSI.colourRed);
                } else if (gameBoard[i][j].type.equals("Safe")) {
                    output.append(ANSI.colourCyan);
                }
                output.append(gameBoard[i][j].type);
                output.append(ANSI.colourReset);
                output.append(", ");
            }
        }

        System.out.println(output);
    }

    public void displayBoardCurrent() {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < gameHeight; i++) {
            output.append("  ");

            if (i + 1 > 9) {
                output.append(i + 1);


            } else {
                output.append("0");
                output.append((i + 1));

            }
            output.append(" ");
        }

        output.append("\n    ");
        output.append("_____".repeat(Math.max(0, gameHeight)));

        for (int i = 1; i < gameLength + 1; i++) {
            output.append("\n");
            output.append(" ");

            if (i > 9) {
                output.append(i);


            } else {
                output.append("0");
                output.append((i));
            }
            output.append(" |");
            for (int j = 1; j < gameHeight + 1; j++) {
                if (gameBoard[i][j].type.equals("bomb")) {
                    output.append(ANSI.colourRed);
                } else if (gameBoard[i][j].type.equals("Safe")) {
                    output.append(ANSI.colourCyan);
                }
                output.append(gameBoard[i][j].type);
                output.append(ANSI.colourReset);
                output.append(" ");

            }


        }
        System.out.println(output);

    }

    public void displayCurrentHidden() {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < gameHeight; i++) {
            output.append("  ");

            if (i + 1 > 9) {
                output.append(i + 1);


            } else {
                output.append("0");
                output.append((i + 1));

            }
            output.append(" ");
        }

        output.append("\n    ");
        output.append("_____".repeat(Math.max(0, gameHeight)));
        for (int i = 1; i < gameLength + 1; i++) {
            output.append("\n");
            output.append(" ");


            if (i > 9) {
                output.append(i);


            } else {
                output.append("0");
                output.append((i));
            }
            output.append(" |");

            for (int j = 1; j < gameHeight + 1; j++) {
                if (gameBoard[i][j].type.equals("safe") && gameBoard[i][j].getState() == 2) {
                    output.append(ANSI.colourCyan);
                    //} else if (gameBoard[i][j].type == "Safe") {
                    //     output += ANSI.colourCyan;
                }
                switch (gameBoard[i][j].state) {

                    case 0:
                        output.append("????");
                        break;
                    case 1:
                        output.append(ANSI.colourYellow);
                        output.append("FLAG");
                        output.append( ANSI.colourReset);
                        break;
                    case 2:
                        output.append(ANSI.colourCyan);
                        output.append( " ");
                        output.append(gameBoard[i][j].getNearbyBombs());
                        output.append("  ");
                        output.append(ANSI.colourReset);
                        break;

                }
                output.append(" ");

                //output += gameBoard[i][j].type + ANSI.colourReset + ", ";

            }


        }
        System.out.println(output);


    }

    public void checkNeighbor() {

        for (int i = 1; i <= gameLength; i++) {
            for (int j = 1; j <= gameHeight; j++) {
                int n = 0;
                for (int k = -1; k <= 1; k++) {

                    for (int l = -1; l <= 1; l++) {
                        if (k != 0 || l != 0) {

                            gameBoard[i][j].neighbours[n] = gameBoard[i + k][j + l].getType();
                            n++;
                        }
                    }
                }


                gameBoard[i][j].neighborCount();
            }
        }
        //gameBoard[4][4].displayNeighbors();

    }

    public void switchCorrectState(int xCoord, int yCoord) {

        gameBoard[xCoord][yCoord].setCorrectFlag();

    }

    public void reveal(int xCoord, int yCoord) {

        // gameBoard[xCoord][yCoord].displayNeighbors();
        if (!gameBoard[xCoord][yCoord].getNeighbourMethodCheck() && gameBoard[xCoord][yCoord].getType().equals("Safe") && gameBoard[xCoord][yCoord].getState() == 0 && !gameBoard[xCoord][yCoord].getType().equals("bomb")) {
            if (gameBoard[xCoord][yCoord].getType().equals("bomb")) {
                System.out.println("function performed on bomb");
            }
            setTileState(xCoord, yCoord, 2);
            gameBoard[xCoord][yCoord].setNeighbourMethodCheck();
            for (int k = -1; k <= 1; k++) {
                for (int l = -1; l <= 1; l++) {
                    if (k != 0 || l != 0) {
                        gameBoard[xCoord + k][yCoord + l].setState(2);
                        if (gameBoard[xCoord + k][yCoord + l].getNearbyBombs() == 0 && gameBoard[xCoord + k][yCoord + l].getType().equals("Safe")) {

                            reveal(xCoord + k, yCoord + l);

                        }
                    }
                }
            }
        }
    }
}