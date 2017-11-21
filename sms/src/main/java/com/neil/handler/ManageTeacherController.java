package com.neil.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.neil.serviceImpl.ManageTeacherServiceImpl;

@Controller
public class ManageTeacherController {
	@Autowired
	ManageTeacherServiceImpl mtsi;

	@RequestMapping(value = "/manageTeacher")
	public String manage(HttpServletRequest req, @RequestParam(defaultValue = "1") Integer pageNum) {
		if (req.getSession().getAttribute("administrator") != null) {
			try {
				req.setAttribute("teacherInfoList", mtsi.manage(req, pageNum));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "manageTeacher";
		} else {
			req.getSession().invalidate();
			req.getSession().setAttribute("Astate", "logout");
			return "administratorLogin";
		}

	}
}
