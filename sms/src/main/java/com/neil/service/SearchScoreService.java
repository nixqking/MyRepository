package com.neil.service;

import java.util.List;

import com.neil.pojo.Sc;

public interface SearchScoreService {
	List<Sc> SearchScore(Sc sc) throws Exception;
}
