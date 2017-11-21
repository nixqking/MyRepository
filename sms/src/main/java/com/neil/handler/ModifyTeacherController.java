package com.neil.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neil.pojo.Teacher;
import com.neil.serviceImpl.ModifyTeacherServiceImpl;

@Controller
public class ModifyTeacherController {
	@Autowired
	ModifyTeacherServiceImpl mtsi;

	@RequestMapping(value = "/modifyTeacher", method = RequestMethod.GET)
	public String modify(HttpServletRequest req, Teacher teacher, Model model) {
		if (req.getSession().getAttribute("administrator") != null) {
			model.addAttribute("Teacher", teacher);
			return "modifyTeacher";
		} else {
			req.getSession().invalidate();
			req.getSession().setAttribute("Astate", "logout");
			return "administratorLogin";
		}
	}

	@RequestMapping(value = "/modifyTeacher", method = RequestMethod.POST)
	public String modifyPost(HttpServletRequest req, Teacher teacher) {
		if (req.getSession().getAttribute("administrator") != null) {
			int i = -1;
			try {
				i = mtsi.modifyTeacher(teacher);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (i < 1) {
				req.setAttribute("modifyType", "modifyTeacher");
				return "modifyFailed";
			}
			req.setAttribute("modifyType", "modifyTeacher");
			return "modifySucceed";
		} else {
			req.getSession().invalidate();
			req.getSession().setAttribute("Astate", "logout");
			return "administratorLogin";
		}
	}
}
