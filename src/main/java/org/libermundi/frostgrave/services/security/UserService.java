package org.libermundi.frostgrave.services.security;

import org.libermundi.frostgrave.domain.jpa.security.User;
import org.libermundi.frostgrave.services.base.BaseService;

/**
 * Interface of the User Manager BaseService
 *
 */
public interface UserService extends BaseService<User> {

	/**
	 * Getter of User
	 * @return User
	 */
	User getUser();
	
	/**
	 * Getter of User by his Username
	 * @param username
	 * @return User
	 */
	User findByUsername(String username);
	
	
	/**
	 * Getter of User by his Nickname
	 * @param nickname
	 * @return User
	 */
	User findByNickName(String nickname);
	
	
	/**
	 * Get a user by his UID
	 * @param uid
	 * @return
	 */
	User findByUID(String uid);
	
	boolean isUsernameAvailable(String username);

	boolean isNickNameAvailable(String nickname);
	
	boolean isEmailAvailable(String email);
	
	String getUniqueNickName(String nickname);

	/**
	 * Get a user by his Email adress
	 * @param email
	 * @return User
	 */
	User findByEmail(String email);



	
}
