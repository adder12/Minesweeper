package src;

public class GameClass {

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

    public GameClass(int gameLength, int gameHeight, int bombCount) {
        this.bombCount = bombCount;
        this.gameLength = gameLength;
        this.gameHeight = gameHeight;
        this.gameBoard = generateBoard(gameLength, gameHeight, bombCount);
        this.flagCount = bombCount;
        this.displayBoardFull();

    }

    public GameClass(Difficulty difficulty) {
        this.bombCount = difficulty.getBombs();
        this.gameLength = difficulty.getGameLength();
        this.gameHeight = difficulty.getGameHeight();
        this.gameBoard = generateBoard(gameLength, gameHeight, bombCount);
        checkNeighbor();
        this.flagCount = difficulty.getBombs();



    }

    public static Tile[][] generateBoard(int gameLength, int gameHeight, int bombCount) {
        int count = bombCount;

        double temp =(double) gameLength * gameHeight;
        double bombChance = count / temp;


        double randChance;

        Tile[][] board = emptyBoard(gameLength, gameHeight);


        do {


            for (int i = 1; i <= gameLength; i++) {

                for (int j = 1; j <= gameHeight; j++) {
                    randChance = Math.random();


                    if (randChance < bombChance && count != 0 && !board[i][j].type.equals("Bomb")) {
                        board[i][j] = new Bomb(i, j);
                        count--;

                    } else if (!board[i][j].type.equals("bomb")) {

                        board[i][j] = new SafeTile(i, j);
                    }
                }
            }

        } while (count != 0);

        return board;
    }

    public static Tile[][] emptyBoard(int length, int height) {
        Tile[][] board = new Tile[length + 2][height + 2];

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[i].length; j++) {

                board[i][j] = new NullTile(i, j);
            }

        }

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


        if (!gameBoard[xCoord][yCoord].getNeighbourMethodCheck() && gameBoard[xCoord][yCoord].getType().equals("Safe") && !gameBoard[xCoord][yCoord].getType().equals("bomb")) {
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
                            System.out.println("test");
                            this.reveal(xCoord + k, yCoord + l);

                        }
                    }
                }
            }
        }
    }
}