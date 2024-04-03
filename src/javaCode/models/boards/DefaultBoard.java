package javaCode.models.boards;

import javaCode.factories.Board;
import javaCode.factories.Cell;
import javaCode.models.cells.defaultCell;

import java.util.ArrayList;

public class DefaultBoard implements Board {
    public static  int N_ROWS;
    public static  int N_COLS;
    public static Cell[][] board ;
    public DefaultBoard(int size){
        N_COLS=size;
        N_ROWS=size;
        board = new Cell[N_COLS][N_ROWS];
        for (int row =0;row < N_ROWS;row++)
        {
            for (int col = 0; col< N_COLS;col++)
            {
                board[row][col]=new defaultCell(0,0,false,getIndex(row,col));
            }
        }
    }
   public  Cell[][] getDefaultBoard(){
        return board;
    }




    @Override
    public ArrayList<Integer[]> getNeighboursPositions(int[] row_col) {
        ArrayList<Integer[]> neighbours = new ArrayList<>();

        int row = row_col[0];
        int col = row_col[1];

        // Check up
        if (row > 0) {
            neighbours.add(new Integer[]{row - 1, col});
        }
        // Check down
        if (row < N_ROWS - 1) {
            neighbours.add(new Integer[]{row + 1, col});
        }
        // Check left
        if (col > 0) {
            neighbours.add(new Integer[]{row, col - 1});
        }
        // Check right
        if (col < N_COLS - 1) {
            neighbours.add(new Integer[]{row, col + 1});
        }
        // Check up-left
        if (row > 0 && col > 0) {
            neighbours.add(new Integer[]{row - 1, col - 1});
        }
        // Check up-right
        if (row > 0 && col < N_COLS - 1) {
            neighbours.add(new Integer[]{row - 1, col + 1});
        }
        // Check down-left
        if (row < N_ROWS - 1 && col > 0) {
            neighbours.add(new Integer[]{row + 1, col - 1});
        }
        // Check down-right
        if (row < N_ROWS - 1 && col < N_COLS - 1) {
            neighbours.add(new Integer[]{row + 1, col + 1});
        }

        return neighbours;
    }

    public ArrayList<Cell> getNeighbourCells(int[] row_col) {
        ArrayList<Cell> neighbours = new ArrayList<>();
        for(Integer[] positions:getNeighboursPositions(row_col)){
            neighbours.add(board[positions[0]][positions[1]]);
        }
        return neighbours;
    }

    /**
     * getting Row and columns
     * */
    public int[] getRowCol(int index) {
        int row = index / N_COLS;
        int col = index % N_COLS;
        return new int[] {row, col};
    }

    // Convert a 2D row and column to a 1D index
    public int getIndex(int row, int col) {
        return (row * N_COLS) + col;
    }
}
