package javaCode.adapter;

import javaCode.game.GameEngine;
import javaCode.ui.panels.GameBoardPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MinesAdapter extends MouseAdapter {
private final GameEngine gameEngine;
   private final GameBoardPanel game;
    public MinesAdapter(GameEngine gameEngine, GameBoardPanel game){
        this.gameEngine=gameEngine;
        this.game=game;
    }
    public void mousePressed(MouseEvent e) {

        int x = e.getX();
        int y = e.getY();

        int cCol = x / GameEngine.CELL_SIZE;
        int cRow = y / GameEngine.CELL_SIZE;

        boolean doRepaint = false;

        if (!gameEngine.getInGame()) {

            gameEngine.newGame(GameEngine.gameDifficulty);
            this.game.repaint();
        }
// Check if the mouse click is within the game board boundaries
        if ((x < GameEngine.N_COLS * GameEngine.CELL_SIZE) && (y < GameEngine.N_ROWS * GameEngine.CELL_SIZE)) {

            // Right mouse button clicked
            if (e.getButton() == MouseEvent.BUTTON3) {
                // Check if the cell is not revealed
                if (!gameEngine.field[cRow][cCol].getIsRevealed()||gameEngine.field[cRow][cCol].getFlag()) {

                    doRepaint = true;

                    // Check if the cell is covered and there are marks left
                    if (!gameEngine.field[cRow][cCol].getFlag()) {
                        if (gameEngine.getMinesLeft() > 0) {
                            gameEngine.field[cRow][cCol].setFlag(true);
                            if(gameEngine.field[cRow][cCol].getStatus()==1){gameEngine.field[cRow][cCol].setStatus(3);}
                            if(gameEngine.field[cRow][cCol].getStatus()==0){gameEngine.field[cRow][cCol].setStatus(4);}
                            gameEngine.setMinesLeft(+1);
                            String msg = Integer.toString(gameEngine.getMinesLeft());
                            GameEngine.statusbar.setText(msg);
                        } else {
                            GameEngine.statusbar.setText("No marks left");
                        }
                    } else {
                        // Unmark the cell and increase the mines left count
                        gameEngine.field[cRow][cCol].setFlag(false);
                        if(gameEngine.field[cRow][cCol].getStatus()==3){gameEngine.field[cRow][cCol].setStatus(1);}
                        if(gameEngine.field[cRow][cCol].getStatus()==4){gameEngine.field[cRow][cCol].setStatus(0);}
                        gameEngine.setMinesLeft(-1);
                        String msg = Integer.toString(gameEngine.getMinesLeft());
                        GameEngine.statusbar.setText(msg);
                    }
                }

            } else { // Left mouse button clicked

                // Check if the cell is not revealed
                if (gameEngine.field[cRow][cCol].getIsRevealed()) {
                    return;
                }

                // Check if the cell is not marked as a mine
                if (!(gameEngine.field[cRow][cCol].getFlag())) {

                    // Uncover the cell
                    gameEngine.field[cRow][cCol].setRevealed(true);


                    doRepaint = true;

                    // Check if the uncovered cell is a mine, end the game if so
                    if (gameEngine.field[cRow][cCol].getMine()) {
                        gameEngine.setInGame(false);
                    }

                    // If the uncovered cell is empty, recursively uncover adjacent empty cells
                    if (gameEngine.field[cRow][cCol].getMineCount()==0&&gameEngine.field[cRow][cCol].getStatus()!=4) {
                        gameEngine.setRevelForNeighbours(0,cRow ,cCol);
                    }
                }
            }

            // Repaint the game board if needed
            if (doRepaint) {
                this.game.repaint();
            }
        }
    }
}
