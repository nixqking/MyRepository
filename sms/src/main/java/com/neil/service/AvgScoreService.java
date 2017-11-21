package com.neil.service;

import java.util.HashMap;
import com.neil.pojo.Course;

public interface AvgScoreService {
	HashMap<String, Integer> avgScore(Course course) throws Exception;
}
