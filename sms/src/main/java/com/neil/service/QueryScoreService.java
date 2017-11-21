package com.neil.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.neil.pojo.Sc;

public interface QueryScoreService {
	List<Sc> queryScore(HttpServletRequest req, String sno, Integer pageNum) throws Exception;
}
