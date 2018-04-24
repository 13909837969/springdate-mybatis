package com.qftjy.test;

import com.qftjy.bean.Users;
import com.qftjy.service.impl.UsersDaoServiceImpl;

import junit.framework.TestCase;

public class TestUsersService  extends TestCase{
	UsersDaoServiceImpl uService=new UsersDaoServiceImpl();
	public void test1(){
		/*
		 * action代码
		 */
		Users u=uService.getUsersById("2");
		System.out.println(u);
	}
	public void test2(Users u){
		String sql="select * from users where 1=1 ";
		if(u.getUname()!=null){
			sql+="and uname="+u.getUname();
		}else if(u.getUpass()!=null){
			sql+=" and upass="+u.getUpass();
		}
	}
}
