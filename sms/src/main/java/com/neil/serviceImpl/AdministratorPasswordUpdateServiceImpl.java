package com.neil.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neil.mapper.AdministratorMapper;
import com.neil.pojo.Administrator;
import com.neil.service.UpdatePasswordService;
import com.neil.tools.UserUtil;

@Service
public class AdministratorPasswordUpdateServiceImpl implements UpdatePasswordService {
	@Autowired
	AdministratorMapper am;

	@Override
	public String updateStudentPassword(String sno, String newPassword, String oldPassword, String repeatPassword)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateTeacherPassword(String tno, String newPassword, String oldPassword, String repeatPassword)
			throws Exception {
		return null;
	}

	@Override
	public String updateAdministratorPassword(String account, String newPassword, String oldPassword, String repeatPassword)
			throws Exception {
		UserUtil.assertNotNull(am);
		UserUtil.assertNotNull(account);
		Administrator administrator = am.selectByPrimaryKey(account);
		/* System.out.println(student); */
		UserUtil.assertNotNull(administrator);
		if (administrator.getPassword().equals(UserUtil.getMD5(oldPassword)) && newPassword.equals(repeatPassword)
				&& administrator.getAccount().equals(account)){
			newPassword = UserUtil.getMD5(newPassword);
			administrator.setPassword(newPassword);
			am.updateByPrimaryKey(administrator);
			return "administratorLogin";
		} else
			return "error";
	}

}
