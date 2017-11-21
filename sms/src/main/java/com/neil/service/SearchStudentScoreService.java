package com.neil.service;

import java.util.List;

import com.neil.pojo.Sc;

public interface SearchStudentScoreService {
	List<Sc> searchStudentScore(Sc sc) throws Exception;
}
