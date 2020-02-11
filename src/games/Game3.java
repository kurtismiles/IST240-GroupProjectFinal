package games;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import panels.ControlPanel;

//@author Kurtis Miles

public class Game3 extends JPanel implements ActionListener, KeyListener {

    //objects for button, progress bar, and timer
    public JButton b1, over;
    public JProgressBar pbVertical;
    public Timer gameTime;

    //character and theme choice objects
    int charChoice, themeChoice;

    //variables for game timer
    int delay = 1000;
    int s = 60;

    //b1 width and length
    int width = 50;
    int length = 50;

    //initial position of b1
    int x = 550;
    int y = 225;
    
    //tracks if the game has started and/or ended
    boolean gameStart, gameOver;
    
    //image objects
    ImageIcon tony, snake, bob;
    
    //fonts used
    final Font defaultFont = new Font("Default", Font.PLAIN, 12);
    final Font bigFont = new Font("BigFont", Font.PLAIN, 25);

    public Game3(int character, int theme) {
        super();
        setBackground(Color.BLACK);
        setLayout(null);

        charChoice = character;
        themeChoice = theme;

        tony = new ImageIcon("images/smallTony.jpg");
        snake = new ImageIcon("images/smallSnake.jpg");
        bob = new ImageIcon("images/smallBob.jpg");

        //adds listener for keyboard
        setFocusable(true);
        addKeyListener(this);

        //setup b1 and make it unfocusable so our keyboard input always works
        b1 = new JButton();
        add(b1);
        b1.setBounds(x, y, width, length);
        b1.setFocusable(false);

        //setup progress bar
        pbVertical = new JProgressBar(JProgressBar.VERTICAL, 0, s);
        pbVertical.setBounds(new Rectangle(1144, 22, 50, 549));
        pbVertical.setBackground(Color.LIGHT_GRAY);

        //changes picture on button based on character chosen
        if (charChoice == 1) {
            b1.setBackground(new Color(39, 124, 189, 255));
            b1.setIcon(bob);
        } else if (charChoice == 2) {
            b1.setBackground(Color.black);
            b1.setIcon(tony);
        } else if (charChoice == 3) {
            b1.setBackground(Color.white);
            b1.setIcon(snake);
        }

        //changes color of progess bar based on theme
        if (themeChoice == 1) {
            pbVertical.setForeground(Color.red);
        } else if (themeChoice == 2) {
            pbVertical.setForeground(Color.cyan);
        } else if (themeChoice == 3) {
            pbVertical.setForeground(Color.green);
        }

        add(pbVertical);

        //create timer
        gameTime = new Timer(delay, this);

        gameStart = false;
        gameOver = false;
        
        //game over button in top right
        over = new JButton("End Game");
        over.setBounds(1100, 0, 100, 20);
        over.setBackground(Color.BLACK);
        over.setForeground(Color.WHITE);
        over.setBorderPainted(false);
        add(over);
        

    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.setColor(Color.WHITE);

        //paints score and time at top left
        g.drawString("time = " + ControlPanel.getTime(), 15, 15);
        g.drawString("score = " + ControlPanel.getScore(), 105, 15);
        g.drawLine(0, 20, 1200, 20);

        //game start text
        if (!gameStart) {
            g.drawString("Press Spacebar to start the game", 10, 535);
            g.drawString("You have 60 seconds to keep clicking on the button"
                    + " to score", 10, 555);
        }

        //game over text
        if (gameOver) {
            g.setFont(bigFont);
            g.drawString("Game Over!", 540, 260);
        }

        requestFocusInWindow();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();

        //happens every tick of the timer
        if (obj == gameTime) {

            //decrease second count and delay
            //decreasing delay means the ticks of the counter are not a second
            s = s - 1;
            delay = delay - 10;

            //set the delay and the value of the progress bar
            gameTime.setDelay(delay);
            pbVertical.setValue(s);

            //when the timer reaches 0
            if (s == 0) {

                //stop timer and remove b1
                gameTime.stop();
                b1.removeActionListener(this);
                remove(b1);

                //make gameover true
                gameOver = true;

                validate();
                repaint();

            }

        }

        //during the game when button one is clicked
        if (obj == b1) {

            //increase score
            ControlPanel.setScore(ControlPanel.getScore() + 2);

            //decrease button size by one on each side until they are 6
            if (width > 6) {
                width = width - 1;
            }
            if (length > 6) {
                length = length - 1;
            }

            //reset the button to a random x,y within the play area and resize
            b1.setBounds(randomX(), randomY(), width, length);

            repaint();

        }

    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        //when space key is pressed
        int kv = e.getKeyCode();
        if (kv == e.VK_SPACE) {

            //start timer
            gameTime.start();
            gameStart = true;

            //listen to button
            b1.addActionListener(this);

            //repaint 
            repaint();

        }

    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }

    //method to create a random x value between 0 and 1094
    public int randomX() {

        double d = (Math.random() * 1095);
        int i = (int) d;
        return i;

    }

    //method to create a random y value between 23 and 521
    public int randomY() {

        double d = 23 + (Math.random() * 498);
        int i = (int) d;
        return i;

    }

}
