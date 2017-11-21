package com.neil.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.neil.pojo.Course;
import com.neil.serviceImpl.AddCourseServiceImpl;

@Controller
public class AddCourseController {
	@Autowired
	AddCourseServiceImpl atsi;

	@RequestMapping(value = "/addCourse", method = RequestMethod.GET)
	public String add(HttpServletRequest req) {
		if (req.getSession().getAttribute("administrator") != null) {
			return "addCourse";
		} else {
			req.getSession().invalidate();
			req.getSession().setAttribute("Astate", "logout");
			return "administratorLogin";
		}
	}

	@RequestMapping(value = "/addCourse", method = RequestMethod.POST)
	public String addPost(HttpServletRequest req,Course course) {
		if (req.getSession().getAttribute("administrator") != null) {
			int i = -1;
			try {
				i = atsi.addCourse(course);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (i < 1) {
				req.setAttribute("addType", "addCourse");
				return "addFailed";
			}
			req.setAttribute("addType", "addCourse");
			return "addSucceed";
		} else {
			req.getSession().invalidate();
			req.getSession().setAttribute("Astate", "logout");
			return "administratorLogin";
		}
	}
}
