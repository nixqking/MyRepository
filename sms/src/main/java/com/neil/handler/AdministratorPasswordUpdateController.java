package com.neil.handler;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neil.serviceImpl.AdministratorPasswordUpdateServiceImpl;

@Controller
public class AdministratorPasswordUpdateController {
	@Autowired
	AdministratorPasswordUpdateServiceImpl apusi;

	@RequestMapping(value = "/apu", method = RequestMethod.POST)
	public String updatePassword(HttpServletRequest req, String account, String newPassword, String oldPassword,
			String repeatPassword) {
		if (req.getSession().getAttribute("administrator") != null) {
			String to = "error";
			try {
				to = apusi.updateAdministratorPassword(account, newPassword, oldPassword, repeatPassword);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// req.getSession().invalidate();
			if (to != null && to.equals("administratorLogin")) {
				req.getSession().invalidate();
				req.getSession().setAttribute("Astate", "updateSucceed");
			}
			return to;
		} else {
			req.getSession().invalidate();
			req.getSession().setAttribute("Astate", "logout");
			return "administratorLogin";
		}
	}

	@RequestMapping(value = "/apu", method = RequestMethod.GET)
	public String updatePassword(HttpServletRequest req) {
		if (req.getSession().getAttribute("administrator") != null)
			return "updatePassword";
		else {
			req.getSession().invalidate();
			req.getSession().setAttribute("Astate", "logout");
			return "administratorLogin";
		}
	}

}
