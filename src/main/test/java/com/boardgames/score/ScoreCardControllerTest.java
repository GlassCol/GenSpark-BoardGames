package com.boardgames.score;

import com.boardgames.controller.ScoreCardController;
import org.junit.jupiter.api.BeforeEach;


public class ScoreCardControllerTest {

    ScoreCardController scController;
    Score score;

    @BeforeEach
    void beforeEach() {
        scController = new ScoreCardController();
        score = new Score("Alice");
    }


}
