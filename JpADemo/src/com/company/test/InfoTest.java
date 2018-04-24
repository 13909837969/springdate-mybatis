package com.company.test;


import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import com.company.demo.Info;
import com.company.util.JpaUtils;

public class InfoTest 
{
	
	
	
	
	
	
	@Test
	public void test()
	{
		//1-创建工厂
		String persistenceUnitName = "JpADemo";
		Map<String,Object> properties = new HashMap<>();
		properties.put("hibernate.show_sql", true);
		EntityManagerFactory entityManagerFactory = 
			Persistence.createEntityManagerFactory(persistenceUnitName);
		//2-得到EntityManager
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		//3-配置事务 开起事务
		EntityTransaction tran = entityManager.getTransaction();
		tran.begin();
		//4-事务持久化操作
		Info i = new Info();
		i.setName("xdfds");
		i.setAge(121);
		i.setRemark("sdjflsdfjlsdfj");
		entityManager.persist(i);
		//5-事务提交
		tran.commit();
		//6-关闭资源
		entityManager.close();
		entityManagerFactory.close();
		
		
		
	}
	
	@Test
	public void test2()//添加
	{
		EntityManager dd = JpaUtils.getInstall();
		Info i = new Info();
		i.setName("123");
		i.setAge(121);
		i.setRemark("sdjflsdfjlsdfj");
		dd.persist(i);
		JpaUtils.close();
		
		
	}
	
	@Test
	public void test1()
	{
		//1-创建工厂
		String persistenceUnitName = "JpADemo";
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
		//2-得到EntityManager
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		//3-配置事务 开起事务
		EntityTransaction tran = entityManager.getTransaction();
		tran.begin();
		//4-事务持久化操作
		Info i = new Info();
		i.setName("23Tom");
		i.setAge(121);
		entityManager.persist(i);
		//5-事务提交
		
		tran.commit();
		//6-关闭资源
		entityManager.close();
		entityManagerFactory.close();

	}

	
	
	@Test
	public void test3()//查询 find 如果没查到返回空 找到返回的是实体类
	{
		EntityManager en = JpaUtils.getInstall();
		
		Info in = en.find(Info.class,1);
		System.out.println(in);
	}
	
	@Test
	public void test4()//查询 getReference 如果没查抛出异常 找到返回的是实体类的代理
	{
		EntityManager en = JpaUtils.getInstall();
		
		Info in = en.getReference(Info.class, 1);
		System.out.println(in);
	}
	
	/**
	 * hibernate 三种状态 
	 * 临时状态
	 * 游离状态
	 * 持久化状态
	 */
	@Test
	public void test5()//remove 删除 删除的状态必须是持久化状态
	{//先进行查询让数据变成持久化状态，再进行删除
		EntityManager en = JpaUtils.getInstall();
		Info in = en.find(Info.class, 1);
		en.remove(in);
		JpaUtils.close();
	}
	
	public void test6()//修改 merge
	{
		EntityManager en = JpaUtils.getInstall();
		Info a = new Info();
		a.setId(3);
		a.setName("wangshaofei");
		en.merge(a);
		JpaUtils.close();
	}
	
	

}
