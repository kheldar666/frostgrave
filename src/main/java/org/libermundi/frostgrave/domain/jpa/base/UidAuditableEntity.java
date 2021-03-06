package org.libermundi.frostgrave.domain.jpa.base;

import lombok.Getter;
import lombok.Setter;
import org.libermundi.frostgrave.domain.jpa.listeners.UidListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(UidListener.class)
public abstract class UidAuditableEntity extends AuditableEntity implements Uid {
	private String uid;

}
