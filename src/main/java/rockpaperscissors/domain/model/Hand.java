package rockpaperscissors.domain.model;

/**
 * Helper interface for different game rules.
 * Pretty much anything could be a playable hand depending on the rules.
 */
public interface Hand {

    default public String getValue() {
        return toString();
    }
}
