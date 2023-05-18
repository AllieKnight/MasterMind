/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import static constants.Constants.MAX_PEGS;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ponyt
 */
public class Codebreaker implements ICodebreaker{
    // Member variable declaration
    private ArrayList<Color> codebreakerAttempt;
    
    // Constructor that initializes the above variable
    public Codebreaker(){
        codebreakerAttempt = new ArrayList<Color> ();
    }
    
    // method declared by interface ICodebreaker
    @Override
    public void checkCode(ArrayList<Color> attempt){
     
    }
    
    public void  consoleAttempt(){
        codebreakerAttempt.removeAll(codebreakerAttempt);
        Scanner scnr = new Scanner(System.in);
        System.out.println("\nEnter your colors in left to right order\n" + 
        "Use BLUE, BLACK, ORANGE, WHITE, YELLOW, RED, GREEN, PINK:");
        String codeColor;
        
        while(codebreakerAttempt.size() < MAX_PEGS)
        {
            System.out.println("Enter color");
            
            codeColor = scnr.next();
            codeColor = codeColor.toLowerCase();
            if(codeColor.equals("blue")){
                System.out.println("You entered " + codeColor);
                if(codebreakerAttempt.contains(Color.BLUE)){
                    continue;
                }
                codebreakerAttempt.add(Color.BLUE);
            }
            if(codeColor.equals("black")){
                System.out.println("You entered " + codeColor);
                if(codebreakerAttempt.contains(Color.BLACK)){
                    continue;
                }
                codebreakerAttempt.add(Color.BLACK);
            }
            if(codeColor.equals("green")){
                System.out.println("You entered " + codeColor);
                if(codebreakerAttempt.contains(Color.GREEN)){
                    continue;
                }
                codebreakerAttempt.add(Color.GREEN);
            }
            if(codeColor.equals("pink")){
                System.out.println("You entered " + codeColor);
                if(codebreakerAttempt.contains(Color.PINK)){
                    continue;
                }
                codebreakerAttempt.add(Color.PINK);
            }
            if(codeColor.equals("red")){
                System.out.println("You entered " + codeColor);
                if(codebreakerAttempt.contains(Color.RED)){
                    continue;
                }
                codebreakerAttempt.add(Color.RED);
            }
            if(codeColor.equals("yellow")){
                System.out.println("You entered " + codeColor);
                if(codebreakerAttempt.contains(Color.YELLOW)){
                    continue;
                }
                codebreakerAttempt.add(Color.YELLOW);
            }
            if(codeColor.equals("orange")){
                System.out.println("You entered " + codeColor);
                if(codebreakerAttempt.contains(Color.ORANGE)){
                    continue;
                }
                codebreakerAttempt.add(Color.ORANGE);
            }
            if(codeColor.equals("white")){
                System.out.println(codeColor);
                if(codebreakerAttempt.contains(Color.WHITE)){
                    continue;
                }
                codebreakerAttempt.add(Color.WHITE);
            }         
        }
        System.out.println("Codebreaker's Attempt");
        for(Color color : codebreakerAttempt){
            System.out.println(color);
        }
        System.out.println("");
    }
    
    public void removeAll(){
        codebreakerAttempt.clear();
    }

    /**
     * @return the codebreakerAttempt
     */
    // Getter method for codebreakerAttempt
    public ArrayList<Color> getCodebreakerAttempt() {
        //consoleAttempt();
        return codebreakerAttempt;
    }

    /**
     * @param codebreakerAttempt the codebreakerAttempt to set
     */
    // Setter method for codebreakerAttempt
    public void setCodebreakerAttempt(ArrayList<Color> codebreakerAttempt) {
        this.codebreakerAttempt = codebreakerAttempt;
    }
    
     public int size(Codebreaker codebreaker){
        return codebreakerAttempt.size();
    }
     
    public boolean contains(Color colorSelected){
        if(codebreakerAttempt.contains(colorSelected)){
            return true;
        }
        return false;
    }
    
    public void add(Color colorSelected){
        codebreakerAttempt.add(colorSelected);
    }
}
