package com.company.test;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;

import com.company.demo.Grade;
import com.company.demo.Student;
import com.company.demo.Teacher;
import com.company.util.JpaUtils;
public class InfoTest3 
{
	@Test
	public void test()
	{
		EntityManager en = JpaUtils.getInstall();
		System.out.println("dage");
		JpaUtils.close();
	}
	//��ʦ�Ͱ༶����һ��һ��ϵ
	@Test
	public void test1()
	{
		EntityManager en = JpaUtils.getInstall();
		Teacher t = new Teacher();
		t.setTname("sdfd");
		Grade g = en.find(Grade.class, 1);
		t.setGrade(g);
		en.persist(g);
		JpaUtils.close();
	}
	@Test
	public void test2()
	{
		EntityManager en = JpaUtils.getInstall();
		Teacher t = new Teacher();
		t.setTid(1);
		t.setTname("sdfd");
		en.persist(t);
		System.out.println(";dflk;ddfjk;");
		JpaUtils.close();
	}
	@Test
	public void test3()
	{//һ��һ��ѯ
		EntityManager en = JpaUtils.getInstall();
		Teacher t = new Teacher();
		t.setTname("baox");
		Grade g = en.find(Grade.class, 1);
		t.setGrade(g);
		en.persist(t);
		JpaUtils.close();
	}
	@Test
	public void test4()
	{//һ��һ��ѯ
		EntityManager en = JpaUtils.getInstall();
		Teacher t = en.find(Teacher.class, 1);
		System.out.println("��ʦ+�༶��"+t.getTid()+"\t"+t.getTname()+"\t"+t.getGrade().getGid());
		List<Student> list = t.getGrade().getList();
		for(Student s : list)
		{
			System.out.println("ѧ��"+s.getSid()+s.getSname());
		}
				
		JpaUtils.close();
	}

}
