package rockpaperscissors.domain.model;

public enum RegularHand implements Hand {
    ROCK, PAPER, SCISSORS;
    
    @Override
    public String getValue() {
        return name();
    }
}
