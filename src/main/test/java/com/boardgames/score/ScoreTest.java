package com.boardgames.score;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Objects;


public class ScoreTest {

    Score score;
    String testName = "Alice";

    @BeforeEach
    void beforeEach() {
        score = new Score(testName);
    }

    @DisplayName("Should create an instance of Score with player name set")
    @Test
    void createOneInstanceTest() {
        assertNotNull(score, "Instance score should not be null");
        assertEquals(score.getPlayerName(), testName, "Player name should be set");
    }

    @DisplayName("Should fill captured array with -1")
    @Test
    void fillTheArrayTest() {
        int[] testArray = score.getCapturedPieces();
        int[] testElement = new int[]{-1};
        int actual = (int) Arrays.stream(testArray)
                .mapToObj(Objects::toString)
                .filter(ele -> ele.equals("-1"))
                .count();

        assertEquals(testArray[0], testElement[0], "First element should be -1");
        assertEquals(testArray[testArray.length-1], testElement[0], "Lest element should be -1");
        assertEquals(testArray.length, actual, "-1 count should equal test array length");

    }


}
