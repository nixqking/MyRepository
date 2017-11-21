package com.neil.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.neil.pojo.Sc;

public interface QueryStudentScoreService {
	List<Sc> queryStudentScore(HttpServletRequest req, String tno, Integer pageNum) throws Exception;
}
