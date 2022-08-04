
package com.boardgames.score;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreCardTest {

    ScoreCard scoreCard;
    Score score;
    String testPlayerName = "alice";
    String testOpponentName = "bob";

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
        assertEquals(scoreCard.getCurrentScores().get(0), score, "Added score should equal added score");

    }

}