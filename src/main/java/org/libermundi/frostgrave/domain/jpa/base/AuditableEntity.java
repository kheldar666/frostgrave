package org.libermundi.frostgrave.domain.jpa.base;


import lombok.Getter;
import lombok.Setter;
import org.libermundi.frostgrave.domain.jpa.listeners.CreatedOrUpdatedByListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(CreatedOrUpdatedByListener.class)
public abstract class AuditableEntity extends org.libermundi.frostgrave.domain.jpa.base.StatefulEntity implements CreatedOrUpdatedBy {
    private String createdBy;
    private String updatedBy;
}
