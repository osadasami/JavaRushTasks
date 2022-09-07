package com.javarush.games.minesweeper;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";
    private int countFlags;

    private boolean isGameStopped;
    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    private void createGame() {
        isGameStopped = false;
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                boolean isMine = getRandomNumber(10) < 1;
                if (isMine) {
                    countMinesOnField++;
                }
                gameField[y][x] = new GameObject(x, y, isMine);
                setCellColor(x, y, Color.ORANGE);
            }
        }
        countMineNeighbors();
        countFlags = countMinesOnField;
    }

    private List<GameObject> getNeighbors(GameObject gameObject) {
        List<GameObject> result = new ArrayList<>();
        for (int y = gameObject.y - 1; y <= gameObject.y + 1; y++) {
            for (int x = gameObject.x - 1; x <= gameObject.x + 1; x++) {
                if (y < 0 || y >= SIDE) {
                    continue;
                }
                if (x < 0 || x >= SIDE) {
                    continue;
                }
                if (gameField[y][x] == gameObject) {
                    continue;
                }
                result.add(gameField[y][x]);
            }
        }
        return result;
    }

    private void countMineNeighbors() {
        for(int y = 0; y < SIDE; y++) {
            for(int x = 0; x < SIDE; x++) {
                GameObject currentObject = gameField[y][x];
                if(!currentObject.isMine) {
                    List<GameObject> neibors = getNeighbors(currentObject);

                    for(GameObject neibor : neibors) {
                        if(neibor.isMine) {
                            currentObject.countMineNeighbors += 1;
                        }
                    }
                }
            }
        }
    }
    private void openTile(int x, int y) {
        GameObject object = gameField[y][x];
        object.isOpen = true;
        setCellColor(x,y, Color.GREEN);
        if (object.isMine) {
            setCellValueEx(x,y, Color.RED, MINE);
            gameOver();
        } else {
            if(object.countMineNeighbors == 0) {
                List<GameObject> neighbors = getNeighbors(object);
                for(GameObject neibor : neighbors) {
                    if(!neibor.isOpen) {
                        openTile(neibor.x, neibor.y);
                    }
                }
                setCellValue(x,y,"");
            } else {
                setCellNumber(x,y, object.countMineNeighbors);
            }
        }
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        openTile(x,y);
    }

    private void markTile(int x, int y) {
        if(isGameStopped) return;
        GameObject object = gameField[y][x];
        if(object.isOpen) return;
        if(countFlags == 0 && !object.isFlag) return;
        if(!object.isFlag) {
            object.isFlag = true;
            countFlags -= 1;
            setCellValue(x,y,FLAG);
            setCellColor(x,y,Color.YELLOW);
        } else {
            object.isFlag = false;
            countFlags += 1;
            setCellValue(x,y,"");
            setCellColor(x,y,Color.ORANGE);
        }
    }

    @Override
    public void onMouseRightClick(int x, int y) {
        markTile(x,y);
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.RED, "Game Over", Color.BLACK, 18);
    }
}