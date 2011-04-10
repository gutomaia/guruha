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

import net.giganerds.guruha.commons.SuccessLevel;

/**
 * Store a success roll result.
 * 
 * @author Valter Douglas "GigaNERDs" Lisboa Jr.
 */
public class Success {
    
    /**
     * Global for a success roll.
     */
    private final static boolean SUCCESSFUL   = true;
    
    /**
     * Global for a failed roll.
     */
    private final static boolean UNSUCCESSFUL = false;
    
    /**
     * The level to be tested against.
     */
    private final Integer        level;
    
    /**
     * The rolled dices and modifiers.
     */
    private final Roll           roll;
    
    /**
     * If is permited roll in levels less than 3.
     */
    private final Boolean        allowLowLevel;
    
    /**
     * If it was well succeed or not.
     */
    private Boolean              isSuccessful = null;
    
    /**
     * The success level class.
     */
    private SuccessLevel         successLevel = null;
    
    /**
     * Creates a new success.
     * 
     * @param level
     *            The level to be tested against.
     * @param roll
     *            The dice roll and modifiers.
     * @param allowLowLevel
     *            If the level can be less than 3.
     */
    public Success(Integer level, Roll roll, Boolean allowLowLevel) {
        this.level = level;
        this.roll = roll;
        this.allowLowLevel = allowLowLevel;
        setSuccess();
    }
    
    /**
     * Check the success level and successfulness.
     * <p>
     * This is based on rules for success tests in ....
     * </p>
     * <p>
     * If the level is bellow 3, general tests cannot be done, unless this test
     * is a active defense
     * </p>
     * <p>
     * If a 3 or 4 is rolled, its a critical success. The same is true if is
     * rolled 5 on a test against 15 or 5 or 6 in a test againts 16.
     * </p>
     * <p>
     * If a 18 is rolled, its a critical failure. The same is true if is rolled
     * 17 on a test against 15 or less.
     * </p>
     * <p>
     * If roll a value above the level, it's a failure. The same is true if is
     * rolled 17 and the level is above 15.
     * </p>
     * <p>
     * If roll a value bellow or equal the level.
     * </p>
     */
    private void setSuccess() {
        if (!allowLowLevel && level < 3) {
            successLevel = SuccessLevel.INVALID;
            isSuccessful = UNSUCCESSFUL;
        } else {
            Integer rollResult = roll.getResult();
            
            if (isCriticalSuccess(rollResult)) {
                isSuccessful = SUCCESSFUL;
                successLevel = SuccessLevel.CRITICAL_SUCCESS;
                return;
            }
            
            if (isCriticalFailure(rollResult)) {
                isSuccessful = UNSUCCESSFUL;
                successLevel = SuccessLevel.CRITICAL_FAILURE;
                return;
            }
            
            if (isFailure(rollResult)) {
                isSuccessful = UNSUCCESSFUL;
                successLevel = SuccessLevel.FAILURE;
                return;
            }
            
            if (isSuccess(rollResult)) {
                isSuccessful = SUCCESSFUL;
                successLevel = SuccessLevel.SUCCESS;
                return;
            }
            
        }
    }
    
    /**
     * Internal method to check for critical success.
     * 
     * @param rollResult
     *            The final sum of the dice pool roll and modifiers.
     * @return true if its a critical success, false otherwise.
     */
    private boolean isCriticalSuccess(Integer rollResult) {
        return ((rollResult == 3) || (rollResult == 4)
                || ((rollResult == 5) && (level == 15)) || ((rollResult <= 6) && (level >= 16)));
    }
    
    /**
     * Internal method to check for critical failure.
     * 
     * @param rollResult
     *            The final sum of the dice pool roll and modifiers.
     * @return true if its a critical failure, false otherwise.
     */
    private boolean isCriticalFailure(Integer rollResult) {
        return ((rollResult == 18) || (rollResult == 17 && level <= 15) || (rollResult >= (level + 10)));
    }
    
    /**
     * Internal method to check for a common failure.
     * 
     * @param rollResult
     *            The final sum of the dice pool roll and modifiers.
     * @return true if its a common failure, false otherwise.
     */
    private boolean isFailure(Integer rollResult) {
        return (((rollResult == 17) && (level >= 16)) || rollResult > level);
    }
    
    /**
     * Internal method to check for a common success.
     * 
     * @param rollResult
     *            The final sum of the dice pool roll and modifiers.
     * @return true if its a common success, false otherwise.
     */
    private boolean isSuccess(Integer rollResult) {
        return (rollResult <= level);
    }
    
    /**
     * Retrieve a copy of the roll.
     * 
     * @return A clone of the roll instance.
     */
    public Roll getRoll() {
        return (Roll) roll.clone();
    }
    
    /**
     * Return the success level.
     * 
     * @return The state of the success.
     * @see SuccessLevel
     */
    public SuccessLevel getSuccessLevel() {
        return successLevel;
    }
    
    /**
     * Check for success or failure.
     * 
     * @return true if success, false if failure.
     */
    public Boolean isSuccessful() {
        return isSuccessful;
    }
    
    /**
     * Retrieve the level it was tested.
     * 
     * @return The level value.
     */
    public Integer getLevel() {
        return new Integer(level);
    }
    
    /**
     * Check if is permited to test against a level bellow 3.
     * 
     * @return true if is permited to test againts a level bellow 3, false
     *         otherwise.
     */
    public boolean allowLowLevel() {
        return allowLowLevel;
    }
    
}
