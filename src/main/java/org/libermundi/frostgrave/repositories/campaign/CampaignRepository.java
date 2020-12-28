package org.libermundi.frostgrave.repositories.campaign;

import org.libermundi.frostgrave.domain.jpa.campaign.Campaign;
import org.libermundi.frostgrave.repositories.base.UndeletableRepository;

import java.util.Optional;

public interface CampaignRepository extends UndeletableRepository<Campaign, Long> {
    Optional<Campaign> findByName(String name);
}
