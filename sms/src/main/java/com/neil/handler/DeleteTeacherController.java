package com.neil.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neil.serviceImpl.DeleteTeacherServiceImpl;

@Controller
public class DeleteTeacherController {
	@Autowired
	DeleteTeacherServiceImpl dtsi;

	@RequestMapping("/deleteTeacher")
	public String delete(HttpServletRequest req, String tno) {
		if (req.getSession().getAttribute("administrator") != null) {
			int i = -1;
			try {
				i=dtsi.delete(tno);
			} catch (Exception e) {
				e.printStackTrace();
				req.setAttribute("deleteType", "deleteTeacher");
				return "deleteFailed";
			}
			if (i < 1) {
				req.setAttribute("deleteType", "deleteTeacher");
				return "deleteFailed";
			}
			req.setAttribute("deleteType", "deleteTeacher");
			return "deleteSucceed";
		} else {
			req.getSession().invalidate();
			req.getSession().setAttribute("Astate", "logout");
			return "administratorLogin";
		}
	}
}
