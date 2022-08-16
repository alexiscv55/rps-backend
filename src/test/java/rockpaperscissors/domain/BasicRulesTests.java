package rockpaperscissors.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import rockpaperscissors.core.exceptions.NotSupportedHandException;
import rockpaperscissors.domain.model.Hand;
import rockpaperscissors.domain.model.RegularHand;
import rockpaperscissors.domain.model.Result;
import rockpaperscissors.domain.rules.Rules;

public abstract class BasicRulesTests {

    private enum NotSupportedHand implements Hand {
        NOT_SUPPORTED;

        @Override
        public String getValue() {
            return name();
        }
    }

    protected final Hand ROCK = RegularHand.ROCK;
    protected final Hand PAPER = RegularHand.PAPER;
    protected final Hand SCISSORS = RegularHand.SCISSORS;

    abstract Rules getRules();

    @Test
    protected void rockDrawsAgainstItself() {
        drawAssertion(ROCK);
    }

    @Test
    protected void paperDrawsAgainstItself() {
        drawAssertion(PAPER);
    }

    @Test
    protected void scissorsDrawAgainstItself() {
        drawAssertion(SCISSORS);
    }

    @Test
    protected void rockWinsAgainstScissors() {
        victoryAssertion(ROCK, SCISSORS);
    }

    @Test
    protected void paperWinsAgainstRock() {
        victoryAssertion(PAPER, ROCK);
    }

    @Test
    protected void scissorsWinAgainstPaper() {
        victoryAssertion(SCISSORS, PAPER);
    }

    @Test
    protected void rockLosesAgainstPaper() {
        defeatAssertion(ROCK, PAPER);
    }

    @Test
    protected void paperLosesAgainstScissors() {
        defeatAssertion(PAPER, SCISSORS);
    }

    @Test
    protected void scissorsLoseAgainstRock() {
        defeatAssertion(SCISSORS, ROCK);
    }

    @Test
    protected void notSupportedHandThrowsException() {
        assertThrows(NotSupportedHandException.class, () -> getRules().getResultFromHands(NotSupportedHand.NOT_SUPPORTED, ROCK));
        assertThrows(NotSupportedHandException.class, () -> getRules().getResultFromHands(ROCK, NotSupportedHand.NOT_SUPPORTED));
    }

    protected void victoryAssertion(Hand a, Hand b) {
        Result result = getResultWithoutExceptions(a, b);
        assertEquals(Result.VICTORY, result);
    }

    protected void defeatAssertion(Hand a, Hand b) {
        Result result = getResultWithoutExceptions(a, b);
        assertEquals(Result.DEFEAT, result);
    }

    protected void drawAssertion(Hand a) {
        Result result = getResultWithoutExceptions(a, a);
        assertEquals(Result.DRAW, result);
    }

    protected Result getResultWithoutExceptions(Hand a, Hand b) {
        return assertDoesNotThrow(() -> getRules().getResultFromHands(a, b));
    }

}
