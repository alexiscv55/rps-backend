package rockpaperscissors.core.exceptions;

import rockpaperscissors.domain.model.Hand;

/**
 * An unexpected hand was received or rules are inconsistent
 */
public class NotSupportedHandException extends Exception {
    
    public NotSupportedHandException(Hand unsupportedHand) {
        super("Unsupported hand: ".concat(unsupportedHand.getValue()));
    }
}
