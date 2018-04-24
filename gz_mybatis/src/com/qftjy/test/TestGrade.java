package com.qftjy.test;

import java.util.List;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;

import com.qftjy.bean.Grade;
import com.qftjy.bean.Student;
import com.qftjy.bean.Teacher;
import com.qftjy.dao.GradeDao;
import com.qftjy.dao.TeacherDao;
import com.qftjy.dao.utils.MyBatisUtils;

import junit.framework.TestCase;

public class TestGrade   extends TestCase{
	//根据ID，查询班级信息
	public void test1(){
		SqlSession session=MyBatisUtils.getSession();
		GradeDao gDao=session.getMapper(GradeDao.class);
		Grade g=gDao.getById("1");
		//同时将其对应的老师信息打印
		System.out.println(g);
	//	System.out.println(g.getTeacher());
		session.close();
	}
	//根据ID查询老师信息，同时要将对应的班级信息显示出来
	public void test2(){
		SqlSession session=MyBatisUtils.getSession();
		TeacherDao teacherDao=session.getMapper(TeacherDao.class);
		 Teacher t= teacherDao.getTeacherById("1");
		 System.out.println(t);
		 System.out.println(t.getGrade());
		 session.close();
	}
	/*
	 * 给老师插入信息，要插入对应班级
	 */
	public void addGradeTeacher(){
		SqlSession session=MyBatisUtils.getSession();
		GradeDao gDao=session.getMapper(GradeDao.class);
		TeacherDao teacherDao=session.getMapper(TeacherDao.class);
		
		Grade g=new Grade();
		g.setGid(UUID.randomUUID().toString());
		g.setGname("1704班");
		int num=gDao.add(g);
		if(num<1){
			
		}
		System.out.println("-----插入老师-----");
		
		Teacher t=new Teacher();
		t.setTid(UUID.randomUUID().toString());
		t.setTname("欧阳老师");
		t.setGid(g.getGid());
		teacherDao.add(t);
		
		session.close();
		
	}
	//查询测试1对多  根据班级ID，得到班级信息，并查询对应的所有学生信息
	public void test3(){
		SqlSession session=MyBatisUtils.getSession();
		GradeDao gDao=session.getMapper(GradeDao.class);
		Grade g=gDao.getStudentsById("1");
		System.out.println("班级信息："+g);
		System.out.println("对应的学生信息是：");
		List<Student> list=g.getStudents();
		for(Student s :list){
			System.out.println(s);
		}
		
		session.close();
	}
	//查询测试1对多  根据班级ID，得到班级信息，并查询对应的所有学生信息
	public void test32(){
		SqlSession session=MyBatisUtils.getSession();
		GradeDao gDao=session.getMapper(GradeDao.class);
		Grade g=gDao.getStudentsById1("1");
		System.out.println("班级信息："+g);
		System.out.println("对应的学生信息是：");
		List<Student> list=g.getStudents();
		for(Student s :list){
			System.out.println(s);
		}
		
		session.close();
	}		
	//根据班级ID，得到班级信息，老师信息、所有学生信息。
	public void test4(){
		SqlSession session=MyBatisUtils.getSession();
		GradeDao gDao=session.getMapper(GradeDao.class);
		Grade g=gDao.getGradeAndTeacherAndStudentsByGid("1");
		System.out.println("班级信息："+g);
		System.out.println("老师信息："+g.getTeacher());
		System.out.println("对应的学生信息是：");
		List<Student> list=g.getStudents();
		for(Student s :list){
			System.out.println(s);
		}
	}
}
