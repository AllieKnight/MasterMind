/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import constants.Constants;
import static constants.Constants.MAX_PEGS;

/**
 *
 * @author ponyt
 */
public class Codemaker implements ICodemaker{
    // Member variable declarations
    private static HashSet<Color> secretCode;
    private static ArrayList<Color> codemakerResponse;
    private boolean codeGuessed;
    
    // Constructor to intialize both member variables and call generateSecret
    //Code() method
    public Codemaker(){
        secretCode = new HashSet();
        codemakerResponse = new ArrayList<Color> ();
        codeGuessed = false;
        generateSecretCode();
    }
    
    // Method declared by interface ICodemaker, creating a new secret color code
    // and storing in HashSet secretCode
    @Override
    public void generateSecretCode(){
        // Instantiate an instance of class Random
        Random rand = new Random();
        // Using a random number as the index, gets a color from the constant
        // ArrayList codeColors, instantiates an instance of the color class, 
        // adds that color object to secretCode. Continues until 4 are present
        while (secretCode.size() < 4){
            Color newColor = new Color(0,0,0);
            newColor = Constants.codeColors.get(rand.nextInt(8));
            secretCode.add(newColor);
        }
        
        // Prints the secret code
        System.out.println("generated the secret code!");
        for(Color color : secretCode){
            System.out.println(color);
        }
    }
    
    // Method declared by interface ICodemaker
    @Override
    public void checkAttemptedCode(ArrayList<Color> attempt){
        int redpegs = 0;
	int whitepegs = 0;
        int i;
        HashSet<Color> peg = new HashSet();
	ArrayList<Color> secretList = new ArrayList<Color>(secretCode);
        
        codemakerResponse.removeAll(codemakerResponse);
        
        System.out.println("Codemaker is checking codebreaker attempt");
	
        if(secretList.equals(attempt)){
            redpegs = 4;
            System.out.println("You guessed it!");
            codeGuessed = true;
            for(i = 0; i < redpegs; i++){
                codemakerResponse.add(Color.RED);
            }
            return;
        }
        else
        {
            for(i = 0; i < MAX_PEGS; i++){
                if(secretList.get(i).equals(attempt.get(i))){
                    redpegs++;
                    System.out.println("Found correct color at correct position!");
                    peg.add(attempt.get(i));
                }
            }
        }
        for(i = 0; i < MAX_PEGS; i++){
            if(secretList.get(i) != attempt.get(i) && 
            secretList.contains(attempt.get(i)) &&
            (!peg.contains(attempt.get(i)))){
                whitepegs++;
                System.out.println("Found correct color at wrong postion");
                peg.add(attempt.get(i));
            }
        }
        
        for(i = 0; i < redpegs; i++){
            codemakerResponse.add(Color.RED);
        }
        for(i = 0; i < whitepegs; i++){
            codemakerResponse.add(Color.WHITE);
        }
        System.out.println("Red pegs " + redpegs + " white pegs " + whitepegs);
    }

    /**
     * @return the secretCode
     */
    // Getter for secretCode
    public static HashSet<Color> getSecretCode() {
        return secretCode;
    }

    /**
     * @param secretCode the secretCode to set
     */
    // Setter for secretCode
    public void setSecretCode(HashSet<Color> secretCode) {
        this.secretCode = secretCode;
    }

    /**
     * @return the codemakerResponse
     */
    // Getter for codemakerResponse
    public static ArrayList<Color> getCodemakerResponse() {
        return codemakerResponse;
    }

    /**
     * @param codemakerResponse the codemakerResponse to set
     */
    // Setter for codemakerResponse
    public void setCodemakerResponse(ArrayList<Color> codemakerResponse) {
        this.codemakerResponse = codemakerResponse;
    }

    /**
     * @return the codeGuessed
     */
    public boolean isCodeGuessed() {
        return codeGuessed;
    }

    /**
     * @param codeGuessed the codeGuessed to set
     */
    public void setCodeGuessed(boolean codeGuessed) {
        this.codeGuessed = codeGuessed;
    }
}
