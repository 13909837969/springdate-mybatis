package com.qftjy.test;

import org.apache.ibatis.session.SqlSession;

import com.qftjy.bean.Student;
import com.qftjy.dao.StudentDao;
import com.qftjy.dao.utils.MyBatisUtils;

import junit.framework.TestCase;

public class TestStudent extends TestCase {
	//根据学生ID 得到学生信息
	public void test1(){
		SqlSession session=MyBatisUtils.getSession();
		StudentDao sDao=session.getMapper(StudentDao.class);
		Student s=sDao.getStudentById("1");
		System.out.println(s);
		session.close();
	}
	
	//根据学生ID 得到学生信息，对应的班级信息
		public void test2(){
			SqlSession session=MyBatisUtils.getSession();
			StudentDao sDao=session.getMapper(StudentDao.class);
			Student s=sDao.getStudentById1("1");
			//System.out.println(s);
			session.close();
		}
}
