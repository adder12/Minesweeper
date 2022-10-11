
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);

        System.out.println(ANSI.colourCyan + "Hello and welcome to " + ANSI.colourRed + "!!MINESWEEPER!!" + ANSI.colourReset);
        System.out.println("\nWould you like to play a game?");

        Difficulty difficulty = Difficulty.diffChooser(scan);

        Gameboard game = new Gameboard(difficulty);

        int gameStatus = 0;
        System.out.println("Hello " + ANSI.colourCyan + "Minesweeper" + ANSI.colourReset);

        System.out.println("\n Your mission today is to locate all " + game.getBombCount() + " bombs");

        int xCoord = 0;
        int yCoord = 0;
        do {
            Tile[][] gameState = game.getGameBoard();

            game.displaycurrentHidden();
            System.out.println("There are " + game.getBombCount() + " bombs remaining");
            System.out.println("Please enter the x Coordinate you wish to check");
            xCoord = getCoord(scan, game.getGameLength());
            System.out.println("Please enter the y Coordinate you wish to check");
            yCoord = getCoord(scan, game.getGameHeight());
//TODO add map clearing functionality
            //TODO add bomb sensing functionality

            if (gameState[xCoord][yCoord].getType() == "bomb") {
                gameStatus = 1;


            } else {


            }

        } while (gameStatus == 0);

        if (gameStatus == 1) {

            System.out.println("Uh oh!!! You hit a bomb, unlucky");

        }
    }

    public static int getCoord(Scanner scan, int max) {
        int coord = scan.nextInt() - 1;
        while (coord < 0 || coord > max - 1) {

            System.out.println("That location is invalid, please enter a valid coordinate");
            coord = scan.nextInt();

        }


        return coord;
    }

}