package net.giganerds.guruha.exceptions;

/**
 * exception for dice rolls bellow 1 and above 6.
 * 
 * @author Valter Douglas "GigaNERDs" Lisboa Jr.
 */
public final class InvalidRollRange extends RuntimeException {
    
    private static final long   serialVersionUID = -6168712457365694620L;
    
    /**
     * Default message prefix.
     */
    private static final String MESSAGE          = "Invalid dice roll range, expected 1 to 6, given '";
    
    /**
     * Creates a exception for a bad dice rool value.
     * 
     * @param badDiceRoll
     *            The wrong dice roll value.
     */
    public InvalidRollRange(Integer badDiceRoll) {
        super(MESSAGE.concat(badDiceRoll.toString()).concat("'"));
    }
    
}
