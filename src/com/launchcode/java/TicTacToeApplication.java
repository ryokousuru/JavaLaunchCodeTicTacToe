package com.launchcode.java;

import java.util.Scanner;

public class TicTacToeApplication {

    public static void main(String[] args) {
        // getting the input
        Scanner ss = new Scanner(System.in);
        //create boolean to allow for continuous games
        boolean wannaPlay = true;
        while (wannaPlay) {
            //setting up tokens and the artificial intelligence
            System.out.println("Welcome to the tictactoes game!");
            System.out.println("You're about to compete against");
            System.out.println("the artificially intelligent");
            System.out.println("master of tic tac toe");
            System.out.println("Ready?\n");
            System.out.println("Pick which character you'd like to be");
            System.out.println("The master will be the other character.");
            System.out.println();
            System.out.println("Enter a single character to represent " +
                    "your token on the board: ");
            char playerToken = ss.next().charAt(0);
            System.out.println("Enter a different single character to " +
                    "represent your opponent's token on the board.");
            char opponentToken = ss.next().charAt(0);
            TicTacToe joue = new TicTacToe(playerToken, opponentToken);
            AI artificial = new AI();
            //setting up the games
            System.out.println();
            System.out.println("Now to start the game.");
            System.out.println("To play, enter and number and your token " +
                    "will be put in it's correct place.\n  The numbers go from " +
                    "1 through 9 and from left to right");
            System.out.println("Let's see who shall emerge victorious!");
            TicTacToe.printIndexBoard();
            System.out.println();

            //Let's play the game!!
            while (joue.gameOver().equals("Game still in progress.")){
                if (joue.currentMarker == joue.userMarker){
                    //user's turn
                    System.out.println("It's your turn already!");
                    System.out.println("So enter a spot for your token.");
                    int spot = ss.nextInt();
                    while (joue.playTurn(spot)){
                        System.out.println("Please try it again."+ spot + " " +
                                "this spot's already taken or it's out of range.");
                        spot = ss.nextInt();
                    }
                    System.out.println("You picked " + spot + "!");
                } else {
                    //AI's turn
                    System.out.println("It's my turn now.");
                    //Ai picks a spot
                    int aiSpot = artificial.chooseSquare(joue);
                    joue.playTurn(aiSpot);
                    System.out.println("I picked " + aiSpot + "!");
                }
                //print out a new board
                System.out.println();
                joue.printBoard();
            }
            System.out.println(joue.gameOver());
            System.out.println();
            //prepare for a new game, if user would like
            System.out.println("Would you like to try playing again?");
            System.out.println("Select 'Y' for yes, anything else for no.");
            char response = ss.next().charAt(0);
            wannaPlay = (response == 'Y');
            System.out.println();
            System.out.println();
        }
    }
}
