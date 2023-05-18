/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import core.Game;
import javax.swing.JOptionPane;
import userInterface.MasterMindUi;

/**
 *
 * @author ponyt
 */
public class MasterMind {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Prints a message, creates an opening dialog box, and instantiates an
        // instance of Game
        System.out.println("Welcome to MasterMind!");
        JOptionPane.showMessageDialog(null, "Let's Play Mastermind!");
        Game masterMind = new Game();
        MasterMindUi Interface = new MasterMindUi(masterMind);
    }
    
}
