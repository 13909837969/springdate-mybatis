package com.qftjy.dao;

import com.qftjy.bean.Student;

public interface StudentDao {
	//根据学生ID，查询学生信息
	public Student getStudentById(String id);
	//根据学生ID，查询学生信息,班级信息
	public Student getStudentById1(String id);
}
