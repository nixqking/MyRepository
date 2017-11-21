package com.neil.serviceImpl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neil.mapper.StudentMapper;
import com.neil.pojo.Student;
import com.neil.service.ManageStudentService;

@Service
public class ManageStudentServiceImpl implements ManageStudentService {
	@Autowired
	StudentMapper sm;

	@Override
	public List<Student> manage(HttpServletRequest req,Integer pageNum) throws Exception {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, 5);
		List<Student> Student = sm.selectAll();
		PageInfo<Student> p = new PageInfo<>(Student);
		req.setAttribute("ManageStudentPageInfo", p);
		return Student;
	}

}
