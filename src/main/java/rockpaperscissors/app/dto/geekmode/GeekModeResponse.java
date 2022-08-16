package rockpaperscissors.app.dto.geekmode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import rockpaperscissors.app.dto.ResultResponse;

@Getter
@AllArgsConstructor
public class GeekModeResponse {
    private GeekModeHand opponentHand;
    private ResultResponse result;
}
