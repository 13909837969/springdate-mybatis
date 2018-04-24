package com.company.util;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaUtils {

	private static EntityManagerFactory entityManagerFactory = null;
	private static EntityManager entityManager = null;
	private static EntityTransaction tran = null;

	public static EntityManager getInstall() {
		// 1-创建工厂
		String persistenceUnitName = "JpADemo";
		Map<String, Object> properties = new HashMap<>();
		properties.put("hibernate.show_sql", true);
		// 2-得到EntityManager
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName, properties);
		}
		entityManager = entityManagerFactory.createEntityManager();
		// 3-配置事务 开起事务
		tran = entityManager.getTransaction();
		tran.begin();
		return entityManager;
	}

	public static void close() {
		tran.commit();
		// 6-关闭资源
		entityManager.close();
		entityManagerFactory.close();
	}
	
	
	
	
	
	

}
