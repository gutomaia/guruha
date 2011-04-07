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
package net.giganerds.guruha.rolls;

import java.util.ArrayList;

import net.giganerds.guruha.exceptions.InvalidRollRange;

/**
 * Stores a dice pool roll.
 * <p>
 * With this class, you can store each dice roll from a dice pool and set the
 * dice modifiers. Then you can retrieve it easily.
 * </p>
 * 
 * @author Valter Douglas "GigaNERDs" Lisboa Jr.
 */
public class Roll {
    
    /**
     * Stores the dice rool.
     */
    private final ArrayList<Integer> rolls     = new ArrayList<Integer>();
    
    /**
     * Minimal dice roll. GURPS uses 6 faced dice only.
     */
    public final int                 MIN_ROLL  = 1;
    
    /**
     * Maximum dice roll. GURPS uses 6 faced dice only.
     */
    public final int                 MAX_ROLL  = 6;
    
    /**
     * Dice modifier.
     */
    private Integer                  modifiers = 0;
    
    /**
     * Put a new dice rool on the pool.
     * 
     * @param diceRoll
     *            The new dice roll.
     */
    public void addDiceRoll(Integer diceRoll) {
        if (diceRoll < MIN_ROLL && diceRoll > MAX_ROLL)
            throw new InvalidRollRange(diceRoll);
        
        rolls.add(diceRoll);
    }
    
    /**
     * Retrieve the dice roll list.
     * 
     * @return The array with the dice roll.
     */
    public Integer[] getDiceRolls() {
        return (Integer[]) rolls.toArray();
    }
    
    /**
     * Retrieve the total result.
     * 
     * @return The sum of all dices rolls plus the modifiers.
     */
    public Integer getResult() {
        Integer result = 0;
        for (Integer roll : rolls)
            result += roll;
        result += modifiers;
        
        return result;
    }
    
    /**
     * Retrieve the roll modifiers.
     * 
     * @return The current roll modifiers
     */
    public Integer getRollModifier() {
        return modifiers;
    }
    
    /**
     * Configure the roll modifier
     * 
     * @param modifiers
     *            The new roll modifier. If a null is passed then a 0 is stored.
     */
    public void setRollModifier(Integer modifiers) {
        this.modifiers = (modifiers != null) ? modifiers : 0;
    }
    
    /**
     * Create a clone from the roll instance.
     * 
     * @return A clone of the instance.
     */
    @Override
    public Object clone() {
        Roll roll = new Roll();
        for (Integer diceRoll : rolls)
            roll.addDiceRoll(diceRoll);
        roll.setRollModifier(modifiers);
        
        return roll;
    }
    
}
