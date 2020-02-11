package panels;

import games.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;
import xml.XML_240;

//@author Kurtis Miles

public class ControlPanel extends JPanel implements ActionListener {

    IntroPanel intro;
    CreditPanel credits;
    InstructionPanel instructions;
    OptionPanel options;
    MapPanel map;

    Game1 game1;
    Game2 game2;
    Game3 game3;
    GameOver over;

    public static int character, theme, score, time = 0;

    boolean played1, played2, played3;

    Timer timer;

    JLabel timeLabel, scoreLabel;

    final Border defaultBorder = (new JButton()).getBorder();
    final Border clickedBorder = (BorderFactory.createMatteBorder(5, 5, 5, 5, Color.green));

    public ControlPanel() {
        super();
        GridLayout grid = new GridLayout(1, 1);
        setLayout(grid);
        setBackground(Color.DARK_GRAY);

        //prepares games and map panel separately
        prepGames();

        //initialize all panels except those used for games
        intro = new IntroPanel();
        intro.setOpaque(true);
        credits = new CreditPanel();
        instructions = new InstructionPanel();
        options = new OptionPanel();

        //initialize the timer
        //add listeners to all buttons used except for games
        intro.b1.addActionListener(this);
        intro.b2.addActionListener(this);
        intro.b3.addActionListener(this);
        intro.b4.addActionListener(this);

        credits.back.addActionListener(this);
        instructions.back.addActionListener(this);
        options.bob.addActionListener(this);
        options.tony.addActionListener(this);
        options.snake.addActionListener(this);
        options.sports.addActionListener(this);
        options.english.addActionListener(this);
        options.movies.addActionListener(this);
        options.back.addActionListener(this);

        //add intro panel to ControlPanel
        add(intro);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        Object obj = ae.getSource();

        //timer
        if (obj == timer) {

            ++time;
            timeLabel.setText("time = " + time);

            validate();
            repaint();
        }

        //main navigation buttons
        if (obj == intro.b1) {

            remove(intro);
            add(credits);
            validate();
            repaint();

        }

        if (obj == intro.b2) {

            remove(intro);
            add(instructions);
            validate();
            repaint();

        }

        if (obj == intro.b3) {

            remove(intro);
            add(options);
            validate();
            repaint();

        }

        if (obj == intro.b4) {

            //if character or theme arent selected print error message
            if ((character == 0) || (theme == 0)) {

                System.out.println("Error: Character/Theme not properly selected");
            }

            //otherwise proceed to map
            if (!(character == 0) && !(theme == 0)) {
                timer.start();
                remove(intro);
                add(map);
                validate();
                repaint();

            }

        }

        //back buttons for all except GameOver
        if (obj == credits.back) {

            remove(credits);
            add(intro);
            validate();
            repaint();

        }

        if (obj == instructions.back) {

            remove(instructions);
            add(intro);
            validate();
            repaint();

        }

        if (obj == options.back) {

            remove(options);
            add(intro);
            validate();
            repaint();

        }

        if (obj == map.back) {

            remove(map);
            add(intro);
            validate();
            repaint();
            timer.stop();

        }

        //option buttons for character and theme selection
        if (obj == options.bob) {
            character = 1;
            options.bob.setBorder(clickedBorder);
            options.tony.setBorder(defaultBorder);
            options.snake.setBorder(defaultBorder);
            prepGames();

        }

        if (obj == options.tony) {
            character = 2;
            options.tony.setBorder(clickedBorder);
            options.bob.setBorder(defaultBorder);
            options.snake.setBorder(defaultBorder);
            prepGames();
        }

        if (obj == options.snake) {
            character = 3;
            options.snake.setBorder(clickedBorder);
            options.bob.setBorder(defaultBorder);
            options.tony.setBorder(defaultBorder);
            prepGames();
        }

        if (obj == options.sports) {
            theme = 1;
            options.sports.setBorder(clickedBorder);
            options.english.setBorder(defaultBorder);
            options.movies.setBorder(defaultBorder);
            prepGames();
        }

        if (obj == options.english) {
            theme = 2;
            options.english.setBorder(clickedBorder);
            options.sports.setBorder(defaultBorder);
            options.movies.setBorder(defaultBorder);
            prepGames();
        }

        if (obj == options.movies) {
            theme = 3;
            options.movies.setBorder(clickedBorder);
            options.english.setBorder(defaultBorder);
            options.sports.setBorder(defaultBorder);
            prepGames();

        }

        //these are the game buttons in MapPanel
        if (obj == map.b1) {

            if (!played1) {
                played1 = true;
                remove(map);
                add(game1);
                game1.requestFocusInWindow();
                validate();
                repaint();
            } else if (played1) {
                System.out.println("You`ve already played Game 1!");
            }
        }

        if (obj == map.b2) {

            if (!played2) {
                played2 = true;
                remove(map);
                add(game2);
                game2.requestFocusInWindow();
                validate();
                repaint();
            } else if (played2) {
                System.out.println("You`ve already played Game 2!");
            }
        }

        if (obj == map.b3) {

            if (!played3) {
                played3 = true;
                remove(map);
                add(game3);
                game3.requestFocusInWindow();
                validate();
                repaint();
            } else if (played3) {
                System.out.println("You`ve already played played Game 3!");
            }
        }

        //these are the force game over buttons, checks if all games are played
        //if all games are played, show the GameOver screen and reset
        if (obj == game1.over) {

            if (played2 && played3) {
                timer.stop();
                remove(game1);
                stampScore();
                over = new GameOver(character, theme);
                over.back.addActionListener(this);
                add(over);
            } else if (!played2 || !played3) {
                scoreLabel.setText("score = " + score);
                remove(game1);
                add(map);
            }

            //reset game
            game1 = new Game1(character, theme);

            validate();
            repaint();

        }

        if (obj == game2.over) {

            if (played1 && played3) {
                timer.stop();
                remove(game2);
                stampScore();
                over = new GameOver(character, theme);
                over.back.addActionListener(this);
                add(over);
            } else if (!played1 || !played3) {
                scoreLabel.setText("score = " + score);
                remove(game2);
                add(map);
            }

            game2 = new Game2(character, theme);

            validate();
            repaint();

        }

        if (obj == game3.over) {

            if (played1 && played2) {
                timer.stop();
                remove(game3);
                stampScore();
                over = new GameOver(character, theme);
                over.back.addActionListener(this);
                add(over);
            } else if (!played1 || !played2) {
                scoreLabel.setText("score = " + score);
                remove(game3);
                add(map);
            }

            game3 = new Game3(character, theme);

            validate();
            repaint();

        }

        //this is the back button for gameover; resets and sends to intro panel
        if (obj == over.back) {

            remove(over);
            add(intro);

            options.bob.setBorder(defaultBorder);
            options.tony.setBorder(defaultBorder);
            options.snake.setBorder(defaultBorder);

            options.sports.setBorder(defaultBorder);
            options.english.setBorder(defaultBorder);
            options.movies.setBorder(defaultBorder);

            character = 0;
            theme = 0;
            time = 0;
            score = 0;

            played1 = false;
            played2 = false;
            played3 = false;

            prepGames();

            validate();
            repaint();

        }

    }

