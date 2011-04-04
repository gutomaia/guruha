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
package net.giganerds.guruha.commons.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import net.giganerds.guruha.commons.DicePool;

import org.junit.Test;

/**
 * A class to test the Dice Pool features.
 * 
 * @author Valter Douglas "GigaNERDs" Lisboa Jr.
 */
public class DicePoolTest {
    
    private static final DicePool[] DICE_POOLS = { new DicePool(3),
            new DicePool(3, 0), new DicePool(2, 1), new DicePool(2, -1),
            new DicePool(0, 1), new DicePool(0, -1), new DicePool("3d"),
            new DicePool("3d+0"), new DicePool("2d+1"), new DicePool("2d-1"),
            new DicePool("1"), new DicePool("-1") };
    
    private static final Integer[]  DICES      = { 3, 3, 2, 2, 0, 0, 3, 3, 2,
            2, 0, 0                           };
    
    private static final Integer[]  MODIFIERS  = { 0, 0, 1, -1, 1, -1, 0, 0, 1,
            -1, 1, -1                         };
    
    private static final String[]   STRINGS    = { "3d", "3d", "2d+1", "2d-1",
            "1", "-1", "3d", "3d", "2d+1", "2d-1", "1", "-1" };
    
    @Test
    public void testCreateAndRetrieve() {
        int idx = 0;
        for (DicePool dicePool : DICE_POOLS) {
            assertEquals("Fail to get the dices from the dice pool",
                    DICES[idx], dicePool.getDices());
            assertEquals("Fail to get the modifiers from the dice pool",
                    MODIFIERS[idx], dicePool.getModifiers());
            assertEquals("Fail to get the string from the dice pool",
                    STRINGS[idx], dicePool.toString());
            idx++;
        }
        assertTrue(true);
    }
    
}
