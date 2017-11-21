package com.neil.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neil.mapper.AdministratorMapper;
import com.neil.pojo.Administrator;
import com.neil.pojo.Student;
import com.neil.pojo.Teacher;
import com.neil.service.LoginService;
import com.neil.tools.UserUtil;

@Service
public class AdministratorLoginService implements LoginService {
	@Autowired
	AdministratorMapper am;

	@Override
	public Student login(Student student) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Teacher login(Teacher teacher) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Administrator login(Administrator administrator) throws Exception {
		UserUtil.assertNotNull(administrator);
		String account = (String) UserUtil.assertNotNull(administrator.getAccount());
		return (Administrator) UserUtil.assertNotNull(am.selectByPrimaryKey(account));
	}

}
