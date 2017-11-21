package com.neil.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neil.pojo.Course;
import com.neil.serviceImpl.ModifyCourseServiceImpl;

@Controller
public class ModifyCourseController {
	@Autowired
	ModifyCourseServiceImpl mcsi;

	@RequestMapping(value = "/modifyCourse", method = RequestMethod.GET)
	public String modify(HttpServletRequest req, Course course, Model model) {
		if (req.getSession().getAttribute("administrator") != null) {
			model.addAttribute("course", course);
			return "modifyCourse";
		} else {
			req.getSession().invalidate();
			req.getSession().setAttribute("Astate", "logout");
			return "administratorLogin";
		}
	}

	@RequestMapping(value = "/modifyCourse", method = RequestMethod.POST)
	public String modifyPost(HttpServletRequest req, Course course) {
		if (req.getSession().getAttribute("administrator") != null) {
			int i = -1;
			try {
				i = mcsi.modifyCourse(course);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (i < 1) {
				req.setAttribute("modifyType", "modifyCourse");
				return "modifyFailed";
			}
			req.setAttribute("modifyType", "modifyCourse");
			return "modifySucceed";
		} else {
			req.getSession().invalidate();
			req.getSession().setAttribute("Astate", "logout");
			return "administratorLogin";
		}
	}
}
