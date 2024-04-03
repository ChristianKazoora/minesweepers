package javaCode.game.difficulty;

public interface Difficulty {
    void setMines(int n_mines);
    void setDisplaySize(int size);
    int getBoardSize();
    int getMines();
}
