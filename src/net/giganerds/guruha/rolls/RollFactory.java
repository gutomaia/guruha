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

import net.giganerds.guruha.commons.DicePool;

/**
 * This class is a set of statics methods to make all types of roll.
 * 
 * @author Valter Douglas "GigaNERDs" Lisboa Jr.
 */
public abstract class RollFactory {
    
    /**
     * Constructor is private to avoid instantiating.
     */
    private RollFactory() {
        
    }
    
    /**
     * Make a success roll.
     * 
     * @param level
     *            The level to be rolled against.
     * @param allowLowLevel
     *            If is permitted tests against 2 or less.
     * @return The success roll.
     */
    public static Success successRoll(Integer level, Boolean allowLowLevel) {
        return new Success(level, roll3Dice(), allowLowLevel);
    }
    
    /**
     * Roll 3 six-faced dices.
     * 
     * @return The result of the roll.
     */
    private static Roll roll3Dice() {
        Roll roll = new Roll();
        roll.addDiceRoll(roolDice());
        roll.addDiceRoll(roolDice());
        roll.addDiceRoll(roolDice());
        
        return roll;
    }
    
    /**
     * Roll a six faced dice.
     * 
     * @return The result of the dice roll.
     */
    private static Integer roolDice() {
        return new Integer((int) (Math.random() * DicePool.FACES) + 1);
    }
    
}
