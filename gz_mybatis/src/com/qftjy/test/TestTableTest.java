package com.qftjy.test;

import org.apache.ibatis.session.SqlSession;

import com.qftjy.bean.TableTest;
import com.qftjy.dao.TableTestDao;
import com.qftjy.dao.utils.MyBatisUtils;

import junit.framework.TestCase;

public class TestTableTest  extends TestCase{
	public void test1(){
		SqlSession session=MyBatisUtils.getSession();
		TableTestDao tDao=session.getMapper(TableTestDao.class);
		TableTest t=tDao.getById(1);
		System.out.println(t);
		session.close();
	}
}
