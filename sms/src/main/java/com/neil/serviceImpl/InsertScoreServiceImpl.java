package com.neil.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neil.mapper.ScMapper;
import com.neil.pojo.Sc;
import com.neil.service.InsertScoreService;

@Service
public class InsertScoreServiceImpl implements InsertScoreService {
	@Autowired
	ScMapper scm;

	@Override
	public int insert(Sc sc) throws Exception {
		return scm.insert(sc);
	}

}
