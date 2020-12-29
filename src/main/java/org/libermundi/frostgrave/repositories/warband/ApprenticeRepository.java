package org.libermundi.frostgrave.repositories.warband;

import org.libermundi.frostgrave.domain.jpa.warband.Apprentice;
import org.libermundi.frostgrave.repositories.base.UndeletableRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApprenticeRepository extends UndeletableRepository<Apprentice, Long> {

}
