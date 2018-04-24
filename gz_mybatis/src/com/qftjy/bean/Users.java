package com.qftjy.bean;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
 * 生成get set方法，toString()  构造方法....
 * Lombok.jar
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7924970706623740032L;
	private String id;
	private String  uname;
	private String  upass;
	private String  realname;
	private Date  currdate;
	private String  remark;
}
