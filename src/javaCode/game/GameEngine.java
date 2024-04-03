package javaCode.game;

import javax.swing.*;
import java.awt.*;

import javaCode.factories.Cell;
import javaCode.game.difficulty.Difficulty;

public abstract class GameEngine  {
    public static Difficulty gameDifficulty;
    public static final int NUM_IMAGES = 13;
    public static final int CELL_SIZE = 15;
    public static  int BoardSIZE;
    public static  int N_MINES;
    public static final int COVER_FOR_CELL = 10;
    public static final int MARK_FOR_CELL = 10;
    public static final int EMPTY_CELL = 0;
    public static final int MINE_CELL = 9;
    public static final int COVERED_MINE_CELL = MINE_CELL + COVER_FOR_CELL;
    public static final int MARKED_MINE_CELL = COVERED_MINE_CELL + MARK_FOR_CELL;

    public static final int DRAW_MINE = 9;
    public static final int DRAW_COVER = 10;
    public static final int DRAW_MARK = 11;
    public static final int DRAW_WRONG_MARK = 12;


    public static  int N_ROWS;
    public static  int N_COLS ;
    public static  int N_ALL_CELLS ;
    public static  int BOARD_WIDTH;
    public static  int BOARD_HEIGHT;

    public Cell[][] field;
    public static JLabel statusbar;
    public Image[] img;

    public abstract boolean getInGame();
    public abstract void setInGame(boolean inGame);
    public abstract int getMinesLeft();
    public abstract void setMinesLeft(int amount);
    public abstract void newGame(Difficulty difficulty);
    public abstract int getMineCell();
    public abstract int getRows();
    public abstract int getCols();
    public abstract int getBoardWidth();

    public abstract int getBoardHeight();
    public abstract void setRevelForNeighbours(int skipFirstItem, int row,int col);
    public void setGameDifficulty(Difficulty difficulty) {
        gameDifficulty=difficulty;
    }
}