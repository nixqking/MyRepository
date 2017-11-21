package com.neil.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.neil.serviceImpl.ManageCourseServiceImpl;

@Controller
public class ManageCourseController {
	@Autowired
	ManageCourseServiceImpl mcsi;

	@RequestMapping(value = "/manageCourse")
	public String manage(HttpServletRequest req, @RequestParam(defaultValue = "1") Integer pageNum) {
		if (req.getSession().getAttribute("administrator") != null) {
			try {
				req.setAttribute("courseInfoList", mcsi.manage(req, pageNum));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "manageCourse";
		} else {
			req.getSession().invalidate();
			req.getSession().setAttribute("Astate", "logout");
			return "administratorLogin";
		}

	}
}
