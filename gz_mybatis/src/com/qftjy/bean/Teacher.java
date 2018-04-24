package com.qftjy.bean;

import lombok.Data;
/*
 * 练习一对一配置   Grade  和 Teacher
 */
@Data
public class Teacher {
	private String tid;
	private String tname;
	private String gid;
	private Integer age;
	private Integer status;
	private String remark;
	private String sex;
	private Grade grade;
}
