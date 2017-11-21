package com.neil.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neil.mapper.StudentMapper;
import com.neil.pojo.Student;
import com.neil.service.AddStudentService;

@Service
public class AddStudentServiceImpl implements AddStudentService {
	@Autowired
	StudentMapper sm;

	@Override
	public int addStudent(Student student) throws Exception {
		// TODO Auto-generated method stub
		return sm.insertSelective(student);
	}

}
