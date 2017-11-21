package com.neil.handler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.neil.pojo.Course;
import com.neil.pojo.Student;
import com.neil.serviceImpl.QueryCourseServiceImpl;

@Controller
public class QueryCourseController {
	@Autowired
	QueryCourseServiceImpl qcsi;
	String sno;

	@RequestMapping(value = "/querycourse")
	public String queryCourse(HttpServletRequest req, @RequestParam(defaultValue = "1") Integer pageNum) {
		ArrayList<Course> al = null;
		if (req.getSession().getAttribute("student") != null
				&& ((Student) req.getSession().getAttribute("student")).getSno() != null) {
			sno = ((Student) req.getSession().getAttribute("student")).getSno();
			try {
				al = (ArrayList<Course>) qcsi.queryCourse(req, sno, pageNum);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.getSession().setAttribute("course", al);
			return "queryCourse";
		} else {
			req.getSession().invalidate();
			req.getSession().setAttribute("state", "logout");
			return "index";
		}
	}
}
