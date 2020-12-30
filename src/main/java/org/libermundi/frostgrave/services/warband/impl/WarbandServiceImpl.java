package org.libermundi.frostgrave.services.warband.impl;

import lombok.extern.slf4j.Slf4j;
import org.libermundi.frostgrave.domain.jpa.campaign.Campaign;
import org.libermundi.frostgrave.domain.jpa.security.User;
import org.libermundi.frostgrave.domain.jpa.warband.*;
import org.libermundi.frostgrave.repositories.warband.WarbandRepository;
import org.libermundi.frostgrave.services.base.impl.AbstractServiceImpl;
import org.libermundi.frostgrave.services.campaign.CampaignService;
import org.libermundi.frostgrave.services.security.SecurityService;
import org.libermundi.frostgrave.services.security.UserService;
import org.libermundi.frostgrave.services.warband.ApprenticeService;
import org.libermundi.frostgrave.services.warband.SoldierService;
import org.libermundi.frostgrave.services.warband.WarbandService;
import org.libermundi.frostgrave.services.warband.WizardService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Slf4j
@Service("WarbandService")
@Transactional(rollbackFor = Exception.class, propagation= Propagation.REQUIRED)
public class WarbandServiceImpl extends AbstractServiceImpl<Warband> implements WarbandService {
    private final UserService userService;

    private final CampaignService campaignService;
    private final WizardService wizardService;
    private final ApprenticeService apprenticeService;
    private final SecurityService securityService;

    public WarbandServiceImpl(UserService userService, CampaignService campaignService,
                              WizardService wizardService, ApprenticeService apprenticeService,
                              SoldierService soldierService, WarbandRepository warbandRepository,
                              SecurityService securityService) {
        setRepository(warbandRepository, Warband.class);
        this.userService = userService;
        this.campaignService = campaignService;
        this.wizardService = wizardService;
        this.apprenticeService = apprenticeService;
        this.securityService = securityService;

    }

    @Override
    public List<Campaign> findCampaignByUser(User player) {
        User p = userService.findById(player.getId());
        return ((WarbandRepository)getRepository()).findCampaignByPlayer(p);
    }

    @Override
    public void initData() {

        User admin = userService.findByUsername("admin");

        Warband warbandInCampaign = createWarbandInCampaign(admin);
        Warband warbandStandalone = createWarbandStandalone(admin);


        getRepository().save(warbandInCampaign);
        getRepository().save(warbandStandalone);

        securityService.grantReadWriteAcl(admin, warbandInCampaign);
        securityService.grantReadWriteAcl(admin, warbandStandalone);


    }

    private Warband createWarbandStandalone(User player) {
        Warband warbandStandalone = new Warband("The Adepts of Cthulhu", player);

        //First let's create the Wizard
        Wizard wizard = new Wizard("Blafard le Fade", School.NECROMANCY);
        wizardService.save(wizard);

        //Then the Apprentice
        Apprentice apprentice = new Apprentice("Goncale le mou", wizard);
        apprenticeService.save(apprentice);

        warbandStandalone.setWizard(wizard);
        warbandStandalone.setApprentice(apprentice);

        Set<Soldier> soldiers = warbandStandalone.getSoldiers();

        soldiers.add(SoldierFactory.getSoldier(SoldierType.THIEF, warbandStandalone));

        soldiers.add(SoldierFactory.getSoldier(SoldierType.THIEF, warbandStandalone));

        soldiers.add(SoldierFactory.getSoldier(SoldierType.THIEF, warbandStandalone));

        soldiers.add(SoldierFactory.getSoldier(SoldierType.THIEF, warbandStandalone));

        soldiers.add(SoldierFactory.getSoldier(SoldierType.ARCHER, warbandStandalone));

        soldiers.add(SoldierFactory.getSoldier(SoldierType.ARCHER, warbandStandalone));

        soldiers.add(SoldierFactory.getSoldier(SoldierType.TREASUREHUNTER, warbandStandalone));

        soldiers.add(SoldierFactory.getSoldier(SoldierType.TREASUREHUNTER, warbandStandalone));

        return warbandStandalone;

    }

    private Warband createWarbandInCampaign(User player) {
        Warband warbandInCampaign = new Warband("The Ketchup Killers", player);

        warbandInCampaign.setCampaign(campaignService.findByName("Demo Campaign"));

        //First let's create the Wizard
        Wizard wizard = new Wizard("Panadol le Moindre", School.ELEMENTAL);
        wizardService.save(wizard);

        //Then the Apprentice
        Apprentice apprentice = new Apprentice("Goncale le mou", wizard);
        apprenticeService.save(apprentice);

        warbandInCampaign.setWizard(wizard);
        warbandInCampaign.setApprentice(apprentice);

        Set<Soldier> soldiers = warbandInCampaign.getSoldiers();

        soldiers.add(SoldierFactory.getSoldier(SoldierType.THUG, warbandInCampaign));

        soldiers.add(SoldierFactory.getSoldier(SoldierType.THUG, warbandInCampaign));

        soldiers.add(SoldierFactory.getSoldier(SoldierType.THIEF, warbandInCampaign));

        soldiers.add(SoldierFactory.getSoldier(SoldierType.THIEF, warbandInCampaign));

        soldiers.add(SoldierFactory.getSoldier(SoldierType.INFANTRYMAN, warbandInCampaign));

        soldiers.add(SoldierFactory.getSoldier(SoldierType.INFANTRYMAN, warbandInCampaign));

        soldiers.add(SoldierFactory.getSoldier(SoldierType.TREASUREHUNTER, warbandInCampaign));

        soldiers.add(SoldierFactory.getSoldier(SoldierType.TREASUREHUNTER, warbandInCampaign));

        return warbandInCampaign;
    }
}
