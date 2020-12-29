package org.libermundi.frostgrave.services.warband.impl;

import lombok.extern.slf4j.Slf4j;
import org.libermundi.frostgrave.domain.jpa.warband.School;
import org.libermundi.frostgrave.domain.jpa.warband.Wizard;
import org.libermundi.frostgrave.repositories.warband.WizardRepository;
import org.libermundi.frostgrave.services.base.impl.AbstractServiceImpl;
import org.libermundi.frostgrave.services.warband.WizardService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Slf4j
@Service("WizardService")
@Transactional(rollbackFor = Exception.class, propagation= Propagation.REQUIRED)
public class WizardServiceImpl extends AbstractServiceImpl<Wizard> implements WizardService{

    public WizardServiceImpl (WizardRepository wizardRepository) {
        setRepository(wizardRepository, Wizard.class);
    }

    @Override
    public void initData() {
        //Nothing to do here
    }
}
