package panels;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;
import javax.swing.border.Border;

//@author Nick Kenny

public class MapPanel extends JPanel implements MouseListener, MouseMotionListener {

    JButton back, b1, b2, b3, c1, mapTime, mapScore;
    JLabel g1, g2, g3, t1, t2;

    int charChoice, themeChoice;
    ImageIcon tony, snake, bob, charSmall;

    ImageIcon penn = new ImageIcon("images/pennsylvania.jpg");
    Image state = penn.getImage();

    Color opaqueWhite = new Color(255, 255, 255, 200);
    Border clBorder = (BorderFactory.createMatteBorder(5, 5, 5, 5, Color.blue));

    double dx, dy;
    int x, y;

    public MapPanel(int character, int theme, JLabel timeLabel, JLabel scoreLabel) {

        super();

        setLayout(null);
        setBackground(Color.LIGHT_GRAY);

        //image objects
        tony = new ImageIcon("images/smallTony.jpg");
        snake = new ImageIcon("images/smallSnake.jpg");
        bob = new ImageIcon("images/smallBob.jpg");
        charSmall = new ImageIcon();

        //theme not implemented yet
        charChoice = character;
        themeChoice = theme;

        //changes character icon based on choice in options
        if (charChoice == 1) {
            charSmall = bob;
        } else if (charChoice == 2) {
            charSmall = tony;
        } else if (charChoice == 3) {
            charSmall = snake;
        }

        back = new JButton("Click this to go back");
        b1 = new JButton();
        b2 = new JButton();
        b3 = new JButton();

        g1 = new JLabel("Game 1");
        g1.setHorizontalAlignment(JLabel.CENTER);
        g1.setBackground(opaqueWhite);
        g1.setOpaque(true);
        g1.setBounds(410, 226, 50, 15);
        g1.setVisible(false);

        g2 = new JLabel("Game 2");
        g2.setHorizontalAlignment(JLabel.CENTER);
        g2.setBackground(opaqueWhite);
        g2.setOpaque(true);
        g2.setBounds(716, 126, 50, 15);
        g2.setVisible(false);

        g3 = new JLabel("Game 3");
        g3.setHorizontalAlignment(JLabel.CENTER);
        g3.setBackground(opaqueWhite);
        g3.setOpaque(true);
        g3.setBounds(1085, 283, 50, 15);
        g3.setVisible(false);

        add(g1);
        add(g2);
        add(g3);
        add(b1);
        add(b2);
        add(b3);
        add(back);

        c1 = new JButton(charSmall);
        //c1.setVisible(false);
        add(c1);

        t1 = timeLabel;
        t1.setBounds(10, 10, 75, 15);
        t1.setHorizontalAlignment(JLabel.CENTER);
        t1.setBackground(Color.white);
        t1.setOpaque(true);
        add(t1);

        t2 = scoreLabel;
        t2.setBounds(100, 10, 75, 15);
        t2.setHorizontalAlignment(JLabel.CENTER);
        t2.setBackground(Color.white);
        t2.setOpaque(true);
        add(t2);

        b1.setBorderPainted(true);
        b1.setContentAreaFilled(false);
        b1.setOpaque(false);
        b1.setBorder(clBorder);

        b2.setBorderPainted(true);
        b2.setContentAreaFilled(false);
        b2.setOpaque(false);
        b2.setBorder(clBorder);

        b3.setBorderPainted(true);
        b3.setContentAreaFilled(false);
        b3.setOpaque(false);
        b3.setBorder(clBorder);

        b1.setBounds(410, 243, 50, 50);
        b2.setBounds(716, 143, 50, 50);
        b3.setBounds(1085, 300, 50, 50);
        back.setBounds(500, 525, 200, 25);
        c1.setBounds(0, 0, 50, 50);

        b1.addMouseListener(this);
        b2.addMouseListener(this);
        b3.addMouseListener(this);
        addMouseMotionListener(this);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(state, 0, 0, this);

    }

    @Override
    public void mouseMoved(MouseEvent evt) {
        Point pt = evt.getPoint();

        dx = pt.getX();
        dy = pt.getY();

        x = (int) dx;
        y = (int) dy;

        c1.setBounds(new Rectangle(x, y, 50, 50));
        //c1.setVisible(true);
        //validate();
        //repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

        Object obj = e.getSource();

        //put character icon and image at button 1 on mouseover
        if (obj == b1) {
            c1.setBounds(410, 243, 50, 50);
            //c1.setVisible(true);
            g1.setVisible(true);
            g2.setVisible(false);
            g3.setVisible(false);
            validate();
            repaint();
        }

        //put character icon and image at button 2 on mouseover
        if (obj == b2) {

            c1.setBounds(716, 143, 50, 50);
            //c1.setVisible(true);
            g2.setVisible(true);
            g1.setVisible(false);
            g3.setVisible(false);
            validate();
            repaint();
        }

        //put character icon and image at button 3 on mouseover
        if (obj == b3) {

            c1.setBounds(1085, 300, 50, 50);
            //c1.setVisible(true);
            g3.setVisible(true);
            g1.setVisible(false);
            g2.setVisible(false);
            validate();
            repaint();
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        {
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
