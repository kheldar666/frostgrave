package org.libermundi.frostgrave.services.warband.impl;

import lombok.extern.slf4j.Slf4j;
import org.libermundi.frostgrave.domain.jpa.warband.Apprentice;

import org.libermundi.frostgrave.domain.jpa.warband.Soldier;
import org.libermundi.frostgrave.repositories.warband.ApprenticeRepository;
import org.libermundi.frostgrave.repositories.warband.SoldierRepository;
import org.libermundi.frostgrave.services.base.impl.AbstractServiceImpl;
import org.libermundi.frostgrave.services.warband.ApprenticeService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service("ApprenticeService")
@Transactional(rollbackFor = Exception.class, propagation= Propagation.REQUIRED)
public class ApprenticeServiceImpl extends AbstractServiceImpl<Apprentice> implements ApprenticeService {

    public ApprenticeServiceImpl (ApprenticeRepository apprenticeRepository) {
        setRepository(apprenticeRepository, Apprentice.class);
    }

    @Override
    public void initData() {
        //Nothing to do here
    }
}
