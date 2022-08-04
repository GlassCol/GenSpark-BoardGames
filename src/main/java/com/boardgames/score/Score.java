package com.boardgames.score;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.IntStream;


public class Score {

    private String playerName;
    private String opponentName = "";
    private boolean isWin = false;
    private int[] capturedPieces;
    private int[] lostPieces;

    private LocalDateTime date = LocalDateTime.now();
    private long startTime = 0;
    private long endTime = 0;
    private long gameTime = 0;

    // CONSTRUCTORS

    public Score(Score score) {
        this(score.playerName, score.opponentName);}

    public Score(String playerName) {
        this.playerName = playerName;
        this.opponentName = opponentName;
        this.capturedPieces = fillTheArray();
        this.lostPieces = fillTheArray();
    }

    public Score(String playerName, String opponentName) {
        this.playerName = playerName;
        this.opponentName = opponentName;
        this.capturedPieces = fillTheArray();
        this.lostPieces = fillTheArray();
    }

    /* use this constructor for existing data */
    public Score(String playerName, String opponentName, boolean isWin, int[] capturedPieces, int[] lostPieces,
                 LocalDateTime date, long totalTime, long startTime, long endTime, long gameTime) {
        this.playerName = playerName;
        this.opponentName = opponentName;
        this.isWin = isWin;
        this.capturedPieces = capturedPieces;
        this.lostPieces = lostPieces;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.gameTime = gameTime;
    }

    /*
     * Initialize the arrays for game pieces with -1 index
     * a -1 value indicates empty while positive ints will represent the identity of the piece, e.g. 1's = pawn, 2's = rook
     * */
    private int[] fillTheArray() {
        return IntStream.range(0, 16)
                .mapToObj(num -> "-1")
                .mapToInt(Integer::parseInt)
                .toArray();
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
    public void isWin() { this.isWin = this.isWin ? true : false; }
    public void setCapturedPieces(int[] capturedPieces) { this.capturedPieces = capturedPieces;}
    public void setLostPieces(int[] lostPieces) { this.lostPieces = lostPieces;}
    public void addNext(int pieceId, int[] array) {}
    public void setDate(LocalDateTime localDateTime) { this.date = localDateTime; }
    public void setStartTime(long startTime) { this.startTime = startTime; }
    public void setEndTime(long endTime) { this.endTime = endTime; }
    private void setGameTime() { this.gameTime = this.endTime = this.startTime; }

    @Override
    public String toString() {
        return "playerName=" + playerName + ";" +
                "opponentName=" + opponentName + ";" +
                "isWin=" + isWin + ";" +
                "capturedPieces=" + Arrays.toString(capturedPieces) + ";" +
                "lostPieces=" + Arrays.toString(lostPieces) + ";" +
                "date=" + date + ";" +
                "startTime=" + startTime + ";" +
                "endTime=" + endTime + ";" +
                "gameTime=" + gameTime + ";\n";
    }
}