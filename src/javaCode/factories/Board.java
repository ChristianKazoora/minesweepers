package javaCode.factories;

import java.util.ArrayList;

public interface Board {
 ArrayList<Integer[]> getNeighboursPositions(int[] row_col);
ArrayList<Cell> getNeighbourCells(int[] row_col);
  int[] getRowCol(int index);
  int getIndex(int row,int col);
 Cell[][] getDefaultBoard();
}
