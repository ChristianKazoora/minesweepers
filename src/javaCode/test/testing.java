package javaCode.test;

import javaCode.game.DefaultGameEngine;
import javaCode.game.GameEngine;
import javaCode.models.boards.DefaultBoard;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class testing {

    @Test
    public void testGetNeighboursPositions() {
        // Initialize your class instance here, for example:
        DefaultBoard myClass = new DefaultBoard(5);

        // Assuming N_ROWS and N_COLS are defined somewhere
        int N_ROWS = 5;
        int N_COLS = 5;

        // Assuming row_col is a valid position within the grid
        int[] row_col = {2, 2};

        // Call the method under test
        ArrayList<Integer[]> neighbours = myClass.getNeighboursPositions(row_col);

        // Check the size of the returned list
        assertEquals(8, neighbours.size());
        System.out.println(Arrays.toString(neighbours.get(0)) + "  " + (new Integer[]{1, 2}));
        // Check if each expected neighbour is present
        assertTrue(neighbours.contains(new Integer[]{1, 2})); // up
        assertTrue(neighbours.contains(new Integer[]{3, 2})); // down
        assertTrue(neighbours.contains(new Integer[]{2, 1})); // left
        assertTrue(neighbours.contains(new Integer[]{2, 3})); // right
        assertTrue(neighbours.contains(new Integer[]{1, 1})); // up-left
        assertTrue(neighbours.contains(new Integer[]{1, 3})); // up-right
        assertTrue(neighbours.contains(new Integer[]{3, 1})); // down-left
        assertTrue(neighbours.contains(new Integer[]{3, 3})); // down-right
    }




}
