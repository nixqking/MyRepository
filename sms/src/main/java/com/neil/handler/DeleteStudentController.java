package com.neil.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neil.serviceImpl.DeleteStudentServiceImpl;

@Controller
public class DeleteStudentController {
	@Autowired
	DeleteStudentServiceImpl dssi;

	@RequestMapping("/deleteStudent")
	public String delete(HttpServletRequest req, String sno) {
		if (req.getSession().getAttribute("administrator") != null) {
			int i = -1;
			try {
				i = dssi.delete(sno);
			} catch (Exception e) {
				e.printStackTrace();
				req.setAttribute("deleteType", "deleteStudent");
				return "deleteFailed";
			}
			if (i < 1) {
				req.setAttribute("deleteType", "deleteStudent");
				return "deleteFailed";
			}
			req.setAttribute("deleteType", "deleteStudent");
			return "deleteSucceed";
		} else {
			req.getSession().invalidate();
			req.getSession().setAttribute("Astate", "logout");
			return "administratorLogin";
		}

	}
}
