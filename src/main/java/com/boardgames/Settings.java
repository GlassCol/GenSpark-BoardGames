package com.boardgames;
/**
 * Class to store the game data for the settings
 *
 * @author Cole Glass
 */
public class Settings {
    private static int numOfPlayers = 2;
    private static boolean playingChess = true;

    public static int getNumOfPlayers() {
        return numOfPlayers;
    }

    public static void setNumOfPlayers(int numOfPlayers) {
        Settings.numOfPlayers = numOfPlayers;
    }

    public static boolean isPlayingChess() {
        return playingChess;
    }

    public static void setPlayingChess(boolean playingChess) {
        Settings.playingChess = playingChess;
    }
}
