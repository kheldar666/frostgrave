package org.libermundi.frostgrave.services.campaign;

import org.libermundi.frostgrave.domain.jpa.campaign.Campaign;
import org.libermundi.frostgrave.services.base.BaseService;

public interface CampaignService extends BaseService<Campaign> {
    Campaign findByName(String name);
}
