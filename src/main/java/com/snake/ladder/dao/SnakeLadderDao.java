package com.snake.ladder.dao;

import com.snake.ladder.model.Jump;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SnakeLadderDao {
    Set<Jump> snakeList;
    Set<Jump> ladderList;
    private static SnakeLadderDao snakeDao=null;
    private SnakeLadderDao(){
        this.snakeList = new HashSet<Jump>();
        this.ladderList = new HashSet<>();

    }
    public static SnakeLadderDao getInstance(){
        if(snakeDao ==null){
            return new SnakeLadderDao();
        }
        return snakeDao;
    }
    public void addTosnakeList(Jump jump){
        snakeList.add(jump);
    }
    public void addToLadderList(Jump jump){
        ladderList.add(jump);
    }
    public int getJump(int pos){
        for(Jump jump:snakeList){
            if(pos== jump.getStart()){
                return jump.getEnd();
            }
        }
            for(Jump jump:ladderList){
                if(pos==jump.getStart()){
                    return jump.getEnd();
            }
        }
            return -1;
    }


}
