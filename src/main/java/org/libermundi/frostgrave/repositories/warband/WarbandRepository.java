package org.libermundi.frostgrave.repositories.warband;

import org.libermundi.frostgrave.domain.jpa.campaign.Campaign;
import org.libermundi.frostgrave.domain.jpa.security.User;
import org.libermundi.frostgrave.domain.jpa.warband.Warband;
import org.libermundi.frostgrave.repositories.base.UndeletableRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WarbandRepository extends UndeletableRepository<Warband, Long> {

    @Query("select distinct w.campaign from Warband w where w.player = ?1 order by w.campaign.name")
    List<Campaign> findCampaignByPlayer(User player);

/*    @Query("select w from Warband c where w.player = ?1 and w.Warband = ?2 and c.defaultCharacter = true")
    Character findDefaultCharacter(User player, Chronicle chronicle);

    @Query("select c from Character c where c.player = ?1 and c.chronicle = ?2")
    List<Character> findAllCharactersByAndSort(User player, Chronicle chronicle, Sort sort);

    @Query("select c from Character c where not c.player = ?1 and c.chronicle = ?2")
    List<Character> findAllContactsByAndSort(User player, Chronicle chronicle, Sort sort);*/
}
