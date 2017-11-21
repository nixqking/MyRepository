package com.neil.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neil.mapper.CourseMapper;
import com.neil.service.DeleteCourseService;

@Service
public class DeleteCourseServiceImpl implements DeleteCourseService {
	@Autowired
	CourseMapper cm;

	@Override
	public int delete(String cno) throws Exception {
		// TODO Auto-generated method stub
		return cm.deleteByPrimaryKey(cno);
	}

}
