package javaCode.ui;

import javaCode.game.DefaultGameEngine;
import javaCode.game.GameEngine;
import javaCode.game.difficulty.Difficulty;
import javaCode.game.difficulty.EasyGameDifficulty;
import javaCode.game.difficulty.HardGameDifficulty;
import javaCode.game.difficulty.MediumGameDifficulty;
import javaCode.ui.panels.GameBoardPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface extends JFrame {

    private final GameBoardPanel gameBoardPanel;

    public UserInterface(GameBoardPanel gameBoardPanel) {
        this.gameBoardPanel = gameBoardPanel;
        initUI();
    }

    private void initUI() {

        createMenuBar();
        add(GameEngine.statusbar, BorderLayout.EAST);
        add(gameBoardPanel);


        //setResizable(false);

        pack();
        setTitle("Minesweeper");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu difficultyMenu = new JMenu("Change Difficulty");

        JMenuItem easyItem = new JMenuItem("Easy");
        easyItem.addActionListener(new DifficultyMenuListener(new EasyGameDifficulty()));

        JMenuItem mediumItem = new JMenuItem("Medium");
        mediumItem.addActionListener(new DifficultyMenuListener(new MediumGameDifficulty()));

        JMenuItem hardItem = new JMenuItem("Hard");
        hardItem.addActionListener(new DifficultyMenuListener(new HardGameDifficulty()));

        difficultyMenu.add(easyItem);
        difficultyMenu.add(mediumItem);
        difficultyMenu.add(hardItem);

        menuBar.add(difficultyMenu);

        setJMenuBar(menuBar);
    }

    private class DifficultyMenuListener implements ActionListener {
        private final Difficulty difficulty;

        public DifficultyMenuListener(Difficulty difficulty) {
            this.difficulty = difficulty;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            GameEngine gameEngine = new DefaultGameEngine(difficulty);
            gameBoardPanel.setGameEngine(gameEngine);
            gameBoardPanel.repaint();
        }
    }
}




//package javaCode.ui;
//
//import javaCode.game.GameEngine;
//import javaCode.ui.panels.GameBoardPanel;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class UserInterface extends JFrame {
//    private JLabel statusbar;
//    private final GameBoardPanel gameBoardPanel;
//
//    public UserInterface(GameBoardPanel gameBoardPanel) {
//
//        this.gameBoardPanel = gameBoardPanel;
//        initUI();
//    }
//
//    private void initUI() {
//        add(GameEngine.statusbar, BorderLayout.EAST);
//
//        add(gameBoardPanel);
//
//        setResizable(false);
//        pack();
//
//        setTitle("Minesweeper");
//        setLocationRelativeTo(null);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }
//
//    public void updateStatusBar(String text) {
//        GameEngine.statusbar.setText(text);
//    }
//}