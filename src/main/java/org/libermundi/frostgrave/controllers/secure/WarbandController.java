package org.libermundi.frostgrave.controllers.secure;

import org.libermundi.frostgrave.domain.jpa.warband.Warband;
import org.libermundi.frostgrave.services.warband.WarbandService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WarbandController {

    private WarbandService warbandService;

    public WarbandController(WarbandService warbandService) {
        this.warbandService = warbandService;

    }

    @GetMapping("/secure/warband/{warband}")
    public String sheet(Model model, @PathVariable Warband warband) {
        model.addAttribute("warband",warband);
        return "site/secure/warband/sheet";
    }
}
