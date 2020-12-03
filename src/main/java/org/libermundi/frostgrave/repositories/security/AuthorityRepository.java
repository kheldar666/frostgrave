package org.libermundi.frostgrave.repositories.security;

import org.libermundi.frostgrave.domain.jpa.security.Authority;
import org.libermundi.frostgrave.repositories.base.UndeletableRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorityRepository extends UndeletableRepository<Authority, Long> {
	
	Optional<Authority> findByAuthority(String authority);

}
