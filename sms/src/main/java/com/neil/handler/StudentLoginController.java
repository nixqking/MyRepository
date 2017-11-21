package com.neil.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neil.pojo.Student;
import com.neil.serviceImpl.StudentLoginService;
import com.neil.tools.UserUtil;

@Controller
public class StudentLoginController {
	@Autowired
	StudentLoginService sLogin;

	@RequestMapping(value = "/studentlogin", method = RequestMethod.POST)
	public String studentlogin(Student student, HttpServletRequest req) {
		// 获取表单中的token值
		String token = req.getParameter("token");
		// 获取session中的token值
		String sessionToken = (String) req.getSession().getAttribute("TOKEN_IN_SESSION");
		/* System.out.println("token:" + token + "  stoken:" + sessionToken); */
		if (token != null && token.equals(sessionToken)) {// 说明令牌相同
			UserUtil.assertNotNull(student);
			String p = (String) UserUtil.assertNotNull(sLogin.login(student).getPassword());
			if (p.equals(UserUtil.getMD5(student.getPassword()))) {
				req.getSession().setAttribute("student", sLogin.login(student));
				return "main";
			}
		}
		req.getSession().invalidate();
		req.getSession().setAttribute("state", "error");
		return "index";

	}

}
