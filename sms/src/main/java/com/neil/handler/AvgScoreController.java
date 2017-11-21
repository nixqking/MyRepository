package com.neil.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neil.pojo.Course;
import com.neil.pojo.Teacher;
import com.neil.serviceImpl.AvgScoreServiceImpl;

@Controller
public class AvgScoreController {
	@Autowired
	AvgScoreServiceImpl assi;

	@RequestMapping("/avgScore")
	public String avgScore(HttpServletRequest req, Course course, Model model) {
		if (req.getSession().getAttribute("teacher") != null) {
			try {
				course.setTno(((Teacher) req.getSession().getAttribute("teacher")).getTno());
				model.addAttribute("cModel", course);
				req.getSession().setAttribute("cInfo", assi.avgScore(course));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "avgScore";
		} else {
			req.getSession().invalidate();
			req.getSession().setAttribute("Tstate", "logout");
			return "index";
		}
	}
}
