package com.neil.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QueryTeacherController {
	@RequestMapping("/queryTeacher")
	public String queryStudent() {

		return "userInfo";
	}
}
