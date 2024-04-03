package javaCode.game;
import javaCode.factories.Board;
import javaCode.game.difficulty.Difficulty;
import javaCode.game.difficulty.MediumGameDifficulty;
import javaCode.models.boards.DefaultBoard;
import javaCode.factories.Cell;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
public class DefaultGameEngine extends GameEngine {
private boolean inGame;
private Board gameBoard;
private int minesLeft;
    public DefaultGameEngine(Difficulty difficulty){
        statusbar = new JLabel("");

        this.img = new LoadResources().Loader();
        newGame(difficulty);
    }



    @Override
    public void newGame(Difficulty difficulty) {
        setGameDifficulty(difficulty);
        resetBounds_Mines();
        this.gameBoard = new DefaultBoard(BoardSIZE);
        this.field = gameBoard.getDefaultBoard();
        this.inGame = true;
        minesLeft = N_MINES;
        statusbar.setText(String.valueOf(minesLeft));
        Set<Integer> chosenPositions = generateUniqueRandomPositions(N_MINES, N_ALL_CELLS);

        for (int position : chosenPositions) {
            int row = gameBoard.getRowCol(position)[0];
            int col = gameBoard.getRowCol(position)[1];

            if (!field[row][col].getIsRevealed()) {
                field[row][col].setStatus(1);
                field[row][col].setMine(true);
                updateNeighbours(position);
            }
        }
    }
private void resetBounds_Mines(){
    N_MINES = gameDifficulty.getMines();
    BoardSIZE = gameDifficulty.getBoardSize();
    N_ROWS = BoardSIZE;
    N_COLS = BoardSIZE;
    N_ALL_CELLS =N_ROWS * N_COLS;
    field = new Cell[N_COLS][N_ROWS];
    BOARD_HEIGHT = N_ROWS * CELL_SIZE + 1;
    BOARD_WIDTH = N_COLS * CELL_SIZE + 1;

}
    public Set<Integer> generateUniqueRandomPositions(int count, int range) {
        Set<Integer> chosenPositions = new HashSet<>();
        Random random = new Random();

        while (chosenPositions.size() < count) {

            int position = random.nextInt(range);
            chosenPositions.add(position);
        }

        return chosenPositions;
    }
    public void updateNeighbours(int position){
        ArrayList <Integer[]> neighbours;
        neighbours=  gameBoard.getNeighboursPositions(gameBoard.getRowCol(position));
        for (Integer[] neighbour : neighbours) {
            this.field[neighbour[0]][neighbour[1]].setMineCount(1);
        }

    }
    /**
     * skip returning on first item
     * */
    int skipFirstItem =0;
    public void setRevelForNeighbours(int skipFirstItem,int row, int col) {
        this.skipFirstItem =skipFirstItem;
        // Base case: If the cell is not empty or has already been revealed, stop recursion
        if (field[row][col].getStatus()==1|| field[row][col].getIsRevealed()&&skipFirstItem>0)
        {
            return;
        }
        this.skipFirstItem++;
        // Set the current cell as revealed





        field[row][col].setRevealed(true);
        // reveal all its neighbours


        // Get neighboring cells
        ArrayList<Cell> neighbors = gameBoard.getNeighbourCells(new int[]{row, col});

        // Recursively reveal neighboring cells if they are empty
        for (Cell neighbor : neighbors) {
            if (neighbor.getMineCount()==0) {

                setRevelForNeighbours(this.skipFirstItem, gameBoard.getRowCol(neighbor.getPosition())[0], gameBoard.getRowCol(neighbor.getPosition())[1]);
            }

            if(field[row][col].getStatus()==4){
                field[row][col].setStatus(0);
                field[row][col].setFlag(false);
                minesLeft++;
                statusbar.setText(String.valueOf(minesLeft));
            }
                neighbor.setRevealed(true);



        }

    }


    @Override
    public boolean getInGame() {
        return this.inGame;
    }

    @Override
    public void setInGame(boolean inGame) {
        this.inGame=inGame;
    }

    @Override
    public int getBoardWidth() {
        return BOARD_WIDTH ;
    }

    @Override
    public int getBoardHeight() {
        return BOARD_HEIGHT;
    }
    @Override
    public int getRows() {
        return N_ROWS;
    }

    @Override
    public int getCols() {
        return N_COLS;
    }


    @Override
    public int getMinesLeft() {
        return minesLeft;
    }

    @Override
    public void setMinesLeft(int amount) {
        minesLeft=minesLeft-amount;
    }



    @Override
    public int getMineCell() {
        return 0;
    }


}