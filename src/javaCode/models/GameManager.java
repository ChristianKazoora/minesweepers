package javaCode.models;

import javaCode.game.DefaultGameEngine;
import javaCode.game.GameEngine;
import javaCode.game.difficulty.Difficulty;
import javaCode.game.difficulty.EasyGameDifficulty;
import javaCode.game.difficulty.HardGameDifficulty;
import javaCode.game.difficulty.MediumGameDifficulty;
import javaCode.ui.UserInterface;
import javaCode.ui.panels.GameBoardPanel;

import javax.swing.*;

public class GameManager extends JFrame {

    public GameManager() {
        // Initialize java.game manager
    initManager();
    }

    private void initManager() {
        Difficulty easyDifficulty = new EasyGameDifficulty();
        Difficulty mediumDifficulty = new MediumGameDifficulty();
        Difficulty hardDifficulty = new HardGameDifficulty();

        GameEngine engine = new DefaultGameEngine(mediumDifficulty);
        GameBoardPanel defaultPanel = new GameBoardPanel(engine);
        new UserInterface(defaultPanel).setVisible(true);
    }

    // Other java.game manager methods
}
