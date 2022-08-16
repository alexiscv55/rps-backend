package rockpaperscissors.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import rockpaperscissors.domain.rules.Rules;

@SpringBootTest
public class RockPaperScissorsRulesTests extends BasicRulesTests {

    @Autowired
    private Rules rules;

    @Override
    public Rules getRules() {
        return rules;
    }
}
