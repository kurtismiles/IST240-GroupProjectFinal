package panels;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

//@author Kurtis Miles

public class OptionPanel extends JPanel {

    JLabel instructions1, instructions2;

    JButton back, bob, tony, snake, sports, english, movies;

    JPanel north, center, south;

    JPanel p1, p2, p3, p4, p5, p6;

    JPanel iPanel;

    final EmptyBorder space = new EmptyBorder(10, 10, 10, 10);

    public OptionPanel() {

        super();
        BorderLayout border = new BorderLayout();
        setLayout(border);
        setBackground(Color.LIGHT_GRAY);

        //create objects for images
        ImageIcon imageBob = new ImageIcon("images/sideshow_bob.jpeg");
        ImageIcon imageTony = new ImageIcon("images/fat_tony.jpg");
        ImageIcon imageSnake = new ImageIcon("images/snake_jailbird.jpeg");

        //initialize the remaining objects
        instructions1 = new JLabel("Choose Character", JLabel.CENTER);
        instructions2 = new JLabel("Choose Theme", JLabel.CENTER);

        back = new JButton("Click this to go back");
        bob = new JButton(imageBob);
        tony = new JButton(imageTony);
        snake = new JButton(imageSnake);
        sports = new JButton("Sports");
        english = new JButton("English");
        movies = new JButton("Movies");

        north = new JPanel();
        center = new JPanel();
        south = new JPanel();

        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();
        p6 = new JPanel();

        //set layouts
        north.setLayout(new GridLayout(1, 4));
        south.setLayout(new GridLayout(1, 5));
        center.setLayout(new GridLayout(3, 2));

        p1.setLayout(new GridLayout(1, 2));
        p2.setLayout(new GridLayout(1, 2));
        p3.setLayout(new GridLayout(1, 2));
        p4.setLayout(new GridLayout(1, 2));
        p5.setLayout(new GridLayout(1, 2));
        p6.setLayout(new GridLayout(1, 2));

        //empty space around p1 through p6
        p1.setBorder(space);
        p2.setBorder(space);
        p3.setBorder(space);
        p4.setBorder(space);
        p5.setBorder(space);
        p6.setBorder(space);

        //add buttons to p1 through p6
        p1.add(new JPanel());
        p1.add(bob);
        bob.setBackground(Color.blue);

        p2.add(new JPanel());
        p2.add(tony);
        tony.setBackground(Color.black);

        p3.add(new JPanel());
        p3.add(snake);
        snake.setBackground(Color.white);

        p4.add(sports);
        p4.add(new JPanel());

        p5.add(english);
        p5.add(new JPanel());

        p6.add(movies);
        p6.add(new JPanel());

        //add p1 through p6 to center panel
        center.add(p1);
        center.add(p4);
        center.add(p2);
        center.add(p5);
        center.add(p3);
        center.add(p6);

        //add back button to south panel
        south.add(new JPanel());
        south.add(new JPanel());
        south.add(back);
        south.add(new JPanel());
        south.add(new JPanel());

        //add instructions label to north panel
        north.add(new JPanel());
        north.add(instructions1);
        north.add(instructions2);
        north.add(new JPanel());

        //add north, center, and south panel to OptionPanel
        add(north, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        add(south, BorderLayout.SOUTH);

    }

}
