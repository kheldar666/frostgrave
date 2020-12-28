package org.libermundi.frostgrave.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.libermundi.frostgrave.services.security.UserService;
import org.libermundi.frostgrave.services.security.AuthorityService;
import org.libermundi.frostgrave.services.security.SecurityService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ApplicationLoader implements ApplicationListener<ContextRefreshedEvent> {

	private final AuthorityService authorityService;
	private final UserService userService;
	private final SecurityService securityService;

	public ApplicationLoader(AuthorityService authorityService, UserService userService, SecurityService securityService) {
		this.authorityService = authorityService;
		this.userService = userService;
		this.securityService = securityService;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		if(userService.count() == 0) {
			if(log.isDebugEnabled()){
				log.debug("Initializing Data for First launch of TheORCS - Frostgrave Manager");
			}

			initData();
		}
	}

	private void initData() {
		securityService.switchUser(securityService.getSystemUserDetails());

		userService.initData();
		authorityService.initData();

		securityService.restoreUser();

	}

}
