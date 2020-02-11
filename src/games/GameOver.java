package games;

import java.awt.*;
import javax.swing.*;
import panels.ControlPanel;
import xml.XML_240;

//@author Kurtis Miles

public class GameOver extends JPanel {
    
    XML_240 x;
    
    public JButton back;
    
    JButton contrast;
    
    JLabel currentName, currentScore, currentTime, lastName1, lastScore1, lastTime1,
            lastName2, lastScore2, lastTime2;
    
    JLabel label1, label2, label3;
    
    String [] played1, played2, played3;

    int charChoice, themeChoice;
    
    ImageIcon tonyGO = new ImageIcon("images/tonyGameOver.jpg");
    ImageIcon snakeGO = new ImageIcon("images/snakeGameOver.jpg");
    ImageIcon bobGO = new ImageIcon("images/bobGameOver.jpg");
    
    Image bob = bobGO.getImage();
    Image tony = tonyGO.getImage();
    Image snake = snakeGO.getImage();
    
    Font labelFont = new Font("label", Font.BOLD, 16);
    Font defaultFont = new Font("default", Font.PLAIN, 12);

    public GameOver(int character, int theme) {

        super();
        
        setLayout(null); 
        setBackground(Color.LIGHT_GRAY);

        charChoice = character;
        themeChoice = theme;

        //reads last three played from Played File
        x = new XML_240();
        x.openReaderXML("Played");
        played3 = (String[]) x.ReadObject();
        played2 = (String[]) x.ReadObject();
        played1 = (String[]) x.ReadObject();
        x.closeReaderXML();
        
        //sets up labels using last three played information
        label1 = new JLabel("Current Game");
        label1.setFont(labelFont);
        label1.setForeground(Color.WHITE);
        label2 = new JLabel("Last Game");
        label2.setFont(labelFont);
        label2.setForeground(Color.WHITE);
        label3 = new JLabel("Second Last Game");
        label3.setFont(labelFont);
        label3.setForeground(Color.WHITE);
        
        currentName = new JLabel("Character: " + played1 [0]);
        currentName.setFont(defaultFont);
        currentName.setForeground(Color.WHITE);
        currentScore = new JLabel("Score: " + played1 [1]);
        currentScore.setFont(defaultFont);
        currentScore.setForeground(Color.WHITE);
        currentTime = new JLabel("Time: " + played1 [2]);
        currentTime.setFont(defaultFont);
        currentTime.setForeground(Color.WHITE);
        
        lastName1 = new JLabel("Character: " + played2 [0]);
        lastName1.setFont(defaultFont);
        lastName1.setForeground(Color.WHITE);
        lastScore1 = new JLabel("Score: " + played2 [1]);
        lastScore1.setFont(defaultFont);
        lastScore1.setForeground(Color.WHITE);
        lastTime1 = new JLabel("Time: " + played2 [2]);
        lastTime1.setFont(defaultFont);
        lastTime1.setForeground(Color.WHITE);
        
        lastName2 = new JLabel("Character: " + played3 [0]);
        lastName2.setFont(defaultFont);
        lastName2.setForeground(Color.WHITE);
        lastScore2 = new JLabel("Score: " + played3 [1]);
        lastScore2.setFont(defaultFont);
        lastScore2.setForeground(Color.WHITE);
        lastTime2 = new JLabel("Time: " + played3 [2]); 
        lastTime2.setFont(defaultFont);
        lastTime2.setForeground(Color.WHITE);
        
        //adds back button and contrast button that is used for a background
        back = new JButton("Click this to go back");
        contrast = new JButton("");
        contrast.setBackground(Color.BLACK);
        contrast.setEnabled(false);
         
        //adds everything to panel
        add(label1);
        add(label2);
        add(label3);
        
        add(currentName);
        add(currentScore);
        add(currentTime);
        
        add(lastName1);
        add(lastScore1);
        add(lastTime1);
        
        add(lastName2);
        add(lastScore2);
        add(lastTime2);
        
        add(back);
        add(contrast);
        
        //repositions
        contrast.setBounds(45, 100, 155, 300);
        back.setBounds(45, 400, 155, 25);
        label1.setBounds(50, 100, 200, 25);
        label2.setBounds(50, 200, 200, 25);
        label3.setBounds(50, 300, 200, 25);
        
        currentName.setBounds(50, 120, 200, 25);
        currentScore.setBounds(50, 140, 200, 25);
        currentTime.setBounds(50, 160, 200, 25);
        
        lastName1.setBounds(50, 220, 200, 25);
        lastScore1.setBounds(50, 240, 200, 25);
        lastTime1.setBounds(50, 260, 200, 25);
        
        lastName2.setBounds(50, 320, 200, 25);
        lastScore2.setBounds(50, 340, 200, 25);
        lastTime2.setBounds(50, 360, 200, 25);
      

    }
    
    
    //paints a different background depending on last character played
    @Override
        public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        if (charChoice == 1)
        {
            g.drawImage(bob, 0, 0, this);
        }
        else if (charChoice == 2)
        {
            g.drawImage(tony, 0, 0, this);
        }
        else 
        {
            g.drawImage(snake, 0, 0, this);     
        }

    }
    
    
    
    
}
