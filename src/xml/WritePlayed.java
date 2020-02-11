package xml;


//this class writes the Played XML file with three sample players
//@author Kurtis Miles

public class WritePlayed {
    
    XML_240 x;
    final String [] player1 = new String [] {"Bob", "20", "100"};
    final String [] player2 = new String [] {"Snake", "200", "20"};
    final String [] player3 = new String [] {"Tony", "300", "60"};
     
    
    public WritePlayed(){
        
        x = new XML_240();
        x.openWriterXML("Played");
        x.writeObject(player1);
        x.writeObject(player2);
        x.writeObject(player3);
        x.closeWriterXML();
        
    }
}
