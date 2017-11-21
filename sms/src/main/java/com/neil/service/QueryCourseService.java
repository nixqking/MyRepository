package com.neil.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.neil.pojo.Course;

public interface QueryCourseService {
	List<Course> queryCourse(HttpServletRequest req, String sno, Integer pageNum) throws Exception;
}
