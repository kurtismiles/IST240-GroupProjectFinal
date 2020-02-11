package panels;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

//@author Victoria Foreman

public class InstructionPanel extends JPanel {

    JButton instructions, back;

    JPanel p1, p2;

    public InstructionPanel() {
        super();
        BorderLayout border = new BorderLayout();
        setLayout(border);
        setBackground(Color.LIGHT_GRAY);

        //initialize objects
        p1 = new JPanel();
        p2 = new JPanel();

        back = new JButton("Click this to go back");
        ImageIcon image = new ImageIcon("images/Instruction_Description.jpg");
        instructions = new JButton();
        instructions.setIcon(image);

        //set p1 and p2 layouts
        p1.setLayout(new BorderLayout());
        p2.setLayout(new GridLayout(1, 5));

        //add objects to p1 and p2
        p1.add(instructions);
        p1.setBorder(new EmptyBorder(10, 125, 10, 125));

        p2.add(new JPanel());
        p2.add(new JPanel());
        p2.add(back);
        p2.add(new JPanel());
        p2.add(new JPanel());

        //add p1 and p2 to Instruction Panel
        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);
    }
}
