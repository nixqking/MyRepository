package com.neil.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.neil.pojo.Student;

public interface ManageStudentService {

	List<Student> manage(HttpServletRequest req, Integer pageNum) throws Exception;
}
