package org.libermundi.frostgrave.domain.jpa.base;


public interface CreatedOrUpdatedBy {

    String getCreatedBy();

    void setCreatedBy(String username);
    
    String getUpdatedBy();

    void setUpdatedBy(String username);
}
