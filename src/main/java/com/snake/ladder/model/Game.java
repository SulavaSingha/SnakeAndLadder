package com.snake.ladder.model;

import java.util.Deque;
import java.util.LinkedList;

public class Game {
    Board board;
    Dice dice;
    Deque<Player> playersList = new LinkedList<>();
    Player winner;

    public Game() {
        initializeGame();
    }

    public void initializeGame() {
        board = new Board(10, 3, 3);
        dice = new Dice(1, 1, 6);
        Player p1 = new Player("1");
        p1.setCurrentPosition(0);
        Player p2 = new Player("2");
        p2.setCurrentPosition(0);
        playersList.add(p1);
        playersList.add(p2);
    }

    public Player turn() {
        Player player = playersList.removeLast();
        playersList.addFirst(player);
        return player;
    }

    public Player play() {
        while (winner == null) {
            Player player = turn();
            System.out.println("Curren player: " + player.id + " is positioned at: " + player.getCurrentPosition());

            int nextPosition = dice.rollDice();
            int playerNewPostion = board.checkPosition(player.getCurrentPosition() + nextPosition);
            if (playerNewPostion >= board.size * board.size) {
                winner= player;
                System.out.println("we found winner: "+winner);
            }
            else {
                player.setCurrentPosition(playerNewPostion);
                System.out.println("after  player: " + player.id + " turn , is positioned at: " + player.getCurrentPosition());
            }
        }
        return winner;
    }
}
