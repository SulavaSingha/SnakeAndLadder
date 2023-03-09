package com.snake.ladder.model;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    private int diceCount;
    private  int MAX ;
    private  int MIN ;

    public Dice(int diceCount,int min,int max){
        this.diceCount=diceCount;
        this.MIN=min;
        this.MAX =max;

    }

    public int rollDice(){
        int dice=0;
        int total=0;
        while(dice<diceCount){
             total += ThreadLocalRandom.current().nextInt(MIN,MAX+1);
             dice++;
        }

        return total;

    }
}
