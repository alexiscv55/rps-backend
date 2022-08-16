package rockpaperscissors.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import rockpaperscissors.core.annotations.Geek;
import rockpaperscissors.domain.model.GeekHand;
import rockpaperscissors.domain.model.Hand;
import rockpaperscissors.domain.rules.Rules;

@SpringBootTest
public class GeekRulesTests extends BasicRulesTests {

    protected final Hand LIZARD = GeekHand.LIZARD;
    protected final Hand SPOCK = GeekHand.SPOCK;

    @Autowired
    @Geek
    private Rules rules;

    @Override
    public Rules getRules() {
        return rules;
    }

    @Test
    void lizardDrawsAgainstItself() {
        drawAssertion(LIZARD);
    }

    
    @Test
    void spockDrawsAgainstItself() {
        drawAssertion(SPOCK);
    }

    @Test
    void rockWinsAgainstLizard() {
        victoryAssertion(ROCK, LIZARD);
    }

    @Test
    void paperWinsAgainstSpock() {
        victoryAssertion(PAPER, SPOCK);
    }


    @Test
    void scissorsWinAgainstLizard() {
        victoryAssertion(SCISSORS, LIZARD);
    }


    @Test
    void lizardWinsAgainstPaper() {
        victoryAssertion(LIZARD, PAPER);
    }

    @Test
    void lizardWinsAgainstSpock() {
        victoryAssertion(LIZARD, SPOCK);
    }

    @Test
    void spockWinsAgainstRock() {
        victoryAssertion(SPOCK, ROCK);
    }
    @Test
    void spockWinsAgainstScissors() {
        victoryAssertion(SPOCK, SCISSORS);
    }

    @Test
    protected void rockLosesAgainstSpock() {
        defeatAssertion(ROCK, SPOCK);
    }

    @Test
    protected void paperLosesAgainstLizard() {
        defeatAssertion(PAPER, LIZARD);
    }

    @Test
    protected void scissorsLoseAgainstSpock() {
        defeatAssertion(SCISSORS, SPOCK);
    }

    @Test
    protected void lizardLosesAgainstRock() {
        defeatAssertion(LIZARD, ROCK);
    }

    @Test
    protected void lizardLosesAgainstScissors() {
        defeatAssertion(LIZARD, ROCK);
    }

    @Test
    protected void spockLosesAgainstPaper() {
        defeatAssertion(SPOCK, PAPER);
    }
}
