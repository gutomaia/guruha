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
 * Stores the current version information. Modify the build.xml if you change
 * the values here and vice-versa.
 * 
 * @author Valter Douglas "GigaNERDs" Lisboa Jr.
 */
public class Version {
    
    /**
     * Reflects the major version, this will change only if a modification of
     * the API was required or a beta version was unleashed.
     */
    static final public int    MAJOR_VERSION = 0;
    
    /**
     * Shows new features add to API without change the previous API.
     */
    static final public int    MINOR_VERSION = 0;
    
    /**
     * Bug fixes are showed by the release.
     */
    static final public int    RELEASE       = 1;
    
    /**
     * Append to show the current state of development. This probably will be
     * alpha, beta or rcn.
     */
    static final public String STATE         = "alpha";
    
    /**
     * Build the complete string version
     * 
     * @return The version in string format.
     */
    static String getVersion() {
        return MAJOR_VERSION + "." + MAJOR_VERSION + "." + MINOR_VERSION + "-"
                + STATE;
    }
    
}
