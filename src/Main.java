import java.util.Scanner;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        Difficulty easy = new Difficulty(10, 8, 10);
        Difficulty medium = new Difficulty(18, 14, 40);
        Difficulty hard = new Difficulty(24, 20, 99);
        char chosenDifficulty;
        boolean diffCorrect = false;
        Scanner scan = new Scanner(System.in);
        int gameLength = 0;
        int gameHeight = 0;
        int bombs = 0;
        System.out.println(ANSI.colourCyan + "Hello and welcome to " + ANSI.colourRed + "!!MINESWEEPER!!" + ANSI.colourReset);

        System.out.println("\nWould you like to play a game?");


        System.out.println("\n\n\n" + "What Difficulty would you like to play, Easy(E), Medium(M), Hard(H) or Custom(C)");
        do {
            chosenDifficulty = Character.toLowerCase(scan.next().charAt(0));
            switch (chosenDifficulty) {
                case 'e':
                    gameLength = easy.getGameLength();
                    gameHeight = easy.getGameHeight();
                    bombs = easy.getBombs();
                    diffCorrect = true;
                    break;

                case 'm':
                    gameLength = medium.getGameLength();
                    gameHeight = medium.getGameHeight();
                    bombs = medium.getBombs();
                    diffCorrect = true;
                    break;
                case 'h':
                    gameLength = hard.getGameLength();
                    gameHeight = hard.getGameHeight();
                    bombs = hard.getBombs();
                    diffCorrect = true;
                    break;
                case 'c':
                    System.out.println("You have selected custom difficulty");
                    System.out.println("Please enter the length of game board you wish to play on");
                    gameLength = scan.nextInt();
                    System.out.println("Please enter the height of game board you wish to play on");
                    gameHeight = scan.nextInt();
                    System.out.println("You are playing on a " + gameLength + "x" + gameHeight + " board.\n\n How many " + ANSI.colourRed + "BOMBS" + ANSI.colourReset + " would you like to place?");
                    bombs = scan.nextInt();
                    diffCorrect = true;

            }
            if (!diffCorrect) {
                System.out.println("Im sorry, your entry was not a supported difficulty, please choose one of the following difficulties \n\n Easy(E), Medium(M), Hard(H), Custom(C)");


            }
        } while (!diffCorrect);
        Gameboard test = new Gameboard(gameLength, gameHeight, bombs);


    }
}