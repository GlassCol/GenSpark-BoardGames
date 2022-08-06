
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
        assertEquals(scoreCard.getPlayers()[0], score, "Added score should equal added score");
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

        assertTrue(scoreCard.getScoreHistoryBy(score.getPlayerName()).length > 0,
                "Length should be greater than 0");
        assertTrue(scoreCard.getScoreHistoryBy(score.getPlayerName())[0] != null,
                "Object should not be null");
    }


    @DisplayName("finds score records by name")
    @Test
    void findScoresByNameTest() {
        Score[] scores = scoreCard.getScoreHistoryBy(score.getPlayerName());
        if (scores.length > 0) {
            assertEquals(scores[0].getPlayerName(), score.getPlayerName(), "Should have more than zero records and contain name");
        }
    }




    @AfterAll
    static void afterAll() {
//        deleteFile();
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