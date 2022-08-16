package rockpaperscissors.domain.rules;

import java.util.Set;

import rockpaperscissors.core.exceptions.NotSupportedHandException;
import rockpaperscissors.domain.model.Hand;
import rockpaperscissors.domain.model.Result;

/**
 * Interface for different game rules
 */
public interface Rules {

    /**
     * Get result from 2 players game
     */
    public Result getResultFromHands(Hand playerHand, Hand opponentHand) throws NotSupportedHandException;

    /**
     * Get valid hands
     */
    public Set<Hand> getPlayableHands();
}
