package com.qftjy.bean;

import java.util.List;

import lombok.Data;

/*
 * 练习一对一配置   Grade  和 Teacher
 */
@Data   // lombok 
public class Grade {
	
	private String gid;
	private String gname;
	private Teacher teacher;
	//班级对应的学生集合
	private List<Student> students;
}
