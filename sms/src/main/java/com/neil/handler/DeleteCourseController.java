package com.neil.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neil.serviceImpl.DeleteCourseServiceImpl;

@Controller
public class DeleteCourseController {
	@Autowired
	DeleteCourseServiceImpl dcsi;

	@RequestMapping("/deleteCourse")
	public String delete(HttpServletRequest req, String cno) {
		if (req.getSession().getAttribute("administrator") != null) {
			int i = -1;
			try {
				i = dcsi.delete(cno);
			} catch (Exception e) {
				e.printStackTrace();
				req.setAttribute("deleteType", "deleteCourse");
				return "deleteFailed";
			}
			if (i < 1) {
				req.setAttribute("deleteType", "deleteCourse");
				return "deleteFailed";
			}
			req.setAttribute("deleteType", "deleteCourse");
			return "deleteSucceed";
		} else {
			req.getSession().invalidate();
			req.getSession().setAttribute("Astate", "logout");
			return "administratorLogin";
		}

	}
}
