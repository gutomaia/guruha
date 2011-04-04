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
    
    public final static boolean SUCCESSFUL    = true;
    
    public final static boolean UNSUCCESSFUL  = false;
    
    private final Integer       level;
    
    private final Roll          roll;
    
    private boolean             allowLowLevel = false;
    
    private Boolean             isSuccessful  = null;
    
    private SuccessLevel        successLevel  = null;
    
    public Success(Integer level, Roll roll) {
        this.level = level;
        this.roll = roll;
        setSuccess();
    }
    
    private void setSuccess() {
        if (!allowLowLevel && level < 3) {
            successLevel = SuccessLevel.INVALID;
            isSuccessful = UNSUCCESSFUL;
        } else {
            Integer rollResult = roll.getResult();
            
            if ((rollResult == 3) || (rollResult == 4)
                    || (rollResult == 5 && level == 15)
                    || (rollResult <= 6 && level >= 16)) {
                isSuccessful = SUCCESSFUL;
                successLevel = SuccessLevel.CRITICAL_SUCCESS;
                return;
            }
            
            if ((rollResult == 18) || (rollResult == 17 && level <= 15)
                    || (rollResult >= (level + 10))) {
                isSuccessful = UNSUCCESSFUL;
                successLevel = SuccessLevel.CRITICAL_FAILURE;
                return;
            }
            
            if (((rollResult == 17) && (level >= 16)) || rollResult > level) {
                isSuccessful = UNSUCCESSFUL;
                successLevel = SuccessLevel.FAILURE;
                return;
            }
            
            if (rollResult <= level) {
                isSuccessful = SUCCESSFUL;
                successLevel = SuccessLevel.SUCCESS;
                return;
            }
            
        }
    }
    
    public Roll getRoll() {
        return (Roll) roll.clone();
    }
    
    public SuccessLevel getSuccessLevel() {
        return successLevel;
    }
    
    public Boolean isSuccessful() {
        return isSuccessful;
    }
    
    public Integer getLevel() {
        return new Integer(level);
    }
    
    public boolean allowLowLevel() {
        return allowLowLevel;
    }
    
    public void setAllowLowLevel(boolean allowLowLevel) {
        this.allowLowLevel = allowLowLevel;
        setSuccess();
    }
    
}
