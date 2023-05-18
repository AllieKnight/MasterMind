/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import constants.Constants;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author ponyt
 */
public class Game implements IGame{
    // Member variable declarations
    int attempt;
    private Codebreaker codebreaker;
    private Codemaker codemaker;
    
    // Initializes all member variables
    public Game(){
        codebreaker = new Codebreaker();
        codemaker = new Codemaker();
        attempt = 0;
        //play();
    }
    
    // Method declared by interface IGame
    @Override
    public void play(){
        do
        {
            attempt++;
            System.out.println("Attempt " + attempt);
            ArrayList<Color> codeBreak = getCodebreaker().getCodebreakerAttempt();
            getCodemaker().checkAttemptedCode(codeBreak);
            System.out.println("Codemaker's Response");
            ArrayList<Color> response = getCodemaker().getCodemakerResponse();
            for(Color color : response){
                System.out.println(color);
            }
        }while(attempt < Constants.MAX_ATTEMPTS && !codemaker.isCodeGuessed());
    }

    /**
     * @return the codebreaker
     */
    public Codebreaker getCodebreaker() {
        return codebreaker;
    }

    /**
     * @return the codemaker
     */
    public Codemaker getCodemaker() {
        return codemaker;
    }

}
