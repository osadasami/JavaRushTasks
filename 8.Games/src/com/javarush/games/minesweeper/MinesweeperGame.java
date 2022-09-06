package com.javarush.games.minesweeper;

import com.javarush.engine.cell.*;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];

    private int countMinesOnField = 0;
    @Override
    public void initialize() {
        super.initialize();
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    private void createGame() {
        for(int y = 0; y < SIDE; y++) {
            for(int x = 0; x < SIDE; x++) {
                boolean needMine = getRandomNumber(10) == 0;
                gameField[y][x] = new GameObject(x,y, needMine);
                setCellColor(x,y,Color.ORANGE);
                if (needMine) {
                    countMinesOnField += 1;
                }
            }
        }
    }
}