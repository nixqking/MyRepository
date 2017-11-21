package com.neil.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.neil.pojo.Course;

public interface ManageCourseService {

	List<Course> manage(HttpServletRequest req, Integer pageNum) throws Exception;
}
