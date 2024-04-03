package javaCode.game.difficulty;

public class EasyGameDifficulty extends gameDifficulty{


    public EasyGameDifficulty(){

    }
    @Override
    public void setMines(int n_mines) {

    }

    @Override
    public void setDisplaySize(int size) {

    }

    @Override
    public int getBoardSize() {
        return BoardSIZE;
    }

    @Override
    public int getMines() {
        return N_MINES-20;
    }
    // Implement easy java.game difficulty
}