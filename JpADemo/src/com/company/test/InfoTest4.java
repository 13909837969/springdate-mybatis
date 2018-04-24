package com.company.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Test;

import com.company.demo.Info;
import com.company.util.JpaUtils;
public class InfoTest4 
{
	@Test
	public void test()
	{
		EntityManager en = JpaUtils.getInstall();

		JpaUtils.close();
	}
	
	//根据主键id查询用户实体 
	//根据姓名来查询视图对象
	/**
	 * jpql :query
	 * 根据姓名来查询对象
	 */
	//查询所有
	@Test
	public void test1()
	{
		EntityManager en = JpaUtils.getInstall();
		String jpql = "from Info";//与hql语法相同
		Query query = en.createQuery(jpql);
		List<Info> list = query.getResultList();
		System.out.println(query);
		JpaUtils.close();
	}
	
	//根据id查询info的信息
	@Test
	public void test2()
	{
		EntityManager en = JpaUtils.getInstall();
		String jpql = "from Info where id =?";//与hql语法相同
		Query query = en.createQuery(jpql);
		query.setParameter(0, 2);
		Info list = (Info) query.getSingleResult();
		System.out.println(query);
		JpaUtils.close();
	}
	//问号传参
	@Test
	public void test3()
	{
		EntityManager en = JpaUtils.getInstall();
		String jpql = "from Info where id =?";//与hql语法相同
		Query query = en.createQuery(jpql);
		query.setParameter(0, 2);
		Info list = (Info) query.getSingleResult();
		System.out.println(query);
		JpaUtils.close();
	}
	//问号定位
	@Test
	public void test4()
	{
		EntityManager en = JpaUtils.getInstall();
		String jpql = "from Info where id =?1";//与hql语法相同
		Query query = en.createQuery(jpql);
		query.setParameter(1, 2);//给问号确定位置 问号位置就是那个1
		Info list = (Info) query.getSingleResult();
		System.out.println(query);
		JpaUtils.close();
	}
	//命名传参
	@Test
	public void test5()
	{
		EntityManager en = JpaUtils.getInstall();
		String jpql = "from Info where id =:id";//与hql语法相同
		Query query = en.createQuery(jpql);
		query.setParameter("id", 2);//给问号确定位置 问号位置就是那个1
		Info list = (Info) query.getSingleResult();
		System.out.println(query);
		JpaUtils.close();
	}
	
	@Test
	public void test6()
	{
		EntityManager en = JpaUtils.getInstall();
		String sql = "select * from info";
		Query query = en.createNativeQuery(sql,Info.class);
		List<Info> list = query.getResultList();
		System.out.println(list);
		JpaUtils.close();
	}
	//根据id修改姓名
	@Test
	public void test7()
	{
		EntityManager en = JpaUtils.getInstall();
		String jpql = "update info set name=? where id = ?";
		Query query = en.createQuery(jpql);
		query.setParameter(0, "dfd");
		query.setParameter(0, 2);
		int num = query.executeUpdate();
		
		System.out.println(num);
		JpaUtils.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
