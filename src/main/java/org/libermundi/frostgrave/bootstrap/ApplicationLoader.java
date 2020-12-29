package org.libermundi.frostgrave.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.libermundi.frostgrave.services.campaign.CampaignService;
import org.libermundi.frostgrave.services.security.UserService;
import org.libermundi.frostgrave.services.security.AuthorityService;
import org.libermundi.frostgrave.services.security.SecurityService;
import org.libermundi.frostgrave.services.warband.WarbandService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ApplicationLoader implements ApplicationListener<ContextRefreshedEvent> {

	private final AuthorityService authorityService;
	private final UserService userService;
	private final SecurityService securityService;
	private final CampaignService campaignService;
	private final WarbandService warbandService;

	public ApplicationLoader(
			AuthorityService authorityService, UserService userService, SecurityService securityService,
			CampaignService campaignService, WarbandService warbandService) {
		this.authorityService = authorityService;
		this.userService = userService;
		this.securityService = securityService;
		this.campaignService = campaignService;
		this.warbandService = warbandService;
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
		campaignService.initData();
		warbandService.initData();

		securityService.restoreUser();

	}

}
