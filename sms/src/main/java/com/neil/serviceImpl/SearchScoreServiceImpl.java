package com.neil.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neil.mapper.ScMapper;
import com.neil.pojo.Sc;
import com.neil.service.SearchScoreService;

@Service
public class SearchScoreServiceImpl implements SearchScoreService {
	@Autowired
	ScMapper scm;

	@Override
	public List<Sc> SearchScore(Sc sc) throws Exception {
		if (sc.getCno() == null) {
			return scm.searchScoreByCname(sc);
		} else
			return scm.searchScoreByCno(sc);
	}

}
