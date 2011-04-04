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
 * @author Valter Douglas "GigaNERDs" Lisboa Jr.
 */
public class Roll {
    
    private final ArrayList<Integer> rolls     = new ArrayList<Integer>();
    
    public final int                 MIN_ROLL  = 1;
    
    public final int                 MAX_ROLL  = 6;
    
    private Integer                  modifiers = 0;
    
    public void addDiceRoll(Integer diceRoll) {
        if (diceRoll < MIN_ROLL && diceRoll > MAX_ROLL)
            throw new InvalidRollRange(diceRoll);
        
        rolls.add(diceRoll);
    }
    
    public Integer[] getDiceRolls() {
        return (Integer[]) rolls.toArray();
    }
    
    public Integer getResult() {
        Integer result = 0;
        for (Integer roll : rolls)
            result += roll;
        result += modifiers;
        return result;
    }
    
    public Integer getRollModifier() {
        return modifiers;
    }
    
    public void setRollModifier(Integer modifiers) {
        this.modifiers = (modifiers != null) ? modifiers : 0;
    }
    
    @Override
    public Object clone() {
        Roll roll = new Roll();
        for (Integer diceRoll : rolls)
            roll.addDiceRoll(diceRoll);
        roll.setRollModifier(modifiers);
        
        return roll;
    }
    
}
