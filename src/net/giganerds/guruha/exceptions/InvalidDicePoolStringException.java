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
package net.giganerds.guruha.exceptions;

/**
 * Exception for invalid dice pool string representation.
 * 
 * @author Valter Douglas "GigaNERDs" Lisboa Jr.
 */
public class InvalidDicePoolStringException extends RuntimeException {
    
    private static final long   serialVersionUID = 5150353190517018466L;
    
    /**
     * Default message prefix.
     */
    private static final String MESSAGE          = "Invalid dice pool string '";
    
    /**
     * Creates a exception with the wrong dice pool string in the message.
     * 
     * @param badDicePoolString
     *            The wrong dice pool string representation.
     */
    public InvalidDicePoolStringException(String badDicePoolString) {
        super(MESSAGE.concat(badDicePoolString).concat("'"));
    }
    
}
