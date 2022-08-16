package rockpaperscissors.app.dto.regularmode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import rockpaperscissors.app.dto.ResultResponse;

@Getter
@AllArgsConstructor
public class RegularModeResponse {
    private RegularModeHand opponentHand;
    private ResultResponse result;
}
