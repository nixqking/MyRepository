package com.neil.service;

import com.neil.pojo.Administrator;
import com.neil.pojo.Student;
import com.neil.pojo.Teacher;

public interface LoginService {
	Student login(Student student) throws Exception;

	Teacher login(Teacher teacher) throws Exception;

	Administrator login(Administrator administrator) throws Exception;
}
