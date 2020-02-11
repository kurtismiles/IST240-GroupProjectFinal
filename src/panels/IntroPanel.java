package panels;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

//@author Kurtis Miles

public class IntroPanel extends JPanel {
    
    ImageIcon imageCredits, imageInstruct, imageMap,imageOptions;
    
    JButton b1, b2, b3, b4;

    JPanel p0, p1, p2, p3, p4;

    final EmptyBorder space = new EmptyBorder(25, 25, 25, 25);

    public IntroPanel() {
        super();
        setBackground(Color.LIGHT_GRAY);

        //creates images to be added to JButtons
        imageCredits = new ImageIcon("images/credits.jpg");
        imageInstruct = new ImageIcon("images/instructions.jpg");
        imageMap = new ImageIcon("images/map.jpg");
        imageOptions = new ImageIcon("images/options.jpg");

        //creates JButtons using images
        b1 = new JButton(imageCredits);
        b2 = new JButton(imageInstruct);
        b3 = new JButton(imageOptions);
        b4 = new JButton(imageMap);

        //initializes panels 0 through 4
        p0 = new JPanel();
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();

        //set panel layouts
        setLayout(new BorderLayout());
        p0.setLayout(new GridLayout(2, 2));

        p1.setLayout(new BorderLayout());
        p2.setLayout(new BorderLayout());
        p3.setLayout(new BorderLayout());
        p4.setLayout(new BorderLayout());

        //add empty space around each button
        p1.setBorder(space);
        p2.setBorder(space);
        p3.setBorder(space);
        p4.setBorder(space);

        //add buttons to panels
        p1.add(b1, BorderLayout.CENTER);
        p2.add(b2, BorderLayout.CENTER);
        p3.add(b3, BorderLayout.CENTER);
        p4.add(b4, BorderLayout.CENTER);

        //add panels to container panel p0
        p0.add(p1);
        p0.add(p2);
        p0.add(p3);
        p0.add(p4);

        //add p0 to IntroPanel
        add(p0);

    }

}
