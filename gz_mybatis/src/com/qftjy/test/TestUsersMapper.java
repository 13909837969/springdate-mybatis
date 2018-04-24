package com.qftjy.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.qftjy.bean.Users;
import com.qftjy.dao.UsersDao;
import com.qftjy.dao.utils.MyBatisUtils;

import junit.framework.TestCase;

public class TestUsersMapper extends TestCase {
	
	public void test1(){
		SqlSession session=MyBatisUtils.getSession();
		UsersDao usersDao=session.getMapper(UsersDao.class);
		
		Users u=usersDao.getUsersById("3");
		System.out.println(u);
		System.out.println("-----getList");
		
		List<Users> list=usersDao.getList();
		System.out.println(list.size());
		session.close();
	}
}
