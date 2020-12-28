package org.libermundi.frostgrave.controllers.advice;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.libermundi.frostgrave.domain.jpa.campaign.Campaign;
import org.libermundi.frostgrave.services.security.SecurityService;
import org.libermundi.frostgrave.services.warband.WarbandService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Slf4j
@ControllerAdvice
public class MenuAdvice {

    private final WarbandService warbandService;

    private final SecurityService securityService;

    public MenuAdvice(WarbandService warbandService, SecurityService securityService) {
        this.warbandService = warbandService;
        this.securityService = securityService;
    }

    @ModelAttribute
    public void addMenus(Model model, HttpServletRequest request) {

        if (log.isDebugEnabled()) {
            log.debug("Loading Navigations");
        }
        HashMap<String,Object> topNav = Maps.newHashMap();

        if(securityService.isLoggedIn()) {
            String currentURI = request.getRequestURI();
            if (currentURI.contains("/secure/campaign") && !currentURI.equals("/secure/campaign/create")) {
                // When the user is within a Campaign


            } else {
                //When User is LoggedIn but using the rest of the site
                List<Campaign> chronicles = warbandService.findCampaignByUser(securityService.getCurrentUser());

                topNav.put("chronicles", chronicles);
            }

        }

        model.addAttribute("_topnav", topNav);

    }
}
