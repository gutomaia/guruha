package net.giganerds.guruha.exceptions;

/**
 * @author Valter Douglas "GigaNERDs" Lisboa Jr.
 */
public final class InvalidRollRange extends RuntimeException {
    
    private static final long   serialVersionUID = -6168712457365694620L;
    
    /**
     * Default message prefix.
     */
    private static final String MESSAGE          = "Invalid dice roll range, expected 1 to 6, given '";
    
    public InvalidRollRange(Integer badDiceRoll) {
        super(MESSAGE.concat(badDiceRoll.toString()).concat("'"));
    }
    
}
