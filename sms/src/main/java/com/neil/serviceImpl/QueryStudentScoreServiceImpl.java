package com.neil.serviceImpl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neil.mapper.ScMapper;
import com.neil.pojo.Sc;
import com.neil.service.QueryStudentScoreService;

@Service
public class QueryStudentScoreServiceImpl implements QueryStudentScoreService {
	@Autowired
	ScMapper scMapper;

	@Override
	public List<Sc> queryStudentScore(HttpServletRequest req, String tno, Integer pageNum) throws Exception {
		List<Sc> download = null;
		if (req.getParameter("param") != null && req.getParameter("param").equals("score")) {
			download = scMapper.queryStudentScoreByScore(tno);
			req.getSession().setAttribute("OrderBy", "score");
		} else if (req.getParameter("param") != null && req.getParameter("param").equals("sdept")) {
			download = scMapper.queryStudentScoreBySdept(tno);
			req.getSession().setAttribute("OrderBy", "sdept");
		} else if (req.getParameter("param") != null && req.getParameter("param").equals("sno")) {
			download = scMapper.queryStudentScore(tno);
			req.getSession().setAttribute("OrderBy", "sno");
		} else if (req.getParameter("param") != null && req.getParameter("param").equals("fail")) {
			download = scMapper.queryFailStudentScore(tno);
			req.getSession().setAttribute("OrderBy", "fail");
		} else {
			download = scMapper.queryStudentScore(tno);
		}
		if (req.getParameter("request") != null && req.getParameter("request").equals("all"))
			return download;
		List<Sc> studentScore = null;
		PageHelper.startPage(pageNum, 5);
		if (req.getSession().getAttribute("OrderBy") != null
				&& req.getSession().getAttribute("OrderBy").equals("score")) {
			studentScore = scMapper.queryStudentScoreByScore(tno);
		} else if (req.getSession().getAttribute("OrderBy") != null
				&& req.getSession().getAttribute("OrderBy").equals("sdept")) {
			studentScore = scMapper.queryStudentScoreBySdept(tno);
		} else if (req.getSession().getAttribute("OrderBy") != null
				&& req.getSession().getAttribute("OrderBy").equals("fail")) {
			studentScore = scMapper.queryFailStudentScore(tno);
		} else
			studentScore = scMapper.queryStudentScore(tno);
		PageInfo<Sc> p = new PageInfo<>(studentScore);
		req.setAttribute("PageInfo", p);
		return studentScore;
	}
}
