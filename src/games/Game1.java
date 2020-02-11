package games;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import panels.ControlPanel;

//@author Kurtis Miles

public class Game1 extends JPanel implements ActionListener, KeyListener {

    public JButton over;
    JTextField text;

    //game timer
    Timer gameTime;

    //objects for character and theme choice
    int charChoice, themeChoice;

    //booleans for tracking game state and input state
    boolean upMove, downMove, gameStart, gameOver;

    //ints for tracking paddle/ball position and ball speed
    int paddleX, paddleY, ballX, ballY, bvelX, bvelY;

    //double for paddleVel, random num gen
    double paddleVel, rand;

    //fonts used, consider adding to control panel instead
    final Font defaultFont = new Font("Default", Font.PLAIN, 12);
    final Font bigFont = new Font("BigFont", Font.PLAIN, 25);

    public Game1(int character, int theme) {

        super();
        setBackground(Color.BLACK);
        setLayout(null);

        //character choice/theme need to be implemented
        charChoice = character;
        themeChoice = theme;

        //adds listener for keyboard
        setFocusable(true);
        addKeyListener(this);

        //end game button in top right
        over = new JButton("End Game");
        over.setBounds(1100, 0, 100, 20);
        over.setBackground(Color.BLACK);
        over.setForeground(Color.WHITE);
        over.setBorderPainted(false);
        add(over);

        //game timer
        gameTime = new Timer(10, this);

        //paddle starting position
        paddleX = 100;
        paddleY = 250;

        //ball starting position
        ballX = 575;
        ballY = 275;

        //ball speed in number of pixels. Cannot exceed 10 or -10
        bvelX = -2;
        bvelY = 2;

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);

        //tracks time and score in top left
        g.drawString("time = " + ControlPanel.getTime(), 15, 15);
        g.drawString("score = " + ControlPanel.getScore(), 105, 15);
        g.drawLine(0, 20, 1200, 20);

        //text displayed before game is started
        if (!gameStart) {
            g.drawString("Press Spacebar to start the game", 10, 535);
            g.drawString("Last as long as you can without the ball"
                    + " touching the left side of the screen", 10, 555);
        }

        //text displayed when game ends
        if (gameOver) {
            g.setFont(bigFont);
            g.drawString("Game Over!", 540, 260);
        }

        //paints the paddle
        g.fillRect(paddleX, paddleY, 10, 100);

        //changes color of ball based on theme
        if (themeChoice == 1) {
            g.setColor(Color.red);
        } else if (themeChoice == 2) {
            g.setColor(Color.cyan);
        } else if (themeChoice == 3) {
            g.setColor(Color.green);
        }

        //paints the ball
        g.fillOval(ballX, ballY, 24, 24);

        requestFocusInWindow();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();

        //this is the game engine, animates the game
        //repaints the screen every 10 ms when game is started
        if (obj == gameTime) {

            //move the ball
            ballX += bvelX;
            ballY += bvelY;

            //check paddle collision
            if (ballX <= 114 && ballX >= 104) {
                if (ballY >= paddleY && ballY <= paddleY + 100) {

                    //if paddle hits ball reverse direction, ++speed, +10 score
                    bvelX *= -1;

                    rand = Math.random();

                    if (rand < 0.49) {
                        if (bvelX > 0) {
                            ++bvelX;
                        } else if (bvelX < 0) {
                            --bvelX;
                        }
                    }
                    if (rand > 0.49) {
                        if (bvelY > 0) {
                            ++bvelY;
                        } else if (bvelY < 0) {
                            --bvelY;
                        }
                    }

                    ControlPanel.setScore(ControlPanel.getScore() + 20);
                }

            }
            //if ball hits left wall end the game
            if (ballX <= 0) {

                gameTime.stop();
                gameOver = true;
            }

            //if ball hits the right wall reverse its direction
            if (ballX >= 1168) {
                bvelX *= -1;
            }

            //if ball hits top or bottom wall reverse its directions
            if (ballY <= 20 || ballY >= 548) {
                bvelY *= -1;
            }

            //give paddle upward velocity if up key is pressed
            if (upMove && !downMove) {
                if ((int) paddleVel >= -10) {
                    paddleVel -= 1.5;
                } else {
                    paddleVel = -10;
                }
            } //give paddle downward velocity if down key is pressed
            else if (!upMove && downMove) {
                if ((int) paddleVel <= 10) {
                    paddleVel += 1.5;
                } else {
                    paddleVel = 10;
                }
            } //If no input or both inputs reduce paddleVel by 0.95 coefficient
            else if ((upMove && downMove) || (!upMove && !downMove)) {
                paddleVel *= .95;
            }

            //if the paddle has velocity
            if ((int) paddleVel != 0) {

                //move it
                paddleY += (int) paddleVel;

                //if the paddle hits the top stop and remove all velocity
                if (paddleY < 20) {
                    paddleY = 20;
                    paddleVel = 0;

                }

                //if the paddle hits the bottom stop it and remove all velocity
                if (paddleY > 473) {
                    paddleY = 473;
                    paddleVel = 0;

                }

            }

            repaint();
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int k = e.getKeyCode();

        //start game
        if (k == e.VK_SPACE) {
            gameTime.start();
            gameStart = true;

            //if up or down are pressed set true
        } else if (k == e.VK_UP) {
            upMove = true;
        } else if (k == e.VK_DOWN) {
            downMove = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int kv = e.getKeyCode();

        //if up or down are released set false
        if (kv == e.VK_UP) {
            upMove = false;
        }
        if (kv == e.VK_DOWN) {
            downMove = false;
        }
    }

}
