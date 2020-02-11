package panels;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

//@author Kurtis Miles

public class CreditPanel extends JPanel {

    JButton about, back;

    JPanel p1, p2;

    public CreditPanel() {
        super();
        setLayout(new BorderLayout());
        setBackground(Color.LIGHT_GRAY);

        //initialize objects
        p1 = new JPanel();
        p2 = new JPanel();
        back = new JButton("Click this to go back");
        ImageIcon image = new ImageIcon("images/About and Credits b.jpg");
        about = new JButton(image);

        //set p1 and p2 layouts
        p1.setLayout(new BorderLayout());
        p2.setLayout(new GridLayout(1, 5));

        //add objects to p1 and p2
        p1.add(about);
        p1.setBorder(new EmptyBorder(10, 125, 10, 125));

        p2.add(new JPanel());
        p2.add(new JPanel());
        p2.add(back);
        p2.add(new JPanel());
        p2.add(new JPanel());

        //add p1 and p2 to CreditPanel
        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);
    }
}
