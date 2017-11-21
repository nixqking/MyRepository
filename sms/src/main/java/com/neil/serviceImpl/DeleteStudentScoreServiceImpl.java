package com.neil.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neil.mapper.ScMapper;
import com.neil.pojo.Sc;
import com.neil.service.DeleteStudentScoreService;

@Service
public class DeleteStudentScoreServiceImpl implements DeleteStudentScoreService {
	@Autowired
	ScMapper sm;

	@Override
	public int deleteStudent(Sc sc) throws Exception {
		// TODO Auto-generated method stub
		return sm.deleteByPrimaryKey(sc);
	}

}
