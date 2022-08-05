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
        if (data.length() > 0) {
            transformToScoreObject(data);
        }

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
        if (index > 0) {
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

    public void transformToScoreObject(String data) {
        Score score;

        // check if there is data to transform
        if (data.length() > 0) {
            data = data.substring(0, data.length()-1); // clean the string data by removing the last element
            String[] scoreRecords = data.split("\n");
            for (String row : scoreRecords) {
                String[] rowParts = row.split(";");
                score = addStringDataToScoreHistory(rowParts);
                scoreHistory.add(score);
            }
        }
    }

    // converts the string data into a score object
    private Score addStringDataToScoreHistory(String[] records) {
        Score score = new Score("");

        for (String lineRecord : records) {
            String[] linePart = lineRecord.split("=");
            String title = linePart[0];
            String value = linePart[1];

            switch (title) {
                case "playerName" -> score.setPlayerName(value);
                case "opponentName" -> score.setOpponentName(value);
                case "isWin" -> score.setIsWin(Boolean.parseBoolean(value));
                case "capturedPieces" -> score.setCapturedPieces(removeArrayCharacters(value));
                case "lostPieces" -> score.setLostPieces(removeArrayCharacters(value));
                case "date" -> score.setDate(LocalDateTime.parse(value));
                case "startTime" -> score.setStartTime(Long.parseLong(value));
                case "endTime" -> score.setEndTime(Long.parseLong(value));
            }
        }
        return score;
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