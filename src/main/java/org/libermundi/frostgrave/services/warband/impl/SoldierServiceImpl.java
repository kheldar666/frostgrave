package org.libermundi.frostgrave.services.warband.impl;

import lombok.extern.slf4j.Slf4j;
import org.libermundi.frostgrave.domain.jpa.warband.Soldier;
import org.libermundi.frostgrave.repositories.warband.SoldierRepository;
import org.libermundi.frostgrave.services.base.impl.AbstractServiceImpl;
import org.libermundi.frostgrave.services.warband.SoldierService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service("SoldierService")
@Transactional(rollbackFor = Exception.class, propagation= Propagation.REQUIRED)
public class SoldierServiceImpl extends AbstractServiceImpl<Soldier> implements SoldierService {

    public SoldierServiceImpl (SoldierRepository soldierRepository) {
        setRepository(soldierRepository, Soldier.class);
    }

    @Override
    public void initData() {
        //Nothing to do here
    }
}
