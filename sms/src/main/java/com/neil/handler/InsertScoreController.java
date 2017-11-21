package com.neil.handler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neil.pojo.Course;
import com.neil.pojo.Sc;
import com.neil.serviceImpl.InsertScoreServiceImpl;

@Controller
public class InsertScoreController {
	@Autowired
	InsertScoreServiceImpl issi;

	@Transactional
	@RequestMapping(value = "/insertScore", method = RequestMethod.POST)
	public String insertScore(HttpServletRequest req, Sc sc) {
		@SuppressWarnings("unchecked")
		ArrayList<Course> tInfo = (ArrayList<Course>) req.getSession().getAttribute("teacherInfo");
		boolean isPass = false;
		if (tInfo != null) {
			for (Course course : tInfo) {
				/* System.out.println(course.getCno()); */
				if (sc.getCno().equals(course.getCno()))
					isPass = true;
			}
		}
		if (req.getSession().getAttribute("teacher") != null && isPass) {
			try {
				issi.insert(sc);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				req.setAttribute("insretError", sc);
				return "insretError";
			}
			return "insretSucceed";
		} else if (req.getSession().getAttribute("teacher") != null) {
			req.setAttribute("insretError", sc);
			return "insretError";
		} else {
			req.getSession().invalidate();
			req.getSession().setAttribute("Tstate", "logout");
			return "index";
		}

	}

	@RequestMapping(value = "/insertScore", method = RequestMethod.GET)
	public String insertScore(HttpServletRequest req) {
		if (req.getSession().getAttribute("teacher") != null)
			return "insertScore";
		else {
			req.getSession().invalidate();
			req.getSession().setAttribute("Tstate", "logout");
			return "index";
		}
	}
}
