package com.javarush.games.snake;

import com.javarush.engine.cell.*;

public class SnakeGame extends Game {
    public static final int WIDTH = 15;
    public static final int HEIGHT = 15;
    private Snake snake;
    private Apple apple;
    private int turnDelay;
    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void createGame() {
        turnDelay = 300;
        setTurnTimer(turnDelay);
        Snake snake = new Snake(WIDTH/2, HEIGHT/2);
        Apple apple = new Apple(5,5);
        this.snake = snake;
        this.apple = apple;
        drawScene();
    }

    private void drawScene() {
        for(int y = 0; y < HEIGHT; y++) {
            for(int x = 0; x < WIDTH; x++) {
                setCellValueEx(x,y,Color.DARKSEAGREEN, "");
            }
        }
        snake.draw(this);
        apple.draw(this);
    }

    @Override
    public void onTurn(int step) {
        snake.move(apple);
        drawScene();
    }

    @Override
    public void onKeyPress(Key key) {
        if(key == Key.LEFT) {
            snake.setDirection(Direction.LEFT);
        }
        if(key == Key.RIGHT) {
            snake.setDirection(Direction.RIGHT);
        }
        if(key == Key.UP) {
            snake.setDirection(Direction.UP);
        }
        if(key == Key.DOWN) {
            snake.setDirection(Direction.DOWN);
        }
    }
}
