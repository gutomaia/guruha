/*
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License version 2 as published by the
 * Free Software Foundation. This program is distributed in the hope that it
 * will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General
 * Public License for more details. You should have received a copy of the GNU
 * General Public License along with this program; if not, write to the Free
 * Software Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */
package net.giganerds.guruha.commons;

import net.giganerds.guruha.exceptions.InvalidDicePoolStringException;

/**
 * The DicePool class stores the elements of a dice pool and allow retrieve them
 * easily.
 * <p>
 * Any Dice set and its modifiers can be represented by a instance of this class
 * and also permit convert from/to a dice string representation (i.e. "2d+1",
 * "3d"). It also allow a empty dice number to represent absolutes numbers, like
 * a pure 1 point of damage without dice roll.
 * </p>
 * 
 * @author Valter Douglas "GigaNERDs" Lisboa Jr.
 */
public class DicePool {
    
    /**
     * Verify if a given dice pool string is valid, returning true if yes or
     * false otherwise.
     * 
     * @param dicePoolString
     *            A string representing a dice pool.
     * @return true if the string is well formed, false otherwise.
     */
    public static boolean checkDicePoolString(String dicePoolString) {
        return dicePoolString
                .matches("(([0-9]+[dD]){0,1}([+-][0-9]+){0,1}|[0-9]+)");
    }
    
    /**
     * If not specified, the default number of dices in a pool is 3.
     */
    private final Integer   DEFAULT_DICES     = 3;
    
    /**
     * If not specified, the default modifiers in a pool is 0.
     */
    private final Integer   DEFAULT_MODIFIERS = 0;
    
    /**
     * GURPS only uses six-faced dices.
     * <p>
     * This is useful when you need do make arithmetics with dices.
     * </p>
     */
    public final static int FACES             = 6;
    
    /**
     * Stores the number of dices in a pool.
     */
    private final Integer   dices;
    
    /**
     * Stores the modifiers in a pool.
     */
    private final Integer   modifiers;
    
    /**
     * Creates a default "3d" dice pool.
     * <p>
     * Most dice rolls on GURPS uses three dices.
     * </p>
     */
    public DicePool() {
        dices = DEFAULT_DICES;
        modifiers = DEFAULT_MODIFIERS;
    }
    
    /**
     * Creates a pool with a dice number only.
     * <p>
     * This is useful to create a quick dice only pool without ant modifier.
     * </p>
     * 
     * @param dices
     *            The number of dices.
     */
    public DicePool(Integer dices) {
        this.dices = dices != null ? dices : 0;
        modifiers = DEFAULT_MODIFIERS;
    }
    
    /**
     * Creates a pool with a dice number and modifier.
     * <p>
     * Use this to create a complete dice pool with both dice number and
     * modifiers. (i.e. 2d+2, 7d+7, etc).
     * </p>
     * 
     * @param dices
     *            The number of dices.
     * @param modifiers
     *            The total modifiers roll.
     */
    public DicePool(Integer dices, Integer modifiers) {
        this.dices = dices != null ? dices : 0;
        this.modifiers = modifiers != null ? modifiers : 0;
    }
    
    /**
     * Creates a pool from a string.
     * <p>
     * Sometimes the dice pool will be given in a string format of
     * <i>n</i><strong>d</strong>+<i>m</i>, where <i>n</i> is the number of
     * dices to roll and <i>m</i> is the modifier, a integer to be aplied to
     * final result.
     * </p>
     * 
     * @param dicePoolString
     *            A string with a valid dice pool format.
     * @throws InvalidDicePoolStringException
     *             if the string are not in a valid dice/modifier format.
     */
    public DicePool(String dicePoolString) {
        dices = parseDicesFromString(dicePoolString);
        modifiers = parseModifiersFromString(dicePoolString);
    }
    
    /**
     * Retrieve the dice number integer from the pool.
     * 
     * @return The dice number from the pool.
     */
    public Integer getDices() {
        return dices;
    }
    
    /**
     * Retrieve the total modifiers integer from the pool.
     * 
     * @return The modifiers from the pool.
     */
    public Integer getModifiers() {
        return modifiers;
    }
    
    /**
     * Return the dice number from a valid dice pool string.
     * 
     * @param dicePoolString
     *            A string with a valid dice pool format.
     * @throws InvalidDicePoolString
     *             if the string are not in a valid dice/modifier format.
     * @return The dices number to this pool.
     */
    private Integer parseDicesFromString(String dicePoolString) {
        if (!checkDicePoolString(dicePoolString))
            throw new InvalidDicePoolStringException(dicePoolString);
        
        if (dicePoolString.matches(".*[dD].*")) // We have a dice
            return new Integer(dicePoolString.replaceAll("[dD].*", ""));
        else
            return 0;
    }
    
    /**
     * Return the modifiers from a valid dice pool string.
     * 
     * @param dicePoolString
     *            A string with a valid dice pool format.
     * @throws InvalidDicePoolString
     *             if the string are not in a valid dice/modifier format.
     * @return The modifiers to this pool.
     */
    private Integer parseModifiersFromString(String dicePoolString) {
        if (!checkDicePoolString(dicePoolString))
            throw new InvalidDicePoolStringException(dicePoolString);
        
        if (dicePoolString.matches(".*[dD].*")) {
            // We have a dice
            if (dicePoolString.matches(".*[+-].*")) // We have a modifier
                return new Integer(dicePoolString.replaceAll(
                        ".*[dD](\\+){0,1}", ""));
            else
                return 0;
        } else
            return new Integer(dicePoolString);
    }
    
    /**
     * Convert a dice pool to a valid string representation.
     * 
     * @return The dice pool string.
     */
    @Override
    public String toString() {
        if (dices == 0 && modifiers == 0)
            return "0";
        
        // TODO: Use string builder to make this more efficient.
        String dicePoolString = "";
        
        if (dices != 0)
            dicePoolString = dicePoolString.concat(dices + "d");
        
        if (modifiers != 0)
            if (modifiers < 0)
                dicePoolString = dicePoolString.concat(modifiers.toString());
            else if (modifiers > 0)
                if (dices != 0)
                    dicePoolString = dicePoolString.concat("+" + modifiers);
                else
                    dicePoolString = dicePoolString
                            .concat(modifiers.toString());
        
        return dicePoolString;
    }
    
}
