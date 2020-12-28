package org.libermundi.frostgrave.services.warband.impl;

import lombok.extern.slf4j.Slf4j;
import org.libermundi.frostgrave.domain.jpa.campaign.Campaign;
import org.libermundi.frostgrave.domain.jpa.security.User;
import org.libermundi.frostgrave.domain.jpa.warband.Warband;
import org.libermundi.frostgrave.repositories.warband.WarbandRepository;
import org.libermundi.frostgrave.services.base.impl.AbstractServiceImpl;
import org.libermundi.frostgrave.services.security.UserService;
import org.libermundi.frostgrave.services.warband.WarbandService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service("WarbandService")
@Transactional(rollbackFor = Exception.class, propagation= Propagation.REQUIRED)
public class WarbandServiceImpl extends AbstractServiceImpl<Warband> implements WarbandService {
    private final UserService userService;

    private final WarbandService warbandService;

    public WarbandServiceImpl(UserService userService, WarbandService warbandService) {
        this.userService = userService;
        this.warbandService= warbandService;
    }

    @Override
    public List<Campaign> findCampaignByUser(User player) {
        User p = userService.findById(player.getId());
        return ((WarbandRepository)getRepository()).findCampaignByPlayer(p);
    }

    @Override
    public Warband createNew() {
        Warband warband = new Warband();

        return warband;
    }

    @Override
    public void initData() {

    }
}
