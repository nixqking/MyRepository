package com.neil.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neil.pojo.Course;
import com.neil.pojo.Sc;
import com.neil.pojo.Student;
import com.neil.pojo.Teacher;
import com.neil.serviceImpl.SearchStudentScoreServiceImpl;
import com.neil.tools.UserUtil;

@Controller
public class SearchStudentScoreController {
	@Autowired
	SearchStudentScoreServiceImpl ssssi;

	@RequestMapping("/searchStudentScore")
	public String search(HttpServletRequest req, String search) {
		if (req.getSession().getAttribute("teacher") != null) {
			Sc sc = new Sc();
			Course course = new Course();
			course.setTno(((Teacher) req.getSession().getAttribute("teacher")).getTno());
			sc.setCourse(course);
			if (UserUtil.isNum(search)) {
				sc.setSno(search);
			} else {
				Student student = new Student();
				student.setSname(search);
				sc.setStudent(student);
			}
			try {
				List<Sc> result = ssssi.searchStudentScore(sc);
				if (result == null || result.size() == 0)
					return "searchError";
				else {
					req.getSession().setAttribute("sResult", result);
					return "searchStudentScore";
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "searchError";
			}

		} else {
			req.getSession().invalidate();
			req.getSession().setAttribute("Tstate", "error");
			return "index";
		}
	}
}
