package org.libermundi.frostgrave.controllers.advice;

import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@ControllerAdvice
public class ShowDebugAdvice {
	@Value("${spring.profiles.active}")
	private String env;

	@ModelAttribute
    public void showDebug(HttpServletRequest request, @RequestParam(required = false) String showDebug) {
		HttpSession session = request.getSession(Boolean.TRUE);

		//Setting initial value of Session._showDebug
		if(session.getAttribute("_showDebug") == null) {
			if(log.isDebugEnabled()){
				log.debug("Setting default value for Session._showDebug");
			}
			session.setAttribute("_showDebug", Boolean.FALSE);
		}

		if (!Strings.isNullOrEmpty(env) && env.equals("dev")) {
			if(!Strings.isNullOrEmpty(showDebug)) {
				if(log.isDebugEnabled()){
					log.debug("Request parameter 'showDebug' present with the value : " + Boolean.valueOf(showDebug));
					log.debug("Updating Session._showDebug");
				}
				session.setAttribute("_showDebug", Boolean.valueOf(showDebug));
			}
		}
	}
}