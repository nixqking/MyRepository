package com.neil.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neil.mapper.ScMapper;
import com.neil.pojo.Sc;
import com.neil.service.ModifyStudentScoreService;

@Service
public class ModifyStudentScoreServiceImpl implements ModifyStudentScoreService {
	@Autowired
	ScMapper sm;

	@Override
	public int modifyStudentScore(Sc sc) throws Exception {
		// TODO Auto-generated method stub
		return sm.updateByPrimaryKeySelective(sc);
	}

}
