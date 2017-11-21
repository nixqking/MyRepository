package com.neil.handler;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neil.serviceImpl.StudentPasswordUpdateServiceImpl;

@Controller
public class StudentPasswordUpdateController {
	@Autowired
	StudentPasswordUpdateServiceImpl s;

	@RequestMapping(value = "/spu", method = RequestMethod.POST)
	public String updatePassword(HttpServletRequest req, String sno, String newPassword, String oldPassword,
			String repeatPassword) {
		/* System.out.println(req.getSession().getAttribute("student")); */
		String to = "error";
		try {
			to = s.updateStudentPassword(sno, newPassword, oldPassword, repeatPassword);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// req.getSession().invalidate();
		if (to != null && to.equals("index")) {
			req.getSession().invalidate();
			req.getSession().setAttribute("state", "updateSucceed");
		}
		return to;

	}

	@RequestMapping(value = "/spu", method = RequestMethod.GET)
	public String updatePassword(HttpServletRequest req) {
		if (req.getSession().getAttribute("student") != null)
			return "updatePassword";
		else {
			req.getSession().invalidate();
			req.getSession().setAttribute("state", "logout");
			return "index";
		}
	}

}
