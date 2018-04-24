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
	
	//��������id��ѯ�û�ʵ�� 
	//������������ѯ��ͼ����
	/**
	 * jpql :query
	 * ������������ѯ����
	 */
	//��ѯ����
	@Test
	public void test1()
	{
		EntityManager en = JpaUtils.getInstall();
		String jpql = "from Info";//��hql�﷨��ͬ
		Query query = en.createQuery(jpql);
		List<Info> list = query.getResultList();
		System.out.println(query);
		JpaUtils.close();
	}
	
	//����id��ѯinfo����Ϣ
	@Test
	public void test2()
	{
		EntityManager en = JpaUtils.getInstall();
		String jpql = "from Info where id =?";//��hql�﷨��ͬ
		Query query = en.createQuery(jpql);
		query.setParameter(0, 2);
		Info list = (Info) query.getSingleResult();
		System.out.println(query);
		JpaUtils.close();
	}
	//�ʺŴ���
	@Test
	public void test3()
	{
		EntityManager en = JpaUtils.getInstall();
		String jpql = "from Info where id =?";//��hql�﷨��ͬ
		Query query = en.createQuery(jpql);
		query.setParameter(0, 2);
		Info list = (Info) query.getSingleResult();
		System.out.println(query);
		JpaUtils.close();
	}
	//�ʺŶ�λ
	@Test
	public void test4()
	{
		EntityManager en = JpaUtils.getInstall();
		String jpql = "from Info where id =?1";//��hql�﷨��ͬ
		Query query = en.createQuery(jpql);
		query.setParameter(1, 2);//���ʺ�ȷ��λ�� �ʺ�λ�þ����Ǹ�1
		Info list = (Info) query.getSingleResult();
		System.out.println(query);
		JpaUtils.close();
	}
	//��������
	@Test
	public void test5()
	{
		EntityManager en = JpaUtils.getInstall();
		String jpql = "from Info where id =:id";//��hql�﷨��ͬ
		Query query = en.createQuery(jpql);
		query.setParameter("id", 2);//���ʺ�ȷ��λ�� �ʺ�λ�þ����Ǹ�1
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
	//����id�޸�����
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
