package rockpaperscissors.domain.rules.impl;

import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import rockpaperscissors.core.annotations.Geek;
import rockpaperscissors.domain.model.GeekHand;
import rockpaperscissors.domain.model.Hand;
import rockpaperscissors.domain.model.RegularHand;

@Service
@Geek
public class GeekRules extends RockPaperScissorsRules {

    private final Set<Hand> rockDefeats = Set.of(RegularHand.SCISSORS, GeekHand.LIZARD);
    private final Set<Hand> paperDefeats = Set.of(RegularHand.ROCK, GeekHand.SPOCK);
    private final Set<Hand> scissorDefeats = Set.of(RegularHand.PAPER, GeekHand.LIZARD);
    private final Set<Hand> lizardDefeats = Set.of(RegularHand.PAPER, GeekHand.SPOCK);
    private final Set<Hand> spockDefeats = Set.of(RegularHand.ROCK, RegularHand.SCISSORS);


    private final Map<Hand, Set<Hand>> handDefeats = Map.of(
        RegularHand.ROCK, rockDefeats,
        RegularHand.PAPER, paperDefeats,
        RegularHand.SCISSORS, scissorDefeats,
        GeekHand.LIZARD, lizardDefeats,
        GeekHand.SPOCK, spockDefeats
    );

    @Override
    public Set<Hand> getPlayableHands() {
        return this.handDefeats.keySet();
    };

    @Override
    protected boolean isVictory(Hand playerHand, Hand opponentHand) {
        return handDefeats.get(playerHand).contains(opponentHand);
    }
}
