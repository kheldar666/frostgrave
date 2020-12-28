package org.libermundi.frostgrave.controllers.secure;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("SecureIndexController")
public class IndexController {
    @GetMapping(value={"/secure/","/secure/index"})
    public String getIndexPage() {
        return "site/secure/index";
    }




}
