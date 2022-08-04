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


}
