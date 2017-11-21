package com.neil.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neil.pojo.Teacher;
import com.neil.serviceImpl.AddTeacherServiceImpl;
import com.neil.tools.UserUtil;

@Controller
public class AddTeacherController {
	@Autowired
	AddTeacherServiceImpl atsi;

	@RequestMapping(value = "/addTeacher", method = RequestMethod.GET)
	public String add(HttpServletRequest req) {
		if (req.getSession().getAttribute("administrator") != null) {
			return "addTeacher";
		} else {
			req.getSession().invalidate();
			req.getSession().setAttribute("Astate", "logout");
			return "administratorLogin";
		}
	}

	@RequestMapping(value = "/addTeacher", method = RequestMethod.POST)
	public String addPost(HttpServletRequest req, Teacher teacher) {
		if (req.getSession().getAttribute("administrator") != null) {
			teacher.setPassword(UserUtil.getMD5(teacher.getTno()));
			int i = -1;
			try {
				i = atsi.addTeacher(teacher);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (i < 1) {
				req.setAttribute("addType", "addTeacher");
				return "addFailed";
			}
			req.setAttribute("addType", "addTeacher");
			return "addSucceed";
		} else {
			req.getSession().invalidate();
			req.getSession().setAttribute("Astate", "logout");
			return "administratorLogin";
		}
	}
}
