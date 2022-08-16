package rockpaperscissors.app.dto.mapper;

import rockpaperscissors.app.dto.geekmode.GeekModeHand;
import rockpaperscissors.app.dto.regularmode.RegularModeHand;
import rockpaperscissors.domain.model.GeekHand;
import rockpaperscissors.domain.model.Hand;
import rockpaperscissors.domain.model.RegularHand;

/**
 * Map enums between app and domain layer.
 * 
 * For current implementation we assume enums will hold same values between layers.
 * Probably change implementation if complexity increases.
 */
public class HandMapper {

    private HandMapper() {};

    public static Hand from(RegularModeHand hand) {
        return RegularHand.valueOf(hand.name());
    }
    
    public static RegularModeHand toRegular(Hand hand) {
        return RegularModeHand.valueOf(hand.getValue());
    }

    public static Hand from(GeekModeHand hand) {
        try {
            return RegularHand.valueOf(hand.name());
        } catch (IllegalArgumentException e) {
            return GeekHand.valueOf(hand.name());
        }
    }

    public static GeekModeHand toGeek(Hand hand) {
        return GeekModeHand.valueOf(hand.getValue());
    }
}
