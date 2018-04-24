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
		//1-��������
		String persistenceUnitName = "JpADemo";
		Map<String,Object> properties = new HashMap<>();
		properties.put("hibernate.show_sql", true);
		EntityManagerFactory entityManagerFactory = 
			Persistence.createEntityManagerFactory(persistenceUnitName);
		//2-�õ�EntityManager
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		//3-�������� ��������
		EntityTransaction tran = entityManager.getTransaction();
		tran.begin();
		//4-����־û�����
		Info i = new Info();
		i.setName("xdfds");
		i.setAge(121);
		i.setRemark("sdjflsdfjlsdfj");
		entityManager.persist(i);
		//5-�����ύ
		tran.commit();
		//6-�ر���Դ
		entityManager.close();
		entityManagerFactory.close();
		
		
		
	}
	
	@Test
	public void test2()//���
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
		//1-��������
		String persistenceUnitName = "JpADemo";
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
		//2-�õ�EntityManager
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		//3-�������� ��������
		EntityTransaction tran = entityManager.getTransaction();
		tran.begin();
		//4-����־û�����
		Info i = new Info();
		i.setName("23Tom");
		i.setAge(121);
		entityManager.persist(i);
		//5-�����ύ
		
		tran.commit();
		//6-�ر���Դ
		entityManager.close();
		entityManagerFactory.close();

	}

	
	
	@Test
	public void test3()//��ѯ find ���û�鵽���ؿ� �ҵ����ص���ʵ����
	{
		EntityManager en = JpaUtils.getInstall();
		
		Info in = en.find(Info.class,1);
		System.out.println(in);
	}
	
	@Test
	public void test4()//��ѯ getReference ���û���׳��쳣 �ҵ����ص���ʵ����Ĵ���
	{
		EntityManager en = JpaUtils.getInstall();
		
		Info in = en.getReference(Info.class, 1);
		System.out.println(in);
	}
	
	/**
	 * hibernate ����״̬ 
	 * ��ʱ״̬
	 * ����״̬
	 * �־û�״̬
	 */
	@Test
	public void test5()//remove ɾ�� ɾ����״̬�����ǳ־û�״̬
	{//�Ƚ��в�ѯ�����ݱ�ɳ־û�״̬���ٽ���ɾ��
		EntityManager en = JpaUtils.getInstall();
		Info in = en.find(Info.class, 1);
		en.remove(in);
		JpaUtils.close();
	}
	
	public void test6()//�޸� merge
	{
		EntityManager en = JpaUtils.getInstall();
		Info a = new Info();
		a.setId(3);
		a.setName("wangshaofei");
		en.merge(a);
		JpaUtils.close();
	}
	
	

}
