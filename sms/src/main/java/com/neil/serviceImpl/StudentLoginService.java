package com.neil.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neil.mapper.StudentMapper;
import com.neil.pojo.Administrator;
import com.neil.pojo.Student;
import com.neil.pojo.Teacher;
import com.neil.service.LoginService;
import com.neil.tools.UserUtil;

@Service
public class StudentLoginService implements LoginService {
	@Autowired
	StudentMapper studentMapper;

	@Override
	public Student login(Student student) {
		UserUtil.assertNotNull(student);
		String sno = (String) UserUtil.assertNotNull(student.getSno());
		return (Student) UserUtil.assertNotNull(studentMapper.selectByPrimaryKey(sno));
	}

	@Override
	public Teacher login(Teacher teacher) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Administrator login(Administrator administrator) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
