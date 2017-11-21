package com.neil.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neil.pojo.Sc;
import com.neil.serviceImpl.ModifyStudentScoreServiceImpl;

@Controller
public class ModifyStudentScoreController {
	@Autowired
	ModifyStudentScoreServiceImpl msssi;

	@RequestMapping(value = "/modifyStudentScore", method = RequestMethod.GET)
	public String modify(Sc sc, Model model) {
		sc.setCno(sc.getCourse().getCno());
		model.addAttribute("sc", sc);
		return "modifyStudentScore";
	}

	@RequestMapping(value = "/modifyStudentScore", method = RequestMethod.POST)
	public String modifyPost(Sc sc) {
		int i = -1;
		try {
			i = msssi.modifyStudentScore(sc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (i < 1)
			return "modifyFailed";
		return "modifySucceed";
	}
}
