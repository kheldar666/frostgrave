package org.libermundi.frostgrave.repositories.warband;

import org.libermundi.frostgrave.domain.jpa.warband.Soldier;
import org.libermundi.frostgrave.repositories.base.UndeletableRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoldierRepository extends UndeletableRepository<Soldier, Long> {

}
