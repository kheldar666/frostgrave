package org.libermundi.frostgrave.services.security;

import org.libermundi.frostgrave.domain.jpa.security.Authority;
import org.libermundi.frostgrave.domain.jpa.security.User;
import org.libermundi.frostgrave.services.base.BaseService;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public interface AuthorityService extends BaseService<Authority> {
    Authority findByAuthority(String authority);
    /**
     * Check if the {@link Authentication} provided is in the Collection of authorities either directly or through transitive relation
     * @param authorities
     * @param authority
     * @return true if
     *
     * @see RoleHierarchy#getReachableGrantedAuthorities(Collection)
     */
    boolean hasReachableAuthority(Collection<? extends GrantedAuthority> authorities, GrantedAuthority authority);

    /**
     * @see AuthorityService#hasReachableAuthority(Collection, GrantedAuthority)
     * @param user
     * @param authority
     * @return
     */
    boolean hasReachableAuthority(User user, GrantedAuthority authority);
}
