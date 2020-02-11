package xml;


import xml.XML_240;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;


//This class writes the information used in XML file for game 2.
//@author Kurtis Miles

public class WriteGame2 {

    XML_240 x;
    
        final String[] sportsQuestions = new String[]{
        "What is the diameter of a basketball hoop?",
        "Which famous Miami Dolphins Quarterback retired in 2003?",
        "Which fictitious sport is played in the Harry Potter books?",
        "Which sport did Kareem Abdul Jabbar play?",
        "Which sport is held on Memorial Day?",
        "How many ground referees are there in football?",
        "The Olympic Flag has how many rings?",
        "Which sport does not have a game clock/timer?",
        "Which city has a team nicked named 'The Bronx Bombers'?",
        "What collage has the chant 'We Are...'?",
        "Which country hosted the 2008 Olympics?",
        "How many points is a touchdown worth?"

    };
        
    final String[] sportsAnswers = new String[]{
        "18 inches",
        "Dan Marino",
        "Quidditch",
        "Basketball",
        "Indianapolis 500",
        "1",
        "5",
        "Baseball",
        "New York City",
        "Penn State",
        "China",
        "6",};

    final String[][] sportsWrong = {
        {"10 inches", "13 inches", "16 inches"},
        {"Joe Montana", "Peyton Manning", "Tom Brady"},
        {"Hacky Sack", "Ball in a Cup", "Dodge Ball"},
        {"Baseball", "Curling", "Bobsledding"},
        {"World Series", "Final Four", "Super Bowl"},
        {"3", "6", "2"},
        {"6", "4", "7"},
        {"Basketball", "Football", "Hockey"},
        {"Boston", "Miami", "Houston"},
        {"Harvard", "Yale", "UC Berkeley"},
        {"India", "Japan", "United States"},
        {"4", "3", "8"}

    };

    final String[] englishQuestions = new String[]{
        "Who wrote Interview with the Vampire?",
        "What word rhymes with silver?",
        "In the book, Peter Pan, what did the crocodile swallow?",
        "What was Stephen King’s first published novel?",
        "Which author’s real name is Samuel Clemens?",
        "Who wrote Gone with the Wind?",
        "What book series is R.L. Stein known for?",
        "What letter of the alphabet isn’t in any State’s name?",
        "What Shakespear play has two characters named “Horatio” and “Yorick”?",
        "Who wrote Where the Wild Things Are?",
        "How many plays did Shakespear write?",
        "Which author wrote books named Fox in Socks and There’s a Wocket in My Pocket!?",};

    final String[] englishAnswers = new String[]{
        "Anne Rice",
        "There are no words",
        "A clock",
        "Carrie'",
        "Mark Twain",
        "Margaret Mitchell",
        "'Goosebumps'",
        "Q",
        "'Hamlet'",
        "Maurice Sendak",
        "37",
        "Dr.Suess",};

    final String[][] englishWrong = {
        {"Stephen King", "Jackie Collins", "Dean Koontz"},
        {"Orange", "Helmet", "Pizza"},
        {"Treasure Chest", "Bird", "Boat"},
        {"Pet Cemetary", "The Dark Tower", "Kujo"},
        {"William Shakespear", "Jane Austin", "Mary Shelley"},
        {"Dean Koontz", "Michael Crichton", "Ernest Hemingway"},
        {"The Dark Tower", "Game of Thrones", "The Lord of the Rings"},
        {"H", "A", "Z"},
        {"The Taming of the Shrew", "Macbeth", "Othello"},
        {"Beverly Cleary", "Shel Silverstein", "Roald Dahl"},
        {"24", "55", "35"},
        {"Laura Ingalls Wilder", "Judy Blume", "Beatrix Potter"}

    };

    final String[] movieQuestions = new String[]{
        "What is the name of the 2nd Indiana Jones movie?",
        "What year were the Acadamy Awards, aka the “Oscars”, first given out?",
        "Who played the character Sarah Connor in The Terminator movies?",
        "Who was director of these films: Gladiator, Blade Runner, and Thelma and Louise?",
        "Who wrote the book that the movie Jurassic Park is based upon?",
        "What is the highest grossing movie of all time?",
        "What was Pixar’s first movie?",
        "How many movies has Steven Spielberg directed?",
        "What studio bought the Star Wars franchise from George Lucas in 2012?",
        "What rating was updated to NC-17 in 1990?",
        "What was the name of the first Disney cartoon to have sound?",
        "In what movie does Will Ferrel play an elf?",};

    final String[] movieAnswers = new String[]{
        "'Indiana Jones and the Temple of Doom",
        "1929",
        "Linda Hamilton",
        "Ridley Scott",
        "Michael Crichton",
        "'Avengers: Endgame'",
        "'Toy Story'",
        "At least 128'",
        "Disney",
        "X Rating",
        "'Steamboat Willie'",
        "'Elf'",};

    final String[][] movieWrong = {
        {"Raiders of the Lost Ark", "Indiana Jones and the Last Crusade", "Indiana Jones and the Kingdom of the Crystal Skull"},
        {"1927", "1941", "1933"},
        {"Lily Tomlin", "Anne Hathaway", "Natalie Portman"},
        {"Stephen Spielberg", "David Lynch", "Martin Scorsese"},
        {"Ernest Hemingway", "Ray Bradbury", "George R.R. Martin"},
        {"Titanic", "Jurassic Park", "The Avengers"},
        {"Up", "A Bug's Life", "Wall-e"},
        {"45", "99", "140"},
        {"Sony", "Universal", "Fox"},
        {"PG Rating", "G Rating", "XX Rating"},
        {"Snow White and the Seven Dwarfs", "Bambi", "Pinocchio"},
        {"The Grinch", "The Mask", "The Lego Movie"}

    };

    public WriteGame2() {
        
        x = new XML_240();
        
        x.openWriterXML("Game 2");
        x.writeObject(sportsQuestions);
        x.writeObject(sportsAnswers);
        x.writeObject(sportsWrong);
        x.writeObject(englishQuestions);
        x.writeObject(englishAnswers);
        x.writeObject(englishWrong);
        x.writeObject(movieQuestions);
        x.writeObject(movieAnswers);
        x.writeObject(movieWrong);
        x.closeWriterXML();
    }
}
