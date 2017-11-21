package com.neil.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neil.serviceImpl.TeacherPasswordUpdateServiceImpl;

@Controller
public class TeacherPasswordUpdateController {
	@Autowired
	TeacherPasswordUpdateServiceImpl t;

	@RequestMapping(value = "/tpu", method = RequestMethod.POST)
	public String updatePassword(HttpServletRequest req, String tno, String newPassword, String oldPassword,
			String repeatPassword) {
		/* System.out.println(req.getSession().getAttribute("student")); */
		String to = "error";
		try {
			to = t.updateTeacherPassword(tno, newPassword, oldPassword, repeatPassword);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// req.getSession().invalidate();
		if (to != null && to.equals("index")) {
			req.getSession().invalidate();
			req.getSession().setAttribute("Tstate", "updateSucceed");
		}
		return to;

	}

	@RequestMapping(value = "/tpu", method = RequestMethod.GET)
	public String updatePassword(HttpServletRequest req) {
		if (req.getSession().getAttribute("teacher") != null)
			return "updatePassword";
		else {
			req.getSession().invalidate();
			req.getSession().setAttribute("Tstate", "logout");
			return "index";
		}
	}

}
