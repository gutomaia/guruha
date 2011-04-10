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
package net.giganerds.guruha.rolls.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import net.giganerds.guruha.commons.SuccessLevel;
import net.giganerds.guruha.rolls.Roll;
import net.giganerds.guruha.rolls.Success;

import org.junit.Test;

/**
 * A test for success rools. It test all range of dice roll against a level from
 * 1 to 20.
 * 
 * @author Valter Douglas "GigaNERDs" Lisboa Jr.
 */
public class SuccessTests {
    
    /**
     * The test root. Generate all dice roll possibilities and test it against a
     * range of levels from 1 to 20. Values bellow 3 are tested with and without
     * allowlowlevel.
     */
    @Test
    public void testSuccessByArbitraryRoll() {
        int idx = 0;
        for (int roll1 = 1; roll1 <= 6; roll1++)
            for (int roll2 = 1; roll2 <= 6; roll2++)
                for (int roll3 = 1; roll3 <= 6; roll3++)
                    for (int level = 1; level <= 20; level++) {
                        Roll roll = new Roll();
                        roll.addDiceRoll(roll1);
                        roll.addDiceRoll(roll2);
                        roll.addDiceRoll(roll3);
                        
                        assertSuccess(new Success(level, roll, false));
                        if (level < 3) {
                            assertSuccess(new Success(level, roll, true));
                        }
                        
                        idx++;
                    }
        assertTrue(true);
    }
    
    /**
     * Checks for a good success result.
     * 
     * @param success
     *            The succes instance to be checked.
     */
    private void assertSuccess(Success success) {
        // First some sanity checks
        Roll roll = success.getRoll();
        assertNotNull("Roll cannot be null", roll);
        Integer level = success.getLevel();
        assertNotNull("Level cannot be null", level);
        Boolean isSuccessful = success.isSuccessful();
        assertNotNull("Is success cannot be null", isSuccessful);
        SuccessLevel successLevel = success.getSuccessLevel();
        assertNotNull("Success level cannot be null", successLevel);
        Integer rollResult = roll.getResult();
        
        // Uncomment this for test output.
        // System.out.println("Result = " + rollResult + "; Level = " + level
        // + "; Success = " + isSuccessful + "; Status = " + successLevel
        // + "; Allow low level = " + success.allowLowLevel());
        
        if (!success.allowLowLevel() && level < 3) {
            assertTrue("Cannot allow success if low level is not allowed",
                    !isSuccessful);
            assertSuccessLevel(successLevel, SuccessLevel.INVALID, rollResult,
                    level);
        } else {
            
            if (rollResult == 3 || rollResult == 4
                    || (rollResult == 5 && level >= 15)
                    || (rollResult <= 6 && level >= 16)) {
                assertIsSuccessful(rollResult, level, isSuccessful,
                        successLevel);
                assertSuccessLevel(successLevel, SuccessLevel.CRITICAL_SUCCESS,
                        rollResult, level);
            } else if (rollResult == 18 || (rollResult == 17 && level <= 15)
                    || (rollResult >= (level + 10))) {
                assertIsSuccessful(rollResult, level, !isSuccessful,
                        successLevel);
                assertSuccessLevel(successLevel, SuccessLevel.CRITICAL_FAILURE,
                        rollResult, level);
            } else if (((rollResult == 17) && (level >= 16))
                    || rollResult > level) {
                assertIsSuccessful(rollResult, level, !isSuccessful,
                        successLevel);
                assertSuccessLevel(successLevel, SuccessLevel.FAILURE,
                        rollResult, level);
            } else if (rollResult <= level) {
                assertIsSuccessful(rollResult, level, isSuccessful,
                        successLevel);
                assertSuccessLevel(successLevel, SuccessLevel.SUCCESS,
                        rollResult, level);
            }
            
        }
        
    }
    
    private void assertIsSuccessful(Integer rollResult, Integer level,
            Boolean isSuccessful, SuccessLevel successLevel) {
        assertTrue("With result " + rollResult + " at level " + level
                + ", it must be a success. Status = " + successLevel,
                isSuccessful);
    }
    
    private void assertSuccessLevel(SuccessLevel successLevel,
            SuccessLevel suposedSuccessLevel, Integer rollResult, Integer level) {
        assertTrue("Success level must be " + suposedSuccessLevel
                + " with result " + rollResult + " at level " + level,
                successLevel == suposedSuccessLevel);
        
    }
    
}
