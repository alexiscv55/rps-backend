package rockpaperscissors.domain.model;

public enum GeekHand implements Hand {
    LIZARD, SPOCK;

    @Override
    public String getValue() {
        return name();
    }
}
