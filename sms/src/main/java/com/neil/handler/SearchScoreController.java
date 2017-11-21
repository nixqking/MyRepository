package com.neil.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neil.pojo.Course;
import com.neil.pojo.Sc;
import com.neil.pojo.Student;
import com.neil.serviceImpl.SearchScoreServiceImpl;
import com.neil.tools.UserUtil;

@Controller
public class SearchScoreController {
	@Autowired
	SearchScoreServiceImpl sssi;

	@RequestMapping("/searchScore")
	public String search(HttpServletRequest req, String search) {
		if (req.getSession().getAttribute("student") != null) {
			Sc sc = new Sc();
			sc.setSno(((Student) req.getSession().getAttribute("student")).getSno());
			if (!UserUtil.isNum(search)) {
				Course course = new Course();
				course.setCname(search);
				sc.setCourse(course);
			} else {
				sc.setCno(search);
			}
			try {
				List<Sc> result = sssi.SearchScore(sc);
				if (result == null || result.size() == 0)
					return "searchError";
				else {
					req.getSession().setAttribute("result", result);
					return "searchScore";
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "searchError";
			}
		} else {
			req.getSession().invalidate();
			req.getSession().setAttribute("state", "error");
			return "index";
		}
	}
}
