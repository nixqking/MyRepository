package com.neil.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neil.mapper.TeacherMapper;
import com.neil.pojo.Administrator;
import com.neil.pojo.Student;
import com.neil.pojo.Teacher;
import com.neil.service.LoginService;
import com.neil.tools.UserUtil;

@Service
public class TeacherLoginService implements LoginService {
	@Autowired
	TeacherMapper teacherMapper;

	@Override
	public Student login(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Teacher login(Teacher teacher) {
		// TODO Auto-generated method stub
		UserUtil.assertNotNull(teacher);
		String Tno = (String) UserUtil.assertNotNull(teacher.getTno());
		return (Teacher) UserUtil.assertNotNull(teacherMapper.selectByPrimaryKey(Tno));
	}

	@Override
	public Administrator login(Administrator administrator) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
