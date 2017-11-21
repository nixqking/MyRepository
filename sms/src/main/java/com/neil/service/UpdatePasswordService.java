package com.neil.service;

public interface UpdatePasswordService {

	public String updateTeacherPassword(String tno, String newPassword, String oldPassword, String repeatPassword)
			throws Exception;

	public String updateStudentPassword(String sno, String newPassword, String oldPassword, String repeatPassword)
			throws Exception;
	
	public String updateAdministratorPassword(String account, String newPassword, String oldPassword, String repeatPassword)
			throws Exception;
}
