package org.libermundi.frostgrave.services.security;

import org.libermundi.frostgrave.domain.jpa.security.RememberMeToken;
import org.libermundi.frostgrave.domain.jpa.security.User;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface SecurityService extends UserDetailsService {

	/**
	 * Getter of the User attached to the current Session
	 * @return the current authenticated User
	 */
	User getCurrentUser();

	/**
	 * Gets the {@link UserDetails} in the {@link SecurityContext}. If no UserDetails is defined {@link UserDetails} for the "ANONYMOUS" user.
	 * @see {@link SecurityService#getAnonymousUserDetails()}
	 * @return {@link UserDetails}
	 */
	UserDetails getCurrentUserDetails();

	/**
	 * Getter of the Name of the User attached to the current Session
	 * @return the current authenticated User
	 */

	String getCurrentUsername();

	/**
	 * Check if current {@link User} is logged in
	 * @return true when current user is logged in
	 */
	boolean isLoggedIn();

	/**
	 * Set an {@link Authentication} in the {@link SecurityContext} for the provided {@link User}
	 * @param user
	 * @return corresponding {@link Authentication}
	 */
	Authentication authenticate(User user);

	/**
	 * Set an {@link Authentication} in the {@link SecurityContext} for the provided {@link User}. Allows to
	 * create a {@link } if needed.
	 * @param user
	 * @param rememberMe is true, will create a {@link RememberMeToken} and return the corresponding {@link Cookie}s
	 * @param request
	 * @param response
	 * @return {@link Authentication}
	 */
	Authentication authenticate(User user, boolean rememberMe, HttpServletRequest request, HttpServletResponse response);

	/**
	 * Return {@link UserDetails} for the "SYSTEM" user. Can be stored in the DB or Localy as a static resource
	 * @return "SYSTEM" {@link UserDetails}
	 */
	UserDetails getSystemUserDetails();

	/**
	 * Return {@link UserDetails} for the "ANONYMOUS" user. Can be stored in the DB or Localy as a static resource
	 * @return "SYSTEM" {@link UserDetails}
	 */
	UserDetails getAnonymousUserDetails();

	/**
	 * Allow to Switch from current {@link UserDetails} to the provided one. The {@link UserDetails} will be replace in
	 * the {@link SecurityContext} and the previous one will be kept in order to be restored later with {@link SecurityService#restoreUser()}
	 * @param switchDetails
	 */
	void switchUser(UserDetails switchDetails);

	/**
	 * Try to restore the previous User after a Switch has been done using {@link SecurityService#switchUser(UserDetails)}.
	 * Does nothing is no previous Switch have been done.
	 */
	void restoreUser();

	Authentication getCurrentAuthentication();

	/**
	 * Assign a Role to the User. The Role is supposed to exist in the Database.
	 * @param user
	 * @param role
	 */
	void grantRole(User user, String role);

	/**
	 * The opposite of the previous one :)
	 * @param user
	 * @param role
	 */
	void removeRole(User user, String role);
}
