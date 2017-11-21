package com.neil.serviceImpl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neil.mapper.CourseMapper;
import com.neil.pojo.Course;
import com.neil.service.ManageCourseService;

@Service
public class ManageCourseServiceImpl implements ManageCourseService {
	@Autowired
	CourseMapper cm;

	@Override
	public List<Course> manage(HttpServletRequest req, Integer pageNum) throws Exception {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, 5);
		List<Course> course = cm.selectAll();
		PageInfo<Course> p = new PageInfo<>(course);
		req.setAttribute("ManageCoursePageInfo", p);
		return course;
	}

}
