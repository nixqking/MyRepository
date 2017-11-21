package com.neil.serviceImpl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neil.mapper.CourseMapper;
import com.neil.pojo.Course;
import com.neil.service.QueryCourseService;

@Service
public class QueryCourseServiceImpl implements QueryCourseService {
	@Autowired
	CourseMapper courseMapper;

	@Override
	public List<Course> queryCourse(HttpServletRequest req, String sno, Integer pageNum) throws Exception {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, 5);
		List<Course> courseList = courseMapper.queryCourse(sno);
		PageInfo<Course> p = new PageInfo<>(courseList);
		req.setAttribute("CoursePageInfo", p);
		return courseList;
	}

}
