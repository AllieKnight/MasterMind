/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import constants.Constants;
import core.Codebreaker;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import userinterface.RoundButton;

/**
 *
 * @author ponyt
 */
public class CodebreakerUi {
    private JPanel codebreakerAttempt;
    private JPanel codebreakerColors;
    Codebreaker codebreaker;
    private RoundButton[] buttons;
    private RoundButton[][] attempts;
    Color colorSelected;
    int i;
    int j;

    public CodebreakerUi(Codebreaker code){
        codebreaker = code;
        initComponents();
    }
    
    public void initComponents(){
        codebreakerAttempt = new JPanel();
        codebreakerColors = new JPanel();
        codebreakerAttempt.setMinimumSize(new Dimension(235,200));
        codebreakerColors.setMinimumSize(new Dimension(400,65));
        codebreakerAttempt.setPreferredSize(new Dimension(235,200));
        codebreakerColors.setPreferredSize(new Dimension(400,65));
        codebreakerAttempt.setBorder(BorderFactory.createTitledBorder("Code"
        + "breaker Attempt")); 
        codebreakerColors.setBorder(BorderFactory.createTitledBorder("Code"
        + "breaker Colors"));
        codebreakerAttempt.setLayout(new GridLayout(10,4));
        attempts = new RoundButton[10][4];
                
        for(i = 0; i < 10; i++){
            for(j = 0; j < 4; j++){
                attempts[i][j] = new RoundButton();
                if(i != 9){
                    attempts[i][j].setEnabled(false);
                }
                attempts[i][j].putClientProperty("row", i);
                attempts[i][j].addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    RoundButton Click = (RoundButton)e.getSource();
                    if(!codebreaker.contains(colorSelected) && codebreaker.
                       size(codebreaker)< 4){
                        Click.setBackground(colorSelected);
                        codebreaker.add(colorSelected);
                    }
                    if(codebreaker.size(codebreaker) == 4){
                        int row = (int)Click.getClientProperty
                        ("row");
                        enableDisableButtons(row);
                    }
                }});
                codebreakerAttempt.add(attempts[i][j]);
            }
        }
        
        RoundButton[] colors = new RoundButton[8];
        i = 0;
        for(RoundButton button : colors){
            button = new RoundButton();
            Color buttonColor = new Color(0,0,0);
            buttonColor = Constants.codeColors.get(i);
            button.setBackground(buttonColor);
            button.putClientProperty("color", buttonColor);
            button.setToolTipText(buttonColor.toString());
            button.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    RoundButton click = (RoundButton)e.getSource();
                    colorSelected = (Color)click.getClientProperty("color");
                }});
            codebreakerColors.add(button);
            i++;
        }
    }
    
    private void enableDisableButtons(int currRow){
        if(currRow != 0){
            for(int k = 0; k < 4; k++){
                attempts[currRow][k].setEnabled(false);
                attempts[currRow-1][k].setEnabled(true);
            }
        }
    }
    
    /**
     * @return the codebreakerAttempt
     */
    public JPanel getCodebreakerAttempt() {
        return codebreakerAttempt;
    }


    /**
     * @return the codebreakerColors
     */
    public JPanel getCodebreakerColors() {
        return codebreakerColors;
    }
    
    

}
