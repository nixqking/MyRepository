package com.neil.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neil.mapper.CourseMapper;
import com.neil.pojo.Teacher;
import com.neil.serviceImpl.TeacherLoginService;
import com.neil.tools.UserUtil;

@Controller
public class TeacherLoginController {
	@Autowired
	TeacherLoginService tLogin;
	@Autowired
	CourseMapper cm;

	@RequestMapping(value = "/teacherlogin", method = RequestMethod.POST)
	public String teacherlogin(Teacher teacher, HttpServletRequest req) {
		// 获取表单中的token值
		String token = req.getParameter("token");
		// 获取session中的token值
		String sessionToken = (String) req.getSession().getAttribute("TOKEN_IN_SESSION");
		/* System.out.println("token:" + token + "  stoken:" + sessionToken); */
		if (token != null && token.equals(sessionToken)) {
			UserUtil.assertNotNull(teacher);
			String t = (String) UserUtil.assertNotNull(tLogin.login(teacher).getPassword());
			if (t.equals(UserUtil.getMD5(teacher.getPassword()))) {
				req.getSession().setAttribute("teacher", tLogin.login(teacher));
				req.getSession().setAttribute("teacherInfo", cm.queryTeacherCourse(teacher.getTno()));
				return "Tmain";
			}
		}
		req.getSession().invalidate();
		req.getSession().setAttribute("Tstate", "error");
		return "index";

	}
}
