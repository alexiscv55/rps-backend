package rockpaperscissors.domain.rules.impl;

import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import rockpaperscissors.core.exceptions.NotSupportedHandException;
import rockpaperscissors.domain.model.Hand;
import rockpaperscissors.domain.model.RegularHand;
import rockpaperscissors.domain.model.Result;
import rockpaperscissors.domain.rules.Rules;

@Service
@Primary
public class RockPaperScissorsRules implements Rules {

    private final Hand rockDefeats = RegularHand.SCISSORS;
    private final Hand paperDefeats = RegularHand.ROCK;
    private final Hand scissorDefeats = RegularHand.PAPER;

    private final Map<Hand, Hand> handDefeats = Map.of(
        RegularHand.ROCK, rockDefeats,
        RegularHand.PAPER, paperDefeats,
        RegularHand.SCISSORS, scissorDefeats
    );

    @Override
    public Result getResultFromHands(Hand playerHand, Hand opponentHand) throws NotSupportedHandException {

        validateHand(playerHand);
        validateHand(opponentHand);

        if (isDraw(playerHand, opponentHand)) {
            return Result.DRAW;
        }

        if(isVictory(playerHand, opponentHand)) {
            return Result.VICTORY;
        }
        
        return Result.DEFEAT;
    }

    @Override
    public Set<Hand> getPlayableHands() {
        return this.handDefeats.keySet();
    };

    protected boolean isDraw(Hand playerHand, Hand opponentHand) {
        return playerHand.equals(opponentHand);
    }

    protected boolean isVictory(Hand playerHand, Hand opponentHand) {
        return handDefeats.get(playerHand).equals(opponentHand);
    }

    protected void validateHand(Hand hand) throws NotSupportedHandException {
        if (!getPlayableHands().contains(hand)) {
            throw new NotSupportedHandException(hand);
        }
    }



}
