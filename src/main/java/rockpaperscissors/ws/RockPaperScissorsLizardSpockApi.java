package rockpaperscissors.ws;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import rockpaperscissors.app.dto.geekmode.GeekModeHand;
import rockpaperscissors.app.dto.geekmode.GeekModeResponse;
import rockpaperscissors.app.service.GeekGameService;
import rockpaperscissors.core.exceptions.NotSupportedHandException;

@Tag(name = "Rock paper scissors lizard spock", description = "Only for very smart people")
@RestController
@RequestMapping("geek")
@CrossOrigin
public class RockPaperScissorsLizardSpockApi {
    private final GeekGameService gameService;

    RockPaperScissorsLizardSpockApi(GeekGameService gameService) {
        this.gameService = gameService;
    }

    @Operation(summary = "Play a game")
    @GetMapping()
    public GeekModeResponse play(GeekModeHand play) {
        try {
            return gameService.getResponseFromHand(play);
        } catch (NotSupportedHandException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }
}
