package com.neil.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neil.mapper.StudentMapper;
import com.neil.service.DeleteStudentService;

@Service
public class DeleteStudentServiceImpl implements DeleteStudentService {
	@Autowired
	StudentMapper sm;

	@Override
	public int delete(String sno) throws Exception {
		// TODO Auto-generated method stub
		return sm.deleteByPrimaryKey(sno);
	}

}
