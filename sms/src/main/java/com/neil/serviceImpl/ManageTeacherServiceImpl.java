package com.neil.serviceImpl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neil.mapper.TeacherMapper;
import com.neil.pojo.Teacher;
import com.neil.service.ManageTeacherService;

@Service
public class ManageTeacherServiceImpl implements ManageTeacherService {
	@Autowired
	TeacherMapper tm;

	@Override
	public List<Teacher> manage(HttpServletRequest req, Integer pageNum) throws Exception {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, 5);
		List<Teacher> teacher = tm.selectAll();
		PageInfo<Teacher> p = new PageInfo<>(teacher);
		req.setAttribute("ManageTeacherPageInfo", p);
		return teacher;
	}

}
