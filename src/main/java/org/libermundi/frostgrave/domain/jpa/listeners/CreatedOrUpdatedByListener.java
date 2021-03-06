package org.libermundi.frostgrave.domain.jpa.listeners;

import org.libermundi.frostgrave.domain.jpa.base.CreatedOrUpdatedBy;
import org.libermundi.frostgrave.constants.SecurityConstants;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class CreatedOrUpdatedByListener {
	@PrePersist
	public void setCreatedBy(CreatedOrUpdatedBy c) {
		String username = getCurrentUsername();
		c.setCreatedBy(username);
		c.setUpdatedBy(username);
	}

	@PreUpdate
	public void setUpdatedBy(CreatedOrUpdatedBy c) {
		String username = getCurrentUsername();
		c.setUpdatedBy(username);
	}

	/**
	 * Try to get the current logged in user. If he cannot get logged in user
	 * in any context, he will return <b>__SYSTEM__</b> as default
	 *
	 * @return the login name of logged in user.
	 * */

	private static String getCurrentUsername() {

		UserDetails userDetails = getUserDetails(SecurityContextHolder.getContext());

		if (userDetails == null || userDetails.getUsername().isEmpty()) {
			return SecurityConstants.USERNAME_SYSTEM; // return System as default.
		}

		return userDetails.getUsername();
	}

	private static UserDetails getUserDetails(SecurityContext context) {
		try {
			Object principle = context.getAuthentication().getPrincipal();
			if (principle != null && principle instanceof UserDetails) {
				return (UserDetails) principle;
			}
			return null;
		} catch (NullPointerException e) {
			return null;
		}
	}
}
