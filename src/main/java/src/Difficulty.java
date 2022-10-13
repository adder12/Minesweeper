package src;

import java.util.Scanner;

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

    public static Difficulty diffChooser(Scanner scan) {
        Difficulty easy = new Difficulty(10, 8, 10);
        Difficulty medium = new Difficulty(18, 14, 40);
        Difficulty hard = new Difficulty(24, 20, 99);

        char enteredDiff;
        Difficulty chosenDiff = null;

        boolean diffCorrect = false;
        System.out.println("\n\n\nWhat Difficulty would you like to play, Easy(E), Medium(M), Hard(H) or Custom(C)");
        do {
            enteredDiff = Character.toLowerCase(scan.next().charAt(0));
            switch (enteredDiff) {
                case 'e':

                    diffCorrect = true;
                    chosenDiff = easy;
                    break;

                case 'm':

                    diffCorrect = true;
                    chosenDiff = medium;
                    break;

                case 'h':

                    chosenDiff = hard;
                    diffCorrect = true;
                    break;
                case 'c':
                    int gameLength;
                    int gameHeight;
                    int bombs;
                    boolean sanity = false;
                    System.out.println("You have selected custom difficulty");
                    System.out.println("Please enter the length of game board you wish to play on");
                    gameLength = scan.nextInt();

                    do{
                        if(gameLength < 5|| gameLength > 40){
                            System.out.println("That number is invalid, please enter a reasonable height for the game board");
                            gameLength=scan.nextInt();
                        } else {
                            sanity = true;
                        }
                    } while(!sanity);

                    System.out.println("Please enter the height of game board you wish to play on");
                    gameHeight = scan.nextInt();
                    sanity = false;
                    do{
                        if(gameHeight < 5 || gameHeight > 40){
                            System.out.println("That number is invalid, please enter a reasonable height for the game board");
                            gameHeight = scan.nextInt();
                        } else {
                            sanity = true;
                        }
                    } while(!sanity);

                    System.out.println("You are playing on a " + gameLength + "x" + gameHeight + " board.\n\n How many " + ANSI.colourRed + "BOMBS" + ANSI.colourReset + " would you like to place?");
                    bombs = scan.nextInt();
                    sanity = false;
                    do{

                                if(bombs < 1 || bombs > (gameLength*gameHeight)){
                                System.out.println("That number is invalid, please enter a reasonable number of bombs");
                                bombs = scan.nextInt();
                            } else {
                                    sanity= true;
                                }

                    } while(!sanity);


                    chosenDiff = new Difficulty(gameLength, gameHeight, bombs);
                    diffCorrect = true;
                    break;

                default:
                    System.out.println("Im sorry, your entry was not a supported difficulty, please choose one of the following difficulties \n\n Easy(E), Medium(M), Hard(H), Custom(C)");

            }




            }while (!diffCorrect);


        return chosenDiff;
    }
}
