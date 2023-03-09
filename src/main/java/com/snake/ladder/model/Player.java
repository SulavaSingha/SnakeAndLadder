package com.snake.ladder.model;

public class Player {
    String id;
    int currentPosition;

    public Player(String id) {
        this.id = id;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }
}
