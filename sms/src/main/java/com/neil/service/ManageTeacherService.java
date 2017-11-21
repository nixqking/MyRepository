package com.neil.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.neil.pojo.Teacher;

public interface ManageTeacherService {

	List<Teacher> manage(HttpServletRequest req, Integer pageNum) throws Exception;
}
