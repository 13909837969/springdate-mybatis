package com.qftjy.service.impl;

import java.util.List;

import com.qftjy.bean.Users;
import com.qftjy.dao.UsersDao;
import com.qftjy.dao.utils.MyBatisUtils;
import com.qftjy.service.UsersDaoService;

public class UsersDaoServiceImpl  implements UsersDaoService{
	/*
	 * 实现业务逻辑层 调用Dao层方法
	 */
	UsersDao usersDao=MyBatisUtils.getSession().getMapper(UsersDao.class);
	@Override
	public Users getUsersById(String id) {
		// TODO Auto-generated method stub
		return usersDao.getUsersById(id);
	}

	@Override
	public int deleteById(String id) {
		// TODO Auto-generated method stub
		return usersDao.deleteById(id);
	}

	@Override
	public List<Users> getList() {
		// TODO Auto-generated method stub
		return usersDao.getList();
	}

	@Override
	public int add(Users u) {
		// TODO Auto-generated method stub
		return usersDao.add(u);
	}

	@Override
	public int update(Users u) {
		// TODO Auto-generated method stub
		return usersDao.update(u);
	}

	@Override
	public Users loginUsers(String uname, String upass) {
		// TODO Auto-generated method stub
		return usersDao.loginUsers(uname, upass);
	}

	@Override
	public List<Users> getListSort(String sort) {
		// TODO Auto-generated method stub
		return usersDao.getListSort(sort);
	}

}
