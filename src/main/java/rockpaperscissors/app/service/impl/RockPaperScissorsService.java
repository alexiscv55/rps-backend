package rockpaperscissors.app.service.impl;

import org.springframework.stereotype.Service;

import rockpaperscissors.app.dto.mapper.HandMapper;
import rockpaperscissors.app.dto.mapper.ResultMapper;
import rockpaperscissors.app.dto.regularmode.RegularModeHand;
import rockpaperscissors.app.dto.regularmode.RegularModeResponse;
import rockpaperscissors.app.service.RegularGameService;
import rockpaperscissors.core.exceptions.NotSupportedHandException;
import rockpaperscissors.domain.rules.Rules;

@Service
public class RockPaperScissorsService extends RandomGame implements RegularGameService {

    RockPaperScissorsService(Rules rules) {
        super(rules);
    }
    
    @Override
    public RegularModeResponse getResponseFromHand(RegularModeHand hand) throws NotSupportedHandException{
        var randomHand = getRandomHand();
        var result = rules.getResultFromHands(HandMapper.from(hand), randomHand);

        return new RegularModeResponse(HandMapper.toRegular(randomHand), ResultMapper.to(result));
    }
}
