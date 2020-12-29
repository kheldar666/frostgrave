package org.libermundi.frostgrave.services.campaign.impl;

import lombok.extern.slf4j.Slf4j;
import org.libermundi.frostgrave.domain.jpa.campaign.Campaign;
import org.libermundi.frostgrave.domain.jpa.security.User;
import org.libermundi.frostgrave.repositories.campaign.CampaignRepository;
import org.libermundi.frostgrave.services.base.impl.AbstractServiceImpl;
import org.libermundi.frostgrave.services.campaign.CampaignService;
import org.libermundi.frostgrave.services.security.SecurityService;
import org.libermundi.frostgrave.services.security.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service("CampaignService")
@Transactional(rollbackFor = Exception.class, propagation= Propagation.REQUIRED)
public class CampaignServiceImpl extends AbstractServiceImpl<Campaign> implements CampaignService {
    private final UserService userService;

    private final SecurityService securityService;

    public CampaignServiceImpl(UserService userService, SecurityService securityService, CampaignRepository campaignRepository) {
        setRepository(campaignRepository,Campaign.class);
        this.userService = userService;
        this.securityService = securityService;
    }

    @Override
    public Campaign findByName(String name)    {
        return getResultfromOptional(((CampaignRepository)getRepository()).findByName(name));
    }

    @Override
    public void initData() {
        if(log.isDebugEnabled()){
            log.debug("Initializing Campaign Data");
        }

        User admin = userService.findByUsername("admin");

        Campaign campaign1 = new Campaign();
            campaign1.setName("Demo Campaign");
            campaign1.setAdmin(admin);

        getRepository().save(campaign1);
    }
}
