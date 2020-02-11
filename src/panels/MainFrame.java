package panels;

import javax.swing.*;

//@author Kurtis Miles

public class MainFrame extends JFrame {

    ControlPanel control;
    
    public MainFrame() {
        super("Mainframe");
        MacLayoutSetup();
        control = new ControlPanel();
        getContentPane().add(control, "Center");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 600);
        setResizable(false);
        setVisible(true);
    }

    public void MacLayoutSetup() {
        // On some MACs it might be necessary to have the statement below 
        //for the background color of the button to appear 
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
