package com.launchcode.java;

    //AI stands for artificial intelligence

import javax.print.attribute.IntegerSyntax;
import java.util.ArrayList;
import java.util.Random;

public class AI {
    public int chooseSquare(TicTacToe joue){
        ArrayList<Integer> choices = new ArrayList();
        for (int i = 0; i < 9; i += 1){
            //add the slot as a choice if it hasn't been taken
            if (joue.board[i] == '-'){
                choices.add(i + 1);
            }
        }
        Random ra = new Random();
        int choice = choices.get(Math.abs(ra.nextInt() % choices.size()));
        return choice;
    }
}

