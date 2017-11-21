package com.neil.serviceImpl;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neil.mapper.ScMapper;
import com.neil.pojo.Course;
import com.neil.service.AvgScoreService;

@Service
public class AvgScoreServiceImpl implements AvgScoreService {
	@Autowired
	ScMapper scm;

	@Override
	public HashMap<String,Integer> avgScore(Course course) throws Exception {
		// TODO Auto-generated method stub
		return scm.scoreAvg(course);
	}

}
