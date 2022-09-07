package com.javarush.games.snake;

import com.javarush.engine.cell.*;

public class SnakeGame extends Game {
    public static final int WIDTH = 15;
    public static final int HEIGHT = 15;
    private Snake snake;
    private Apple apple;
    private boolean isGameStopped;
    private int turnDelay;
    private static final int GOAL = 28;
    private int score;
    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void createGame() {
        turnDelay = 300;
        score = 0;
        setScore(score);
        setTurnTimer(turnDelay);
        Snake snake = new Snake(WIDTH/2, HEIGHT/2);
        this.snake = snake;
        createNewApple();
        isGameStopped = false;
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
        if(!apple.isAlive) {
            createNewApple();
            score += 5;
            setScore(score);
            turnDelay -= 10;
            setTurnTimer(turnDelay);
        }
        if(!snake.isAlive) {
            gameOver();
        }
        if(snake.getLength() > GOAL) {
            win();
        }
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
        if(key == Key.SPACE && isGameStopped) {
            createGame();
        }
    }
    
    private void createNewApple() {
        int x = getRandomNumber(WIDTH);
        int y = getRandomNumber(HEIGHT);
        Apple apple = new Apple(x,y);
        while (snake.checkCollision(apple)) {
            x = getRandomNumber(WIDTH);
            y = getRandomNumber(HEIGHT);
            apple = new Apple(x,y);
        }
        this.apple = apple;
    }

    private void gameOver() {
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.RED,"Game Over", Color.BLACK,18);
    }

    private void win() {
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.GREEN,"Win", Color.BLACK,18);
    }
}
