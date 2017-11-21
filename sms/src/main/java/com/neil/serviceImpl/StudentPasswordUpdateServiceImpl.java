package com.neil.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.neil.mapper.StudentMapper;
import com.neil.pojo.Student;
import com.neil.service.UpdatePasswordService;
import com.neil.tools.UserUtil;

@Service
public class StudentPasswordUpdateServiceImpl implements UpdatePasswordService {
	@Autowired
	StudentMapper studentMapper;

	@Override
	public String updateStudentPassword(String sno, String newPassword, String oldPassword, String repeatPassword)
			throws Exception {
		/*
		 * System.out.println("old:" + oldPassword + "new:" + newPassword +
		 * "repeat:" + repeatPassword);
		 */
		UserUtil.assertNotNull(studentMapper);
		UserUtil.assertNotNull(sno);
		Student student = studentMapper.selectByPrimaryKey(sno);
		/* System.out.println(student); */
		UserUtil.assertNotNull(student);
		if (student.getPassword().equals(UserUtil.getMD5(oldPassword)) && newPassword.equals(repeatPassword)
				&& student.getSno().equals(sno)) {
			newPassword = UserUtil.getMD5(newPassword);
			student.setPassword(newPassword);
			studentMapper.updateByPrimaryKey(student);
			return "index";
		} else
			return "error";
	}

	@Override
	public String updateTeacherPassword(String tno, String newPassword, String oldPassword, String repeatPassword)
			throws Exception {
		return null;
	}

	@Override
	public String updateAdministratorPassword(String sno, String newPassword, String oldPassword, String repeatPassword)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
