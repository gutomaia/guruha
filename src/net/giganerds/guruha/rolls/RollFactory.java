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

/**
 * @author Valter Douglas "GigaNERDs" Lisboa Jr.
 */
public abstract class RollFactory {
    
    /**
     * Constructor is private to avoid instantiating.
     */
    private RollFactory() {
        
    }
    
    public static Success successRoll(Integer level) {
        return successRoll(level, false);
    }
    
    public static Success successRoll(Integer level, Boolean allowLowLevel) {
        return new Success(level, roll3Dice(), allowLowLevel);
    }
    
    private static Roll roll3Dice() {
        Roll roll = new Roll();
        roll.addDiceRoll(roolDice());
        roll.addDiceRoll(roolDice());
        roll.addDiceRoll(roolDice());
        
        return roll;
    }
    
    private static Integer roolDice() {
        return new Integer((int) (Math.random() * 6) + 1);
    }
    
}
