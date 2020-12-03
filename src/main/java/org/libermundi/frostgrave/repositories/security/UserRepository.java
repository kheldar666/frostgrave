package org.libermundi.frostgrave.repositories.security;

import org.libermundi.frostgrave.domain.jpa.security.User;
import org.libermundi.frostgrave.repositories.base.UndeletableRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends UndeletableRepository<User, Long> {

	Optional<User> findByUsername(String username);

	Optional<User>  findByNickName(String nickname);

	Optional<User>  findByUid(String uid);

	Optional<User>  findByEmail(String email);

}
