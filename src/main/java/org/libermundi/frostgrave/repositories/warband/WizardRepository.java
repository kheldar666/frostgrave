package org.libermundi.frostgrave.repositories.warband;

import org.libermundi.frostgrave.domain.jpa.warband.Wizard;
import org.libermundi.frostgrave.repositories.base.UndeletableRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WizardRepository extends UndeletableRepository<Wizard, Long> {

}
