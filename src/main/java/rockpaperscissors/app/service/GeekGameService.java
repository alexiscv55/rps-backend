package rockpaperscissors.app.service;

import rockpaperscissors.app.dto.geekmode.GeekModeHand;
import rockpaperscissors.app.dto.geekmode.GeekModeResponse;
import rockpaperscissors.core.exceptions.NotSupportedHandException;

/**
 * Play rock paper scissors lizard spock
 */
public interface GeekGameService {

    /**
     * Get outcome based on played hand
     */
    public GeekModeResponse getResponseFromHand(GeekModeHand hand) throws NotSupportedHandException;
}
