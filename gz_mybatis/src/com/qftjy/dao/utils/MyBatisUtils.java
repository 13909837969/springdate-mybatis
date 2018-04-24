package com.qftjy.dao.utils;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtils {
	private static SqlSessionFactory sqlSessionFactory;
	private  static SqlSessionFactory getSqlSessionFactory(){
		if(sqlSessionFactory==null){
			String resource = "myBatis.xml"; 
			//1加载mybatis的配置文件（它也加载关联的映射文件）
			Reader reader=null;
			try {
				reader = Resources.getResourceAsReader(resource);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		}
		return sqlSessionFactory;
	}
	public static SqlSession getSession(){
		if(sqlSessionFactory==null){
			sqlSessionFactory=getSqlSessionFactory();
		}
		//设为true代表事务自动提交
		return sqlSessionFactory.openSession(true);
	}
	
	
	
	
	private MyBatisUtils(){
		
	}
}
