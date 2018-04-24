package com.company.test;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;

import com.company.demo.Grade;
import com.company.demo.Student;
import com.company.util.JpaUtils;

public class InfoTest2 {

	

	@Test
	public void test()
	{
		EntityManager en = JpaUtils.getInstall();
		
		JpaUtils.close();
	}
	
	//����ѧ��id ��ѯѧ����Ϣ ͬʱ��ѧ����Ӧ�İ༶��Ϣ���ҳ���
	@Test
	public void test1()
	{
		EntityManager en = JpaUtils.getInstall();
		Student s = en.find(Student.class, 1);
		System.out.println(s.getSid()+"\t"+s.getSname()+"\t"+s.getGrade().getGid());
		JpaUtils.close();
	}
	
	//���ݰ༉id ��ѯѧ����Ϣ 
	@Test
	public void test2()
	{
		EntityManager en = JpaUtils.getInstall();
		Grade g =en.find(Grade.class, 1);
		System.out.println("�༶��Ϣ��"+g.getGid()+g.getGname());
		List<Student> list = g.getList();
		System.out.println("ѧ����Ϣ���£�");
		for(Student s : list)
		{
			System.out.println(s.getSid()+"\t"+s.getSname());
		}
		JpaUtils.close();
	}
	
	
	
	
	
	
	

}
