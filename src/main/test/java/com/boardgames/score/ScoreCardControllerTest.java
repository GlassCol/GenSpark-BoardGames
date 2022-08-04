package com.boardgames.score;

import com.boardgames.controller.ScoreCardController;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreCardControllerTest {

    ScoreCardController scController;
    Score score;

    @BeforeEach
    void beforeEach() {
        scController = new ScoreCardController();
        score = new Score("Alice");
    }


    @DisplayName("Should write score to a file")
    @Test
    void writeScoreToAFileTest() {
        scController.writeScoreToFile(score.toString());
        File file = new File(scController.getScoreFilePath());
        assertTrue(file.exists(), "File should exists");
    }

    @DisplayName("Should read scores from a file")
    @Test
    void readScoresFromAFileTest() {
        String file = scController.readScoreFromAFile();
        assertTrue(file.length() > 0, "Length of file should be greater than zero");
    }

    @DisplayName("Should delete the score file")
    @Test
    void deleteScoreFileTest() {
        File file = new File(scController.getScoreFilePath());
        boolean didDelete = file.delete();
        assertTrue(didDelete, "Should delete the file");
    }

}
