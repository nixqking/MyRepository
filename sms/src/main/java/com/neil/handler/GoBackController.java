package com.neil.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GoBackController {
	@RequestMapping("/goback")
	public String goBack(HttpServletRequest req) {
		if (req.getSession().getAttribute("teacher") != null)
			return "Tmain";
		else if (req.getSession().getAttribute("student") != null)
			return "main";
		else if (req.getSession().getAttribute("administrator") != null)
			return "Amain";
		else {
			req.getSession().invalidate();
			return "index";
		}

	}
}
