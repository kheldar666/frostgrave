package org.libermundi.frostgrave.services.warband;

import org.libermundi.frostgrave.domain.jpa.campaign.Campaign;
import org.libermundi.frostgrave.domain.jpa.security.User;
import org.libermundi.frostgrave.domain.jpa.warband.Warband;
import org.libermundi.frostgrave.services.base.BaseService;

import java.util.List;

public interface WarbandService  extends BaseService<Warband> {

    List<Campaign> findCampaignByUser(User player);

}
