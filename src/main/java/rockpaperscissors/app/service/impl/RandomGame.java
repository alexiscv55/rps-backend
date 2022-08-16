package rockpaperscissors.app.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import rockpaperscissors.domain.model.Hand;
import rockpaperscissors.domain.rules.Rules;

/**
 * Provides means to generate random hands based on a set of rules
 * Can be extended or decorated
 */
public class RandomGame {
    protected final Rules rules;

    protected final List<Hand> pool;
    protected final Random random = new Random();

    RandomGame(Rules rules) {
        this.rules = rules;

        this.pool = Collections.unmodifiableList(rules.getPlayableHands().stream().collect(Collectors.toList()));
    }

    /**
     * Get a random hand
     */
    public Hand getRandomHand() {
        return pool.get(random.nextInt(pool.size()));
    }
}
