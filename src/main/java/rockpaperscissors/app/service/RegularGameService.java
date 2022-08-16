package rockpaperscissors.app.service;

import rockpaperscissors.app.dto.regularmode.RegularModeHand;
import rockpaperscissors.app.dto.regularmode.RegularModeResponse;
import rockpaperscissors.core.exceptions.NotSupportedHandException;

/**
 * Play rock paper scissors
 */
public interface RegularGameService {

    /**
     * Get outcome based on played hand
     */
    public RegularModeResponse getResponseFromHand(RegularModeHand hand) throws NotSupportedHandException;
}
