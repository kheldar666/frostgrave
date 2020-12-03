package org.libermundi.frostgrave.domain.jpa.base;

public interface Enabled {

    /**
     * Check if object is enabled.
     * 
     * @return true when object is enabled
     */
    boolean isEnabled();

    /**
     * Set object's enabled flag.
     * 
     * @param enabled
     *            value of enabled flag
     */
    void setEnabled(boolean enabled);
}