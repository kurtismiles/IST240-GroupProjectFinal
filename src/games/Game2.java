package games;

import xml.XML_240;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import panels.ControlPanel;

//@author Wes Brouillette

public class Game2 extends JPanel implements ActionListener {
    
    XML_240 x;
    
    public JButton over, b1, b2, b3;
    public JButton a1, a2, a3, a4;
    public JPanel j1;
    public Timer gameTime;
    public JLabel testQuestion = new JLabel("");
    public JLabel gameOver = new JLabel("Game Over");

    public int charChoice, themeChoice, currentQuestion;

    String[] questions;
    String[] answers;
    String[][] wrong;

    String[] sportsQuestions;
    String[] sportsAnswers;
    String[][] sportsWrong;
    String[] englishQuestions;
    String[] englishAnswers;
    String[][] englishWrong;
    String[] movieQuestions;
    String[] movieAnswers;
    String[][] movieWrong;
    
    public Game2(int character, int theme) {

        super();

        setLayout(null);
        setBackground(Color.WHITE);

        j1 = new JPanel();
        j1.setBounds(300, 25, 750, 300);
        j1.setBackground(Color.WHITE);

        gameTime = new Timer(10, this);

        currentQuestion = 0;

        //pull player images for the game 
        ImageIcon imageBob = new ImageIcon("images/sideshow_bob.jpeg");
        ImageIcon imageTony = new ImageIcon("images/fat_tony.jpg");
        ImageIcon imageSnake = new ImageIcon("images/snake_jailbird.jpeg");
        ImageIcon player = new ImageIcon();
        charChoice = character;
        themeChoice = theme;

        //populate String[] variables with XML file Game 2
        x = new XML_240();
        x.openReaderXML("Game 2");
        sportsQuestions = (String[]) x.ReadObject();
        sportsAnswers = (String[]) x.ReadObject();
        sportsWrong = (String[][]) x.ReadObject();
        englishQuestions = (String[]) x.ReadObject();
        englishAnswers = (String[]) x.ReadObject();
        englishWrong = (String[][]) x.ReadObject();
        movieQuestions = (String[]) x.ReadObject();
        movieAnswers = (String[]) x.ReadObject();
        movieWrong = (String[][]) x.ReadObject();
        x.closeReaderXML();
        
            
        if (charChoice == 1) {

            player = imageBob;
            b1 = new JButton(imageBob);
            b1.setBounds(0, 25, player.getIconWidth(), player.getIconHeight());
            add(b1);

        } else if (charChoice == 2) {

            player = imageTony;
            b2 = new JButton(imageTony);
            b2.setBounds(0, 25, player.getIconWidth(), player.getIconHeight());
            add(b2);

        } else if (charChoice == 3) {

            player = imageSnake;
            b3 = new JButton(imageSnake);
            b3.setBounds(0, 25, player.getIconWidth(), player.getIconHeight());
            add(b3);

        }

        if (themeChoice == 1) {

            questions = sportsQuestions;
            answers = sportsAnswers;
            wrong = sportsWrong;
            displayQuestion();

        } else if (themeChoice == 2) {

            questions = englishQuestions;
            answers = englishAnswers;
            wrong = englishWrong;
            displayQuestion();

        } else if (themeChoice == 3) {

            questions = movieQuestions;
            answers = movieAnswers;
            wrong = movieWrong;
            displayQuestion();

        }

        over = new JButton("End Game");
        over.setBounds(1100, 0, 100, 20);
        over.setBackground(Color.WHITE);
        over.setForeground(Color.BLACK);
        over.setBorderPainted(false);

        add(j1);

        add(over);

    }

    @Override

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.setColor(Color.BLACK);

        //tracks time and score in top left 
        g.drawString("time = " + ControlPanel.getTime(), 15, 15);
        g.drawString("score = " + ControlPanel.getScore(), 105, 15);

        g.drawLine(0, 20, 1200, 20);

    }

    @Override

    public void actionPerformed(ActionEvent ae) {

        Object obj = ae.getActionCommand();

        if (obj == answers[currentQuestion]) {

            ControlPanel.setScore(ControlPanel.getScore() + 10);

        }

        if (currentQuestion < 11) {

            currentQuestion++;
            displayQuestion();

        } else {

            j1.removeAll();
            j1.add(gameOver);
            j1.revalidate();
            j1.repaint();

        }

    }

    void displayQuestion() {

        j1.removeAll();

        testQuestion = new JLabel(questions[currentQuestion]);
        
        a1 = new JButton(answers[currentQuestion]);
        a2 = new JButton(wrong[currentQuestion][0]);
        a3 = new JButton(wrong[currentQuestion][1]);
        a4 = new JButton(wrong[currentQuestion][2]);

        a1.addActionListener(this);
        a2.addActionListener(this);
        a3.addActionListener(this);
        a4.addActionListener(this);

        j1.add(testQuestion);
        j1.add(a1);
        j1.add(a2);
        j1.add(a3);
        j1.add(a4);

        j1.revalidate();
        j1.repaint();

    }
}
