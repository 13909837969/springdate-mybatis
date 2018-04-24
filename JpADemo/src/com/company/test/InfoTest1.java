package com.company.test;

import javax.persistence.EntityManager;

import org.junit.Test;

import com.company.demo.Grade;
import com.company.demo.Student;
import com.company.util.JpaUtils;

public class InfoTest1 {

	@Test
	public void test() {
		EntityManager en = JpaUtils.getInstall();
		Grade g = new Grade();
		g.setGname("w");
		en.persist(g);
		JpaUtils.close();
	}

	@Test
	public void test1() {//���һ
		EntityManager en = JpaUtils.getInstall();
		Student g = new Student();
		g.setSname("sdf");
		g.setSid(4);
		Grade gg = en.find(Grade.class, 1);
		g.setGrade(gg);
		en.persist(g);
		JpaUtils.close();
	}

	@Test
	public void test3() {

		EntityManager en = JpaUtils.getInstall();
		Grade g = en.find(Grade.class, 1);
		System.out.println(g);
		JpaUtils.close();

	}
	
	
	//����ѧ��id ��ѯѧ����Ϣ ͬʱ��ѧ����Ӧ�İ༶��Ϣ���ҳ���
	@Test
	public void test4() {

		EntityManager en = JpaUtils.getInstall();
		Student s  = en.find(Student.class, 1);
		System.out.println("ѧ����Ϣ"+s.getGid()+"\t"+s.getSname()+"\t");
		JpaUtils.close();

	}
	
	public void test6()
	{
		EntityManager en = JpaUtils.getInstall();
		Student s = new Student();
		s.setSid(4);
		s.setSname("list");
		//Grade g = en.find(Grade.class, 1);
		//s.setGrade(g);
		en.persist(s);
		JpaUtils.close();
		System.out.println("dfa");

	}

}
