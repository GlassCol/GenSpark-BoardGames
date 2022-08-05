
package com.boardgames.score;

import org.junit.jupiter.api.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreCardTest {

    ScoreCard scoreCard;
    Score score;
    String testPlayerName = "alice";
    String testOpponentName = "bob";


    @BeforeEach
    void beforeEach() {
        scoreCard = new ScoreCard();
        score = new Score(testPlayerName, testOpponentName);
    }

    @DisplayName("Should create and instance of Scorecard")
    @Test
    void scoreCardTest() {
        assertNotNull(scoreCard, "Scorecard instance should not be null");
    }

    @DisplayName("Should add Score to the current array")
    @Test
    void addTest() {
        scoreCard.add(score);
        assertEquals(scoreCard.getPlayer1(), score, "Added score should equal added score");
    }

    @DisplayName("Should write score to a file")
    @Test
    void writeScoreToAFileTest() {
        scoreCard.writeScores(score.toString());
        File file = new File(scoreCard.getScoreFileName().getName());
        assertTrue(file.exists(), "File should exists");
    }

    @DisplayName("Should read scores from a file")
    @Test
    void readScoresFromAFileTest() {
        scoreCard.writeScores(score.toString());
        String file = scoreCard.readScores();
        assertTrue(file.length() > 0, "Length of file should be greater than zero");
    }

    @DisplayName("Should create a score object from string data in file")
    @Test
    void stringToScoreTest() {
        scoreCard.writeScores(score.toString());
        scoreCard.writeScores(score.toString());

        assertTrue(scoreCard.getScoreHistory().size() > 0, "Should contain more than zero records");
        assertFalse(scoreCard.getScoreHistoryBy(0).getPlayerName().isEmpty(), "Player name should not be empty");
        assertFalse(scoreCard.getScoreHistoryBy(0).getOpponentName().isEmpty(), "Opponent name should not be empty");
        assertFalse(scoreCard.getScoreHistoryBy(0).getIsWin(), "isWin should be false by default");
        assertTrue(scoreCard.getScoreHistoryBy(0).getCapturedPieces().length > 0, "Captured pieces should be greater than zero");
        assertTrue(scoreCard.getScoreHistoryBy(0).getLostPieces().length > 0, "Lost pieces should be greater than zero");
        assertFalse(scoreCard.getScoreHistoryBy(0).getDate().toString().isEmpty(), "Date should not be empty");
        assertTrue(scoreCard.getScoreHistoryBy(0).getStartTime() >= 0, "Start time should be greater than zero");
        assertTrue(scoreCard.getScoreHistoryBy(0).getEndTime() >= 0, "End time should be greater than zero");
        assertTrue(scoreCard.getScoreHistoryBy(0).getGameTime() >= 0, "Game time should be greater than zero");

    }

    @AfterAll
    static void afterAll() {
        deleteFile();
    }

    private static void deleteFile() {
        String path = "scores.txt";
        try {
            Files.delete(Path.of(path));
        } catch (NoSuchFileException x) {
            System.err.format("%s: no such" + " file or directory%n", path);
        } catch (DirectoryNotEmptyException x) {
            System.err.format("%s not empty%n", path);
        } catch (IOException x) {
            // File permission problems are caught here.
            System.err.println(x);
        }
    }



}