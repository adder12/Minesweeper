import java.util.Scanner;


public class Main {
    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);

        System.out.println(ANSI.colourCyan + "Hello and welcome to " + ANSI.colourRed + "!!MINESWEEPER!!" + ANSI.colourReset);
        System.out.println("\nWould you like to play a game?");

        Difficulty difficulty = Difficulty.diffChooser(scan);

        Gameboard game = new Gameboard(difficulty);


    }


}