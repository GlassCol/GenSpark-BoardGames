package com.boardgames.score;

import java.time.LocalDateTime;
import java.util.Arrays;


public class Score {

    private String playerName;
    private String opponentName = "";
    private boolean isWin;
    private int[] capturedPieces = new int[16];
    private int[] lostPieces = new int[16];

    private LocalDateTime date;
    private long totalTime = 0;
    private long startTime = 0;
    private long endTime = 0;
    private long gameTime = 0;

    // CONSTRUCTORS


    Score(String playerName) {
        this.playerName = playerName;
    }

    Score(String playerName, String opponentName) {
        this.playerName = playerName;
        this.opponentName = opponentName;
    }

    /* use this constructor for existing data */
    Score(String playerName, String opponentName, boolean isWin, int[] capturedPieces, int[] lostPieces,
          LocalDateTime date, long totalTime, long startTime, long endTime, long gameTime) {
        this.playerName = playerName;
        this.opponentName = opponentName;
        this.isWin = isWin;
        this.capturedPieces = capturedPieces;
        this.lostPieces = lostPieces;
        this.date = date;
        this.totalTime = totalTime;
        this.startTime = startTime;
        this.endTime = endTime;
        this.gameTime = gameTime;
    }

    // GETTERS

    public String getPlayerName() {
        return this.playerName;
    }

    public String getOpponentName() {
        return this.opponentName;
    }

    public boolean getIsWin() {
        return this.isWin;
    }

    public int[] getCapturedPieces() {
        return capturedPieces;
    }

    public int[] getLostPieces() {
        return lostPieces;
    }

    public LocalDateTime getDate() {
        return this.date;
    }

    public long getTotalTime() {
        return this.totalTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public long getGameTime() {
        return gameTime;
    }


    // SETTERS

    public void setPlayerName(String playerName) { this.playerName = playerName; }
    public void setOpponentName(String opponentName) { this.opponentName = opponentName; }



    @Override
    public String toString() {
        return "playerName='" + playerName + '\'' +
                ", opponentName='" + opponentName + '\'' +
                ", isWin=" + isWin +
                ", capturedPieces=" + Arrays.toString(capturedPieces) +
                ", lostPieces=" + Arrays.toString(lostPieces) +
                ", date=" + date +
                ", totalTime=" + totalTime +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", gameTime=" + gameTime;
    }
}
