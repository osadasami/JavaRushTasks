package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";
    private final List<GameObject> snakeParts = new ArrayList<>();
    public boolean isAlive = true;
    private Direction direction = Direction.LEFT;
    Snake(int x, int y) {
        snakeParts.add(new GameObject(x, y));
        snakeParts.add(new GameObject(x + 1, y));
        snakeParts.add(new GameObject(x + 2, y));
    }

    public void draw(Game game) {
        Color snakeColor = this.isAlive ? Color.BLACK : Color.RED;

        for (int i = 0; i < snakeParts.size(); i++) {
            String sign = i == 0 ? HEAD_SIGN : BODY_SIGN;
            game.setCellValueEx(
                    snakeParts.get(i).x,
                    snakeParts.get(i).y,
                    Color.NONE,
                    sign,
                    snakeColor,
                    75
            );
        }
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void move() {

    }

    public GameObject createNewHead() {
        if(direction == Direction.UP) {
            return new GameObject(
                    snakeParts.get(0).x, 
                    snakeParts.get(0).y-1
            );
        } else if(direction == Direction.RIGHT) {
            return new GameObject(
                    snakeParts.get(0).x+1, 
                    snakeParts.get(0).y
            );
        } else if(direction == Direction.DOWN) {
            return new GameObject(
                    snakeParts.get(0).x, 
                    snakeParts.get(0).y+1
            );
        } else {
            return new GameObject(
                    snakeParts.get(0).x-1,
                    snakeParts.get(0).y
            );
        }
    }

    public void removeTail() {
        snakeParts.remove(snakeParts.size()-1);
    }
}
