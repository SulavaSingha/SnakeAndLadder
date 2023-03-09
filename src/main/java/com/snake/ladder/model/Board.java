package com.snake.ladder.model;


import com.snake.ladder.dao.SnakeLadderDao;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
    int[][] grid;
    Jump jump;
    Dice dice;
    int size;
    int numOfsnakes;
    int numOfLadder;

    public Board(int size, int numOfsnakes, int numOfLadder) {
        this.size = size;
        this.numOfsnakes = numOfsnakes;
        this.numOfLadder = numOfLadder;
        this.grid = new int[size][size];

    }

    public void addSankesAndLadder() {
        while (numOfsnakes > 0) {
            int snakeHead = ThreadLocalRandom.current().nextInt(1, size * size);
            int snakeTail = ThreadLocalRandom.current().nextInt(1, size * size);
            while (snakeHead < snakeTail) {
                continue;
            }
            jump = new Jump(snakeHead, snakeTail);
            SnakeLadderDao.getInstance().addTosnakeList(jump);

            numOfsnakes--;
        }
        while (numOfLadder > 0) {
            int ladderStart = ThreadLocalRandom.current().nextInt(1, size * size);
            int ladderEnd = ThreadLocalRandom.current().nextInt(1, size * size);
            while (ladderStart < ladderEnd) {
                continue;
            }
            jump = new Jump(ladderStart, ladderEnd);
            SnakeLadderDao.getInstance().addToLadderList(jump);

            numOfLadder--;
        }
    }

    public int getPosition(int playerPosition) {
        int row = playerPosition / size;
        int col = playerPosition % size;
        return (row * col) + col;
    }

    public int checkPosition(int position) {
        int pos = getPosition(position);
        int jumpPos = SnakeLadderDao.getInstance().getJump(pos);
        if(jumpPos==-1) return pos;
        else return jumpPos;

    }
}
