package com.neil.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neil.pojo.Administrator;
import com.neil.serviceImpl.AdministratorLoginService;
import com.neil.tools.UserUtil;

@Controller
public class AdministratorLoginController {
	@Autowired
	AdministratorLoginService als;

	@RequestMapping(value = "/administratorLogin", method = RequestMethod.POST)
	public String login(Administrator administrator, HttpServletRequest req) {
		// 获取表单中的token值
		String token = req.getParameter("token_admini");
		// 获取session中的token值
		String sessionToken = (String) req.getSession().getAttribute("TOKEN_IN_SESSION_ADMINI");
		/* System.out.println("token:" + token + "  stoken:" + sessionToken); */
		if (token != null && token.equals(sessionToken)) {
			UserUtil.assertNotNull(administrator);
			String t;
			try {
				t = (String) UserUtil.assertNotNull(als.login(administrator).getPassword());
				if (t.equals(UserUtil.getMD5(administrator.getPassword()))) {
					req.getSession().setAttribute("administrator", als.login(administrator));
					return "Amain";
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		req.getSession().invalidate();
		req.getSession().setAttribute("Astate", "error");
		return "administratorLogin";
	}

	@RequestMapping(value = "/administratorLogin", method = RequestMethod.GET)
	public String login() {
		return "administratorLogin";
	}
}
