package com.qftjy.dao;

import java.util.HashMap;

import com.qftjy.bean.Grade;

public interface GradeDao {
	
	//根据ID查询单个班级 ，得到对应的老师信息
	public Grade  getById(String id);
	//插入班级
	public int add(Grade g);
	// 1对多 第一种方式： 根据班级ID，查询该班级信息，并将该班级下的所有学生打印出来
	public Grade getStudentsById(String id);
	// 1对多 第二种方式： 根据班级ID，查询该班级信息，并将该班级下的所有学生打印出来
	public Grade getStudentsById1(String id);
	//根据班级ID，得到班级信息，老师信息、所有学生信息。
	public Grade getGradeAndTeacherAndStudentsByGid(String gid);

}
