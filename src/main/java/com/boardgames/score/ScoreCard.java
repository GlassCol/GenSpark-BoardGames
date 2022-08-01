package com.boardgames.score;

import java.util.ArrayList;

public class ScoreCard {

    private ArrayList<Score> scoreHistory = new ArrayList<>();
    private ArrayList<Score> currentScores = new ArrayList<>();
    private long startTime = 0;

    private long endTime = 0;
    private long elapsedTime = 0;
    private int[] capturedPieces;
    private int[] lostPieces;
    private boolean timerOn = false;

    // During a typical game
    // 1. requires the data of player 1
    // 2. requires the data of player 2
    // 3. requires a new score instance to keep alive new data for player 1
    // 4. requires a new score instance to keep alive new data for player 2
    // 5. at end of the game, score the outcome
    // 6. at the end of the game, write scores to a file
    // 7. during the game, add pieces to captured pieces array
    // 8. during the game, add pieces to the lost pieces array
    // 9. during the game, show the captured pieces
    // 10. during the game, show the lost pieces
    // 11. during the game, show the current game time
    // 12. during the game, while pause, turn the timer off or on
    // 13. during the game, show the players name


    ScoreCard() {}

    // PUBLIC METHODS

    public String getScoreHistoryBy(int index) {
        return scoreHistory.get(index).toString();
    }

    public String getScoreHistoryBy(String name) {
        int index = scoreHistory.indexOf(name);
        if (index >= 0) { return scoreHistory.get(index).toString(); }
        return "";
    }

    // validate score instances being added
    public void add(Score score) {
        if (score != null) {
            scoreHistory.add(score);
        }
    }

    public boolean delete(Score score) {
       return scoreHistory.remove(score);
}

    public void startTimer() {
        startTime = System.currentTimeMillis();
    }

    public void stopTimer() {
        endTime = System.currentTimeMillis();
        elapsedTime = endTime - startTime;
        startTime = 0;
    }

    // How do we score the game?
    public void scoreGame() {

    }



}

