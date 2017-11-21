package com.neil.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neil.mapper.CourseMapper;
import com.neil.pojo.Course;
import com.neil.service.ModifyCourseService;

@Service
public class ModifyCourseServiceImpl implements ModifyCourseService {
	@Autowired
	CourseMapper cm;

	@Override
	public int modifyCourse(Course course) throws Exception {
		// TODO Auto-generated method stub
		return cm.updateByPrimaryKeySelective(course);
	}

}
