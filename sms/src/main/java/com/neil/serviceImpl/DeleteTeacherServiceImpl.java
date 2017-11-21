package com.neil.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neil.mapper.TeacherMapper;
import com.neil.service.DeleteTeacherService;

@Service
public class DeleteTeacherServiceImpl implements DeleteTeacherService {
	@Autowired
	TeacherMapper tm;

	@Override
	public int delete(String tno) throws Exception {
		// TODO Auto-generated method stub
		return tm.deleteByPrimaryKey(tno);
	}

}
