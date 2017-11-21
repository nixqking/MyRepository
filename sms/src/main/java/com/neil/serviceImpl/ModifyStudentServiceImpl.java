package com.neil.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neil.mapper.StudentMapper;
import com.neil.pojo.Student;
import com.neil.service.ModifyStudentService;

@Service
public class ModifyStudentServiceImpl implements ModifyStudentService {
	@Autowired
	StudentMapper sm;

	@Override
	public int modifyStudent(Student student) throws Exception {
		// TODO Auto-generated method stub
		return sm.updateByPrimaryKeySelective(student);
	}

}
