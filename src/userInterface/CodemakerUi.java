/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import core.Codemaker;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import userinterface.RoundButton;

/**
 *
 * @author ponyt
 */
public class CodemakerUi {
    private JPanel codemakerResponse;
    private JPanel secretCode;
    Codemaker codemaker;
    JLabel[] secretLabels;
    JLabel[][] responseLabels;
    ImageIcon question;
    JButton check;
    private boolean checkClicked;
    int i;
    int j;

    public CodemakerUi(Codemaker newCode){
        codemaker = newCode;
        initComponents();
    }
    
    private ImageIcon imageResize(ImageIcon icon)
    {
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImage);
        return icon;
    }
    
    public void initComponents(){
        codemakerResponse = new JPanel();
        secretCode = new JPanel();
        codemakerResponse.setMinimumSize(new Dimension(150,200));
        secretCode.setMinimumSize(new Dimension(400,65));
        codemakerResponse.setPreferredSize(new Dimension(150,200));
        secretCode.setPreferredSize(new Dimension(400,65));
        codemakerResponse.setBorder(BorderFactory.createTitledBorder("Codemaker "
        + "Response")); 
        secretCode.setBorder(BorderFactory.createTitledBorder("Secret Code"));
        secretCode.setLayout(new FlowLayout());
        codemakerResponse.setLayout(new GridLayout(10,4));
        JLabel[] secretLabels = new JLabel[4];
        // ask for help with getClass() and getResource()
        question = new ImageIcon("src/images/question.jpg");
        
        for(JLabel label : secretLabels){
            label = new JLabel();
            ImageIcon newPic = imageResize(question);
            label.setIcon(newPic);
            secretCode.add(label);
        }
        check = new JButton("Check");
        check.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    checkClicked = true;
                }});
        secretCode.add(check);
        
        
        responseLabels = new JLabel[10][4];
        for(i = 0; i < 10; i++){
            for(j = 0; j < 4; j++){
                responseLabels[i][j] = new JLabel();
                responseLabels[i][j].setOpaque(true);
                responseLabels[i][j].setBackground(Color.GRAY);
                responseLabels[i][j].setBorder(BorderFactory.
                createBevelBorder(1));
                codemakerResponse.add(responseLabels[i][j]);
            }
        }
    }
    
    public void displaySecretCode(){
        int l;
        RoundButton Button;
        secretCode.removeAll();
        JLabel codeCheck = new JLabel("The secret code was");
        secretCode.add(codeCheck);
        ArrayList<Color> secritCode = new ArrayList<Color>(Codemaker.getSecretCode());
        for(l = 0; l < secritCode.size();l++){
            Color color = secritCode.get(l);
            Button = new RoundButton();
            Button.setBackground(color);
            secretCode.add(Button);
        }
        secretCode.revalidate();
        secretCode.repaint();
    }
    
    public void displayCodemakerResponse(int row){
        int l;
        ArrayList<Color> response = new ArrayList<Color>(Codemaker.getCodemakerResponse());
        for(l = 0; l < response.size();l++){
            Color color = response.get(l);
            if(color != null){
                responseLabels[row][l].setBackground(color);
            }
        }
        response.clear();
    }
    
    /**
     * @return the codemakerResponse
     */
    public JPanel getCodemakerResponse() {
        return codemakerResponse;
    }

    /**
     * @return the secretCode
     */
    public JPanel getSecretCode() {
        return secretCode;
    }

    /**
     * @return the checkClicked
     */
    public boolean isCheckClicked() {
        return checkClicked;
    }

    /**
     * @param checkClicked the checkClicked to set
     */
    public void setCheckClicked(boolean checkClicked) {
        this.checkClicked = checkClicked;
    }

    public void setCheck(boolean enabled){
        check.setEnabled(enabled);
    }
}
