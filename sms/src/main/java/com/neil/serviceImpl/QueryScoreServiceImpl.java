package com.neil.serviceImpl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neil.mapper.ScMapper;
import com.neil.pojo.Sc;
import com.neil.service.QueryScoreService;

@Service
public class QueryScoreServiceImpl implements QueryScoreService {

	@Autowired
	ScMapper scm;

	@Override
	public List<Sc> queryScore(HttpServletRequest req, String sno, Integer pageNum) throws Exception {
		// TODO Auto-generated method stub
		if (req.getParameter("request") != null && req.getParameter("request").equals("all"))
			return scm.queryScore(sno);
		PageHelper.startPage(pageNum, 5);
		List<Sc> Score = scm.queryScore(sno);
		PageInfo<Sc> p = new PageInfo<>(Score);
		req.setAttribute("ScorePageInfo", p);
		return Score;
	}

}
