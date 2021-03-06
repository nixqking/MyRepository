package com.neil.mapper;

import java.util.List;

import com.neil.pojo.Student;

public interface StudentMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table student
	 * 
	 * @mbg.generated Tue May 30 12:49:10 CST 2017
	 */
	int deleteByPrimaryKey(String sno);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table student
	 * 
	 * @mbg.generated Tue May 30 12:49:10 CST 2017
	 */
	int insert(Student record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table student
	 * 
	 * @mbg.generated Tue May 30 12:49:10 CST 2017
	 */
	int insertSelective(Student record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table student
	 * 
	 * @mbg.generated Tue May 30 12:49:10 CST 2017
	 */
	Student selectByPrimaryKey(String sno);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table student
	 * 
	 * @mbg.generated Tue May 30 12:49:10 CST 2017
	 */
	int updateByPrimaryKeySelective(Student record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table student
	 * 
	 * @mbg.generated Tue May 30 12:49:10 CST 2017
	 */
	int updateByPrimaryKey(Student record);

	List<Student> selectAll();
}