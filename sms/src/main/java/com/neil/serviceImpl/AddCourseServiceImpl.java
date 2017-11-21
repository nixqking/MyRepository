package com.neil.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neil.mapper.CourseMapper;
import com.neil.pojo.Course;
import com.neil.service.AddCourseService;

@Service
public class AddCourseServiceImpl implements AddCourseService {
	@Autowired
	CourseMapper cm;

	@Override
	public int addCourse(Course course) throws Exception {
		// TODO Auto-generated method stub
		return cm.insertSelective(course);
	}

}
