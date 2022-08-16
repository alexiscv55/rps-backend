package rockpaperscissors.ws;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import rockpaperscissors.app.dto.regularmode.RegularModeHand;
import rockpaperscissors.app.dto.regularmode.RegularModeResponse;
import rockpaperscissors.app.service.RegularGameService;
import rockpaperscissors.core.exceptions.NotSupportedHandException;

@Tag(name = "Rock paper scissors", description = "You know the rules")
@RestController
@RequestMapping("game")
@CrossOrigin
public class RockPaperScissorsApi {

    private final RegularGameService gameService;

    RockPaperScissorsApi(RegularGameService gameService) {
        this.gameService = gameService;
    }

    @Operation(summary = "Play a game")
    @GetMapping()
    public RegularModeResponse play(RegularModeHand play) {
        try {
            return gameService.getResponseFromHand(play);
        } catch (NotSupportedHandException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }
}
