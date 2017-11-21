package com.neil.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neil.mapper.TeacherMapper;
import com.neil.pojo.Teacher;
import com.neil.service.UpdatePasswordService;
import com.neil.tools.UserUtil;

@Service
public class TeacherPasswordUpdateServiceImpl implements UpdatePasswordService {
	@Autowired
	TeacherMapper teacherMapper;

	@Override
	public String updateTeacherPassword(String tno, String newPassword, String oldPassword, String repeatPassword)
			throws Exception {

		UserUtil.assertNotNull(teacherMapper);
		UserUtil.assertNotNull(tno);
		Teacher teacher = teacherMapper.selectByPrimaryKey(tno);
		/* System.out.println(student); */
		UserUtil.assertNotNull(teacher);
		if (teacher.getPassword().equals(UserUtil.getMD5(oldPassword)) && newPassword.equals(repeatPassword)
				&& teacher.getTno().equals(tno)) {
			newPassword = UserUtil.getMD5(newPassword);
			teacher.setPassword(newPassword);
			teacherMapper.updateByPrimaryKey(teacher);
			return "index";
		} else
			return "error";

	}

	@Override
	public String updateStudentPassword(String sno, String newPassword, String oldPassword, String repeatPassword)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateAdministratorPassword(String sno, String newPassword, String oldPassword, String repeatPassword)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
