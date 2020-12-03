package org.libermundi.frostgrave.domain.jpa.listeners;

import org.libermundi.frostgrave.domain.jpa.security.User;
import org.libermundi.frostgrave.utils.SecurityUtils;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class PasswordListener {
	@PrePersist
	@PreUpdate
	public void setPassword(User user) {
		String password = user.getPassword();
		if(!SecurityUtils.isValid(password)) {
			user.setPassword(SecurityUtils.encodePassword(password));
		}
	}
}
