package app;

import xml.WriteGame2;
import xml.WritePlayed;
import java.io.File;

//@author Kurtis Miles

public class app {

    //File object, looks for Played file, if not there it doesn`t exists
    static File checkRank = new File("Rankings");

    public static void main(String[] args) {

        //create fresh file for Game2 Information
        WriteGame2 createGame2 = new WriteGame2();

        //if the Played File doesn`t exist create a fresh copy of it
        //will only create file when the program runs for the first time
        if (!checkRank.exists()) {
            WritePlayed createPlayed = new WritePlayed();
        }

        panels.MainFrame mjf = new panels.MainFrame();
    }

}
