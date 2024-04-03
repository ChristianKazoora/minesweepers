package javaCode.ui.panels;

import javaCode.adapter.MinesAdapter;
import javaCode.factories.Cell;
import javaCode.game.GameEngine;

import javax.swing.*;
import java.awt.*;

public class GameBoardPanel extends JPanel {

    private  GameEngine gameEngine;
    private int uncover ;

    public GameBoardPanel(GameEngine gameEngine) {
        uncover =0;
        this.gameEngine = gameEngine;
        setPreferredSize(new Dimension(gameEngine.getBoardWidth(), gameEngine.getBoardHeight()));
        addMouseListener(new MinesAdapter(gameEngine,this));
    }


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < gameEngine.getRows(); i++) {
            for (int j = 0; j < gameEngine.getCols(); j++) {
                Cell cell = gameEngine.field[i][j];

                int toDraw = determineCellState(cell);
               // System.out.println(uncover);
                if (uncover == 0 && gameEngine.getInGame()) {
                    gameEngine.setInGame(false);
                    GameEngine.statusbar.setText("Game won");

                } else if (!gameEngine.getInGame()) {
                    GameEngine.statusbar.setText("Game lost");
                }
                g.drawImage(gameEngine.img[toDraw], j * GameEngine.CELL_SIZE,
                        i * GameEngine.CELL_SIZE, this);
            }
        }
    }

    private int determineCellState(Cell cell) {

        if (!gameEngine.getInGame()) {
            if (cell.getStatus() == 1) {
                return GameEngine.DRAW_MINE;
            } else if (cell.getStatus() ==3&& cell.getMine()) {
                return GameEngine.DRAW_MARK;
            } else if (cell.getStatus() == 4&&!cell.getMine()) {
                return GameEngine.DRAW_WRONG_MARK;
            } else if(!cell.getIsRevealed()) {
                return GameEngine.COVER_FOR_CELL;
            }
            else {
                return cell.getMineCount();
            }
        } else {
            if (cell.getFlag()) {
                return GameEngine.DRAW_MARK;
            } else if (cell.getStatus() == 1 && cell.getIsRevealed()) {
                return GameEngine.DRAW_MINE;
            } else if (cell.getIsRevealed()) {
                return cell.getMineCount();
            } else {
                uncover++;
                return GameEngine.DRAW_COVER;
            }
        }
    }

    public void setGameEngine(GameEngine gameEngine){
        uncover =0;
        this.gameEngine = gameEngine;
        setPreferredSize(new Dimension(gameEngine.getBoardWidth(), gameEngine.getBoardHeight()));
        addMouseListener(new MinesAdapter(gameEngine,this));
        GameEngine.statusbar.setText(String.valueOf(gameEngine.getMinesLeft()));
    }
}