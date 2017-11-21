package com.neil.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neil.pojo.Student;
import com.neil.serviceImpl.AddStudentServiceImpl;
import com.neil.tools.UserUtil;

@Controller
public class AddStudentController {
	@Autowired
	AddStudentServiceImpl assi;

	@RequestMapping(value = "/addStudent", method = RequestMethod.GET)
	public String add(HttpServletRequest req) {
		if (req.getSession().getAttribute("administrator") != null) {
			return "addStudent";
		} else {
			req.getSession().invalidate();
			req.getSession().setAttribute("Astate", "logout");
			return "administratorLogin";
		}
	}

	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public String addPost(HttpServletRequest req, Student student) {
		if (req.getSession().getAttribute("administrator") != null) {
			student.setPassword(UserUtil.getMD5(student.getSno()));
			int i = -1;
			try {
				i = assi.addStudent(student);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (i < 1) {
				req.setAttribute("addType", "addStudent");
				return "addFailed";
			}
			req.setAttribute("addType", "addStudent");
			return "addSucceed";
		} else {
			req.getSession().invalidate();
			req.getSession().setAttribute("Astate", "logout");
			return "administratorLogin";
		}
	}
}
