package com.neil.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neil.mapper.ScMapper;
import com.neil.pojo.Sc;
import com.neil.service.SearchStudentScoreService;

@Service
public class SearchStudentScoreServiceImpl implements SearchStudentScoreService {
	@Autowired
	ScMapper scm;

	@Override
	public List<Sc> searchStudentScore(Sc sc) throws Exception {
		if (sc.getSno() == null) {
			return scm.searchStudentScoreBySname(sc);
		} else
			return scm.searchStudentScoreBySno(sc);
	}
}
