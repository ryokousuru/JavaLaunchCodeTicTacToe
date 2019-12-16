package com.launchcode.java;

public class TicTacToe {

    /*
    * Picture of Game with Index
    * FOR STORAGE
    * 0 | 1 | 2
    * 3 | 4 | 5
    * 6 | 7 | 8
    * WHAT THE USER THINKS
    * 1 | 2 | 3
    * 4 | 5 | 6
    * 7 | 8 | 9
    * */

    /*
    * UI PICTURE OF GAME
    * INIT:
    * - | - | -
    * -----------
    * - | - | -
    * -----------
    * - | - | -
    * GAMEPLAY
    * 0 | - | 0
    * -----------
    * - | X | -
    * -----------
    * - | - | X
    * */

    protected char[] board;
    protected char userMarker;
    protected char aiMarker;
    protected char winner;
    protected char currentMarker;       //whose turn is it?

    public TicTacToe(char playerToken, char aiMarker){
        this.userMarker = playerToken;      //talking about this instance
        this.aiMarker = aiMarker;
        this.winner = '-';
        this.board = setBoard();  //sets up the game board
        this.currentMarker = userMarker;
    }

    public static char[] setBoard() {
        char[] board = new char[9];
        for (int i = 0; i < board.length; i++ ) {
            board[i] = '-';
        }
        return board;           //returning a blank tictactoe board
    }
    public boolean playTurn (int spot){
        boolean isValid = withinRange(spot) && isSpotTaken(spot);
        if (isValid) {
            board[spot - 1] = currentMarker;
            currentMarker = (currentMarker == userMarker) ? aiMarker : userMarker;
        }
        return isValid;
        }
        //check to see if spot is within range
    public boolean withinRange(int number){
        return number > 0 && number < board.length + 1;     //9:51 mins
    }
    //check to see if spot is already taken
    public boolean isSpotTaken(int number){
        return board[number - 1] != '-';
    }
    public void printBoard(){
                //attempting to create....
                //  | - | - | -
                //  -----------
                //  | - | - | -
                //  -----------
                //  | - | - | -

                System.out.println();
                for (int i = 0; i < board.length; i++){
                    if (i % 3 == 0 && i != 0){
                        System.out.println();
                        System.out.println("-------------");
                    }
                    System.out.print(" | " + board[i]);
                }
                System.out.println();
    }
    public static void printIndexBoard(){
        System.out.println();
        for (int i = 0; i < 9; i++){
            if (i % 3 == 0 && i != 0){
                System.out.println();
                System.out.println("-------------");
            }
            System.out.print(" | " + (i + 1));
        }
        System.out.println();
    }
    public boolean isThereAWinner(){
        boolean diagonalsAndMiddles = (rightDi() || leftDi() || middleRow() || secondCol()) && board[4] != '-';
        boolean topAndLeft = (topRow() || leftColumn()) && board[0] != '-';
        boolean bottomAndRight = (bottomRow() || rightColumn()) && board[8] != '-';
        if (diagonalsAndMiddles) {
            this.winner = board[4];
        } else if (topAndLeft) {
            this.winner = board[0];
        } else if (bottomAndRight){
            this.winner = board[8];
        }
        return diagonalsAndMiddles || topAndLeft || bottomAndRight;
    }
    public boolean topRow(){
        return board[0] == board[1] && board[1] == board[2];
    }
    public boolean middleRow(){
        return board[3] == board[4] && board[4] == board[5];
    }
    public boolean bottomRow(){
        return board[6] == board[7] && board[7] == board[8];
    }
    public boolean leftColumn(){
        return board[0] == board[3] && board[3] == board[6];
    }
    public boolean secondCol(){
        return board[1] == board[4] && board[4] == board[7];
    }
    public boolean rightColumn(){
        return board[2] == board[5] && board[5] == board[8];
    }
    public boolean rightDi() {
        return board[0] == board[4] && board[4] == board[8];
    }
    public boolean leftDi() {
        return board[2] == board[4] && board[4] == board[6];
    }
    public boolean isTheBoardFilled(){
        for (int i = 0; i < board.length; i++){
            if (board[i] == '-'){
                return false;
            }
        }
        return true;
    }
    public String gameOver(){
        boolean didSomeoneWin = isThereAWinner();
        if (didSomeoneWin) {
            return "There is a winner!! The winner is " + this.winner + "!";
        } else if (isTheBoardFilled()){
            return "It's a tie game!!";
        } else {
            return "Game still in progress.";
        }
    }
}