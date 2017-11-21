package com.neil.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neil.mapper.TeacherMapper;
import com.neil.pojo.Teacher;
import com.neil.service.AddTeacherService;

@Service
public class AddTeacherServiceImpl implements AddTeacherService {
	@Autowired
	TeacherMapper tm;

	@Override
	public int addTeacher(Teacher teacher) throws Exception {
		// TODO Auto-generated method stub
		return tm.insertSelective(teacher);
	}

}
