package rockpaperscissors.app.service.impl;

import org.springframework.stereotype.Service;

import rockpaperscissors.app.dto.geekmode.GeekModeHand;
import rockpaperscissors.app.dto.geekmode.GeekModeResponse;
import rockpaperscissors.app.dto.mapper.HandMapper;
import rockpaperscissors.app.dto.mapper.ResultMapper;
import rockpaperscissors.app.service.GeekGameService;
import rockpaperscissors.core.annotations.Geek;
import rockpaperscissors.core.exceptions.NotSupportedHandException;
import rockpaperscissors.domain.rules.Rules;

@Service
public class RockPaperScissorsLizardSpockService extends RandomGame implements GeekGameService {

    RockPaperScissorsLizardSpockService(@Geek Rules rules) {
        super(rules);
    }
    
    @Override
    public GeekModeResponse getResponseFromHand(GeekModeHand hand) throws NotSupportedHandException{
        var randomHand = getRandomHand();
        var result = rules.getResultFromHands(HandMapper.from(hand), randomHand);

        return new GeekModeResponse(HandMapper.toGeek(randomHand), ResultMapper.to(result));
    }
    
}
