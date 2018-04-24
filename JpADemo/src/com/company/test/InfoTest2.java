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
	
	//根据学生id 查询学生信息 同时将学生对应的班级信息查找出来
	@Test
	public void test1()
	{
		EntityManager en = JpaUtils.getInstall();
		Student s = en.find(Student.class, 1);
		System.out.println(s.getSid()+"\t"+s.getSname()+"\t"+s.getGrade().getGid());
		JpaUtils.close();
	}
	
	//根据班級id 查询学生信息 
	@Test
	public void test2()
	{
		EntityManager en = JpaUtils.getInstall();
		Grade g =en.find(Grade.class, 1);
		System.out.println("班级信息："+g.getGid()+g.getGname());
		List<Student> list = g.getList();
		System.out.println("学生信息如下：");
		for(Student s : list)
		{
			System.out.println(s.getSid()+"\t"+s.getSname());
		}
		JpaUtils.close();
	}
	
	
	
	
	
	
	

}
