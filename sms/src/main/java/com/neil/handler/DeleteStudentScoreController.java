package com.neil.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neil.pojo.Sc;
import com.neil.serviceImpl.DeleteStudentScoreServiceImpl;

@Controller
public class DeleteStudentScoreController {
	@Autowired
	DeleteStudentScoreServiceImpl dssi;

	@Transactional
	@RequestMapping("/deleteStudentScore")
	String delete(Sc sc, HttpServletRequest req) {
		if (req.getSession().getAttribute("teacher") != null) {
			int i = -1;
			try {
				sc.setCno(sc.getCourse().getCno());
				i=dssi.deleteStudent(sc);
				/* System.out.println(dssi.deleteStudent(sc)); */
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "deleteFailed";
			}
			if (i < 1) {
				return "deleteFailed";
			}
			return "deleteSucceed";
		} else {
			req.getSession().invalidate();
			req.getSession().setAttribute("Astate", "logout");
			return "administratorLogin";
		}
	}
}
