package com.boardgames.score;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreCardTest {

    ScoreCard scoreCard;

    @BeforeEach
    void beforeEach() {
        scoreCard = new ScoreCard();
    }

    @DisplayName("Should create and instance of Scorecard")
    @Test
    void scoreCardTest() {
        assertNotNull(scoreCard, "Scorecard instance should not be null");
    }

}
