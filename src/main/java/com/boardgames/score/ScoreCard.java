package com.boardgames.score;

import com.boardgames.FileUtil;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class ScoreCard {

    private ArrayList<Score> scoreHistory = new ArrayList<>();
//    private ArrayList<Score> currentScores = new ArrayList<>();
    private Score player1;
    private Score player2;
    private long startTime = 0;

    private long endTime = 0;
    private long elapsedTime = 0;
    private int[] capturedPieces;
    private int[] lostPieces;
    private boolean timerOn = false;

    // During a typical game
    // 1. requires the data of player 1
    // 2. requires the data of player 2
    // 5. at end of the game, score the outcome
    // 6. at the end of the game, write scores to a file
    // 7. during the game, add pieces to captured pieces array
    // 8. during the game, add pieces to the lost pieces array
    // 9. during the game, show the captured pieces
    // 10. during the game, show the lost pieces
    // 11. during the game, show the current game time
    // 12. during the game, while pause, turn the timer off or on
    // 13. during the game, show the players name
    // 14. at end of the game, format game data for writing
    // 15. on game start, read data from existing game score file


    public ScoreCard() {
        // read the score data from file
        String data = readScores();
        // convert the record to a Score object
        // add the score data to the score history
        addStringDataToScoreHistory(data);
    }

    // PUBLIC METHODS

    public ArrayList<Score> getScoreHistory() {
        return scoreHistory;
    }

    public Score getScoreHistoryBy(int index) {
        return scoreHistory.get(index);
    }

    public Score getScoreHistoryBy(String name) {
        int index = scoreHistory.indexOf(name);
        if (index >= 0) {
            return scoreHistory.get(index);
        }
        return scoreHistory.get(index);
    }

    public Score getPlayer1() { return this.player1; }
    public Score getPlayer2() { return this.player2; }

    public void add(Score score) {
        if (score != null) {
            player1 = score;
        }
    }

    // converts the string data into a score object
    private void addStringDataToScoreHistory(String data) {
        Score score;
        String[] scoreRecords = data.split("\n");

        for (String row : scoreRecords) {
            String[] lineParts = row.split(";");
            score = new Score("");

            for (String lp : lineParts) {
                String[] parts = lp.split("=");

                if (parts[0].equals("playerName")) {
                    score = new Score(parts[1]);
                }
                else if (parts[0].equals("opponentName")) {
                    score.setOpponentName(parts[1]);
                }
                else if (parts[0].equals("isWin")) {
                    score.isWin();
                }
                else if (parts[0].equals("capturedPieces")) {
                    int[] temp = removeArrayCharacters(parts[1]);
                    score.setCapturedPieces(temp);
                }
                else if (parts[0].equals("lostPieces")) {
                    score.setLostPieces(removeArrayCharacters(parts[1]));
                }
                else if (parts[0].equals("date")) {
                    score.setDate(LocalDateTime.parse(parts[1]));
                }
                else if (parts[0].equals("startTime")) {
                    score.setStartTime(Long.parseLong(parts[1]));
                }
                else if (parts[0].equals("endTime")) {
                    score.setEndTime(Long.parseLong(parts[1]));
                }
            }
            this.scoreHistory.add(score);
        }
    }

    // removes the brackets and commas generated from the Arrays.toString() method
    private int[] removeArrayCharacters(String strData) {
        return Arrays.stream(strData.split(","))
                .map(e -> e.replace("[", "")
                        .replace("]", "")
                        .replace(",", "")
                        .trim())
                .mapToInt(Integer::parseInt)
                .toArray();
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

    // FILE INPUT OUTPUT

    public File getScoreFileName() {
        return new File("scores.txt");
    }

    public void writeScores(String data) {
        FileUtil.writeToAFile(data, getScoreFileName());
    }

    public String readScores() {
        return FileUtil.readAFile(getScoreFileName());
    }




}