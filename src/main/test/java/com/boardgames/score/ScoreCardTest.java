
package com.boardgames.score;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreCardTest {

    ScoreCard scoreCard;
    Score score;
    String testPlayerName = "alice";
    String testOpponentName = "bob";

    @BeforeAll
    static void beforeAll() {
        File file = new File("scores.txt");
        boolean didDelete = file.delete();
        assertTrue(didDelete, "Should delete the file");
    }

    @BeforeEach
    void beforeEach() {
        scoreCard = new ScoreCard();
        score = new Score(testPlayerName);
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
        scoreCard.writeScoreToFile(score.toString());
        File file = new File(scoreCard.getScoreFilePath());
        assertTrue(file.exists(), "File should exists");
    }

    @DisplayName("Should read scores from a file")
    @Test
    void readScoresFromAFileTest() {
        String file = scoreCard.readScoreFromAFile();
        assertTrue(file.length() > 0, "Length of file should be greater than zero");
    }

}