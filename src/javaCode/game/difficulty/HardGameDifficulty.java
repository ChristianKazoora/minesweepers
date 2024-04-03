package javaCode.game.difficulty;

public class HardGameDifficulty extends gameDifficulty{


    @Override
    public void setMines(int n_mines) {

    }

    @Override
    public void setDisplaySize(int size) {

    }

    @Override
    public int getBoardSize() {
        return BoardSIZE*2;
    }

    @Override
    public int getMines() {
        return N_MINES*5;
    }
    // Implement hard java.game difficulty
}