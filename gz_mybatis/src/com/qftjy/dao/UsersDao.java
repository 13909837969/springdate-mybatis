package com.qftjy.dao;

import java.util.List;

import com.qftjy.bean.Users;
/*
 * 在mybatis中，映射文件中的namespace是用于绑定Dao接口的，即面向接口编程
        当你的namespace绑定接口后，你可以不用写接口实现类，mybatis会通过该绑定自动
 */
public interface UsersDao {
	//根据ID得到实体对象
	public Users getUsersById(String id);
	//根据ID删除某个对象
	public int deleteById(String id);
	//查询列表数据
	public List<Users> getList();
	/*
	 * jdbc: executeUpdate();
	 *  1.ResultSet executeQuery(String sql); 执行SQL查询，并返回ResultSet 对象。
 		2.int executeUpdate(String sql); 可执行增，删，改，返回执行受到影响的行数。
	 */
	//添加方法	
	public int add(Users u); 
	//修改方法
	public int update(Users u);
	//根据用户名和密码传递参数
	public Users loginUsers(String uname,String upass);
	//用户自定义排序
	public List<Users> getListSort(String sort);
}
