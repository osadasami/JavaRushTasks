package com.javarush.games.game2048;

import com.javarush.engine.cell.*;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Game2048 extends Game {
    private static final int SIDE = 4;
    private int[][] gameField = new int[SIDE][SIDE];
    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();
    }

    private void createGame() {
        createNewNumber();
        createNewNumber();
    }

    private void drawScene() {
        for(int y = 0; y < SIDE; y++) {
            for(int x = 0; x < SIDE; x++) {
                setCellColoredNumber(x,y,gameField[y][x]);
            }
        }
    }

    private void createNewNumber() {
        int randomX = getRandomNumber(SIDE);
        int randomY = getRandomNumber(SIDE);
        int randomValue = getRandomNumber(10) == 9 ? 4 : 2;
        while(gameField[randomY][randomX] != 0) {
            randomX = getRandomNumber(SIDE);
            randomY = getRandomNumber(SIDE);
        }
        gameField[randomY][randomX] = randomValue;
    }

    private Color getColorByValue(int value) {
        Color color;
        switch (value) {
            case 2:
                color = Color.PINK;
                break;

            case 4:
                color = Color.PURPLE;
                break;
            case 8:
                color = Color.BLUE;
                break;
            case 16:
                color = Color.CYAN;
                break;
            case 32:
                color = Color.GREENYELLOW;
                break;
            case 64:
                color = Color.GREEN;
                break;
            case 128:
                color = Color.ORANGE;
                break;
            case 256:
                color = Color.TOMATO;
                break;
            case 512:
                color = Color.RED;
                break;
            case 1024:
                color = Color.AQUA;
                break;
            case 2048:
                color = Color.CORAL;
                break;
            default:
                color = Color.WHITE;
        }
        return color;
    }

    private void setCellColoredNumber(int x, int y, int value) {
        Color color = getColorByValue(value);
        setCellValueEx(x,y,color, value == 0 ? "" : String.valueOf(value));
    }

    private boolean compressRow(int[] row) {
        boolean isChanged = false;

        for(int i = 0; i < row.length; i++) {
            for(int j = i; j < row.length; j++) {
                if(row[i] == 0 && row[j] != 0) {
                    row[i] = row[j];
                    row[j] = 0;
                    isChanged = true;
                    break;
                }
            }
            boolean isNotZeroesExist = Arrays.stream(Arrays.copyOfRange(row, i+1, row.length)).anyMatch(n -> n != 0);
            if(!isNotZeroesExist) return isChanged;
        }

        return isChanged;
    }

    private boolean mergeRow(int[] row) {
        boolean isChanged = false;

        for(int i = 0; i < row.length; i++) {
            if(i + 1 != row.length && row[i] != 0 && row[i+1] != 0 && row[i] == row[i+1]) {
                row[i] += row[i+1];
                row[i+1] = 0;
                isChanged = true;
            }
        }

        return isChanged;
    }

    @Override
    public void onKeyPress(Key key) {
        if(key == Key.UP) {
            moveUp();
        }
        if(key == Key.RIGHT) {
            moveRight();
        }
        if(key == Key.DOWN) {
            moveDown();
        }
        if(key == Key.LEFT) {
            moveLeft();
        }
    }
    private void moveLeft() {};
    private void moveRight() {};
    private void moveUp() {};
    private void moveDown() {};
}