    /*This needs to be a seperate method. Games and MapPanel may change
     when new choices are selected for theme and character in the OptionPanel*/
    private void prepGames() {

        //sets up timer and timer/score trackers
        score = 0;
        time = 0;
        timer = new Timer(1000, this);
        timeLabel = new JLabel("time = " + time);
        scoreLabel = new JLabel("score = " + score);

        //resets game played
        played1 = false;
        played2 = false;
        played3 = false;

        //creates game objects
        map = new MapPanel(character, theme, timeLabel, scoreLabel);
        game1 = new Game1(character, theme);
        game2 = new Game2(character, theme);
        game3 = new Game3(character, theme);
        over = new GameOver(character, theme);

        //add listeners
        map.back.addActionListener(this);
        map.b1.addActionListener(this);
        map.b2.addActionListener(this);
        map.b3.addActionListener(this);
        game1.over.addActionListener(this);
        game2.over.addActionListener(this);
        game3.over.addActionListener(this);
        over.back.addActionListener(this);

    }

    //getter and setter methods for time and score
    public static int getTime() {
        return (time);
    }

    public static void setTime(int inputTime) {
        time = inputTime;
    }

    public static int getScore() {
        return (score);
    }

    public static void setScore(int inputScore) {
        score = inputScore;
    }

    //stamps the final character, score, and time to the Played xml file
    public static void stampScore() {

        String characterName = new String("");
        String finalScore = Integer.toString(score);
        String finalTime = Integer.toString(time);

        if (character == 1) {
            characterName = "Bob";
        } else if (character == 2) {
            characterName = "Tony";
        } else if (character == 3) {
            characterName = "Snake";
        }

        String[] finalRanking = new String[]{characterName,
            finalScore, finalTime};

        XML_240 x = new XML_240();

        //three variables track last three players from Rankings XML file
        x.openReaderXML("Played");
        String[] firstPlayed = (String[]) x.ReadObject();
        String[] secondPlayed = (String[]) x.ReadObject();
        String[] thirdPlayed = (String[]) x.ReadObject();
        x.closeReaderXML();

        //rewrite XML file with last three players, drops first player
        x.openWriterXML("Played");
        x.writeObject(secondPlayed);
        x.writeObject(thirdPlayed);
        x.writeObject(finalRanking);
        x.closeWriterXML();

    }

}
