/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import core.Game;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author ponyt
 */
public class MasterMindUi {
    Game game;
    CodebreakerUi codebreakerUi;
    CodemakerUi codemakerUi;
    JFrame frame;
    JMenuBar menuBar;
    JMenu gameMenu;
    JMenu helpMenu;
    JMenuItem newGameMenuItem;
    JMenuItem exitMenuItem;
    JMenuItem aboutMenuItem;
    JMenuItem rulesMenuItem;
   
    public MasterMindUi(Game newgame){
        game = newgame;
        initComponents();
        play();
    } 

    public void initComponents(){
        frame = new JFrame("Mastermind");
        codebreakerUi = new CodebreakerUi(game.getCodebreaker());
        codemakerUi = new CodemakerUi(game.getCodemaker());
        frame.setSize(new Dimension(400,650));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        menuBar = new JMenuBar();
        gameMenu = new JMenu("Game");
        menuBar.add(gameMenu);
        newGameMenuItem = new JMenuItem("New Game");
        exitMenuItem = new JMenuItem("Exit");
        gameMenu.add(newGameMenuItem);
        gameMenu.add(exitMenuItem);
        helpMenu = new JMenu("Help");
        menuBar.add(helpMenu);
        aboutMenuItem = new JMenuItem("About");
        rulesMenuItem = new JMenuItem("Game Rules");
        helpMenu.add(aboutMenuItem);
        helpMenu.add(rulesMenuItem);
        frame.setJMenuBar(menuBar);
        frame.add(codemakerUi.getSecretCode(),BorderLayout.PAGE_START);
        frame.add(codemakerUi.getCodemakerResponse(),BorderLayout.LINE_END);
        frame.add(codebreakerUi.getCodebreakerAttempt(),BorderLayout.LINE_START);
        frame.add(codebreakerUi.getCodebreakerColors(),BorderLayout.PAGE_END);
        frame.setVisible(true);
        
        exitMenuItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int input = JOptionPane.showConfirmDialog(null, "Confirm to "
                + "exit Mastermind?", "Exit?", JOptionPane.YES_NO_OPTION);
                if(input == 0){
                    System.exit(0);
                }
            }
        });
        aboutMenuItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "Mastermind version 1.0\n"
                + "Allexis Knight\nSummer 2019");
            }
        });
        rulesMenuItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
              JOptionPane.showMessageDialog(null, "Step 1: The codemaker "
              + "selects a four color secret code, in any order, no "
              + "duplicate colors.\n\nStep 2: The codebreaker places a guess in"
              + " the bottom row, no duplicate colors.\n\nStep 3: The codemaker"
              + " gives feedback next to each guess row with four pegs.\n"
              + "-Each red peg means that one of the guessed colors is "
              + "correct, and is in the right location.\n-Each white peg "
              + "means that one of the guessed colors is correct, but in the "
              + "wrong location.\n\nStep 4: Repeat with the next row, unless "
              + "the secret code was guessed on the first turn.\n\nStep 5: "
              + "Continue until the secret code is guessed or there are no more"
              + " guesses left, there are 10 attempts.");
            }
        });
    }
    
    public void play(){
        int i;
        for(i = 9; i >= 0; i--){
            codemakerUi.setCheck(false);
            codemakerUi.setCheckClicked(false);
            JOptionPane.showMessageDialog(null, "Codebreaker, enter your guess");
            int size = 0;
            
            while(size < 4){
                size = game.getCodebreaker().size(game.getCodebreaker());
                System.out.println(size);
            }
            codemakerUi.setCheck(true);
            
            JOptionPane.showMessageDialog(null, "Codebreaker, click the Check button");
            while(codemakerUi.isCheckClicked() == false){
                System.out.println("");
            }
            
            JOptionPane.showMessageDialog(null, "Codemaker checking attempt");
            ArrayList<Color> codebreaker = new ArrayList<Color>(game.getCodebreaker()
            .getCodebreakerAttempt());
            game.getCodemaker().checkAttemptedCode(codebreaker);
            ArrayList<Color> response = new ArrayList<Color>(game.getCodemaker()
            .getCodemakerResponse());
            
            codemakerUi.displayCodemakerResponse(i);
            game.getCodebreaker().removeAll();
            if(game.getCodemaker().isCodeGuessed() == true){
                JOptionPane.showMessageDialog(null, "Congratulations! You won!");
                codemakerUi.displaySecretCode();
                break;
            }
        }
        if(game.getCodemaker().isCodeGuessed() == false){
            JOptionPane.showMessageDialog(null, "Sorry! You Lost!");
            codemakerUi.displaySecretCode();
        }
    }     
}
