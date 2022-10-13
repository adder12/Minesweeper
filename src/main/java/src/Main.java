package src;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean playAgain = false;
        char temp;
        boolean playerAnswerCorrect = false;
        System.out.println(ANSI.colourCyan + "Hello and welcome to " + ANSI.colourRed + "!!MINESWEEPER!!" + ANSI.colourReset);
        System.out.println("\nWould you like to play a game? Y/N");
        temp = scan.next().charAt(0);
        do {
            if (Character.toLowerCase(temp) == 'y') {
                playerAnswerCorrect = true;
                playAgain = true;
            } else if (Character.toLowerCase(temp) == 'n'){
                playerAnswerCorrect = true;
                playAgain = false;
            }
        } while (!playerAnswerCorrect);


        while (playAgain) {
        Difficulty difficulty = Difficulty.diffChooser(scan);

        GameClass game = new GameClass(difficulty);

        int gameStatus; //0 = playing, 1 = failed, 2 = win
        System.out.println("Hello " + ANSI.colourCyan + "Minesweeper" + ANSI.colourReset);

        System.out.println("\n Your mission today is to locate all " + game.getBombCount() + " bombs");
        System.out.println("There are " + game.getBombCount() + " bombs remaining");


        do {
            game.displayCurrentHidden();
            gameStatus = gamePlayLoop(game, scan);
        } while (gameStatus == 0);

        if (gameStatus == 1) {
            System.out.println("Uh oh!!! You hit a bomb, unlucky");
            game.displayBoardCurrent();
        } else {
            game.displayBoardCurrent();
            System.out.println("Congratulations Commander, you cleared the field");

        }
            System.out.println("Would you like to play again");
            temp = scan.next().charAt(0);
            playerAnswerCorrect = false;
            do {
                if (Character.toLowerCase(temp) == 'y') {
                    playerAnswerCorrect = true;
                    playAgain = true;
                } else if (Character.toLowerCase(temp) == 'n'){
                    playerAnswerCorrect = true;
                    playAgain = false;
                } else{
                    System.out.println("Im sorry that answer was unrecognised, please enter Y/N");
                }
            } while (!playerAnswerCorrect);
        }
        System.out.println("Thanks for playing!!");
    }

    public static int getCoord(Scanner scan, int max) {
        int coord = scan.nextInt() - 1;
        while (coord < 0 || coord > max - 1) {
            System.out.println("That location is invalid, please enter a valid coordinate");
            coord = scan.nextInt() - 1;
        }
        return coord;
    }
    public static int gamePlayLoop(GameClass game, Scanner scan) {
        Tile[][] gameState = game.getGameBoard();
        int xCoord;
        int yCoord;
        char move;
        System.out.println("Please enter the row Coordinate you wish to check?");
        xCoord = getCoord(scan, game.getGameLength()) + 1;
        System.out.println("Please enter the column Coordinate you wish to check?");
        yCoord = getCoord(scan, game.getGameHeight()) + 1;
        System.out.println("you have selected " + xCoord + "," + yCoord + ". Would you like to reveal(r) or flag/unflag(f) this tile");
        move = scan.next().charAt(0);
        boolean moveCorrect = false;
        do {
            switch (Character.toLowerCase(move)) {
                case 'r':
                    moveCorrect = true;
                    if (gameState[xCoord][yCoord].getType().equals("bomb") ){
                        return 1;
                    } else {
                        game.reveal(xCoord, yCoord);
                        break;
                    }
                case 'f':
                    moveCorrect = true;
                    if (gameState[xCoord][yCoord].getState() == 0) {
                        game.setTileState(xCoord, yCoord, 1);
                        game.changeFlagCount(-1);
                        if (gameState[xCoord][yCoord].getType().equals("bomb")) {
                            game.switchCorrectState(xCoord, yCoord);
                            game.changeBombCount(-1);
                        }
                    } else if (gameState[xCoord][yCoord].getState() == 1) {
                        game.setTileState(xCoord, yCoord, 0);
                        game.changeFlagCount(1);
                        if (gameState[xCoord][yCoord].getType().equals( "bomb")) {
                            game.switchCorrectState(xCoord, yCoord);
                            game.changeBombCount(+1);
                        }
                    }
                        break;
                default:
                    System.out.println("That move is not recognised, please enter Reveal(r) or Flag(f)");
                    move = scan.next().charAt(0);
            }
        } while (!moveCorrect);
        if (game.getBombCount() == 0 && game.getFlagCount() == 0) {
            return 2;
        } else {



            return 0;
        }

    }


}

