package org.libermundi.frostgrave.repositories.security;

import org.libermundi.frostgrave.domain.jpa.security.RememberMeToken;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RememberMeTokenRepository extends CrudRepository<RememberMeToken, Long> {
	Optional<RememberMeToken> findBySeries(String seriesId);
	
	Iterable<RememberMeToken> findAllByUsername(String username);

}
