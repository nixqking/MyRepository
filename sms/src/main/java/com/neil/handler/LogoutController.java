package com.neil.handler;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {
	@RequestMapping("/logout")
	public String logout(HttpServletRequest req) {
		boolean isSNull = req.getSession().getAttribute("student") == null ? true : false;
		boolean isTNull = req.getSession().getAttribute("teacher") == null ? true : false;
		boolean isANull = req.getSession().getAttribute("administrator") == null ? true : false;
		req.getSession().invalidate();
		if (!isSNull)
			req.getSession().setAttribute("state", "logout");
		else if (!isTNull)
			req.getSession().setAttribute("Tstate", "logout");
		else if (!isANull) {
			req.getSession().setAttribute("Astate", "logout");
			return "administratorLogin";
		}
		return "index";
	}
}
