package com.neil.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neil.mapper.TeacherMapper;
import com.neil.pojo.Teacher;
import com.neil.service.ModifyTeacherService;

@Service
public class ModifyTeacherServiceImpl implements ModifyTeacherService {
	@Autowired
	TeacherMapper tm;

	@Override
	public int modifyTeacher(Teacher teacher) throws Exception {
		// TODO Auto-generated method stub
		return tm.updateByPrimaryKeySelective(teacher);
	}

}
