package com.neil.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neil.pojo.Student;
import com.neil.serviceImpl.ModifyStudentServiceImpl;

@Controller
public class ModifyStudentController {
	@Autowired
	ModifyStudentServiceImpl mssi;

	@RequestMapping(value = "/modifyStudent", method = RequestMethod.GET)
	public String modify(HttpServletRequest req, Student student, Model model) {
		if (req.getSession().getAttribute("administrator") != null) {
			model.addAttribute("student", student);
			return "modifyStudent";
		} else {
			req.getSession().invalidate();
			req.getSession().setAttribute("Astate", "logout");
			return "administratorLogin";
		}
	}

	@RequestMapping(value = "/modifyStudent", method = RequestMethod.POST)
	public String modifyPost(HttpServletRequest req, Student student) {
		if (req.getSession().getAttribute("administrator") != null) {
			int i = -1;
			try {
				i = mssi.modifyStudent(student);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (i < 1) {
				req.setAttribute("modifyType", "modifyStudent");
				return "modifyFailed";
			}
			req.setAttribute("modifyType", "modifyStudent");
			return "modifySucceed";
		} else {
			req.getSession().invalidate();
			req.getSession().setAttribute("Astate", "logout");
			return "administratorLogin";
		}
	}
}
