package org.libermundi.frostgrave.domain.jpa.base;

import java.util.Date;

/**
 * Interface marks class which can be historical 
 *
 */
public interface Timestampable {
    
    Date getCreatedDate();
    
    void setCreatedDate(Date createdDate);
    
    Date getUpdatedDate();
    
    void setUpdatedDate(Date updatedDate);

}