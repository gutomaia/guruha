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

/**
 * This Enum store the states of a success roll.
 * 
 * @author Valter Douglas "GigaNERDs" Lisbôa Jr.
 */
public enum SuccessLevel {
    
    CRITICAL_SUCCESS("Critical success"),

    SUCCESS("Success"),

    FAILURE("Failure"),

    CRITICAL_FAILURE("Critical Failure"),

    INVALID("Invalid Roll");
    
    private final String text;
    
    SuccessLevel(String text) {
        this.text = text;
    }
    
    public String toString() {
        return text;
    }
    
}
