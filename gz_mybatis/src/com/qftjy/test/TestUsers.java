package com.qftjy.test;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.qftjy.bean.Users;
import com.qftjy.dao.UsersDao;
import com.qftjy.dao.utils.MyBatisUtils;

import junit.framework.TestCase;
/*
 * 测试一级缓存、二级缓存 
 */
public class TestUsers extends TestCase {
	// 查询
	public void test1() throws IOException {
		String resource = "myBatis.xml";
		// 1加载mybatis的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		// 2构建sqlSession的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		// 3创建能执行映射文件中sql的sqlSession
		SqlSession session = sessionFactory.openSession();
		// 4映射sql的标识字符串
		String sqlMyBstis = "com.qftjy.dao.UsersDao.getUsersById";
		// 5执行查询返回一个唯一user对象的sql
		Users u = session.selectOne(sqlMyBstis, "2");
		System.out.println(u);
		// 6关闭会话
		session.close();
	}

	// 查询
	public void test3() {
		SqlSession session = MyBatisUtils.getSession();
		// 4映射sql的标识字符串     
		String sqlMyBstis = "com.qftjy.dao.UsersDao.getUsersById";
		// 5执行查询返回一个唯一user对象的sql
		/*
		 * 
		 */
		Users u = session.selectOne(sqlMyBstis, "2");
		System.out.println(u);
		// 6关闭会话
		session.close();
	}
	//查询列表
	public void getList(){
		SqlSession session = MyBatisUtils.getSession();
		// 映射sql的标识字符串     
		String sqlMyBstis = "com.qftjy.dao.UsersDao.getList";
		List<Users> list=session.selectList(sqlMyBstis);
		for(Users u:list){
			System.out.println(u);
		}
		session.close();
	}

	// 根据ID进行删除
	public void test2() throws IOException {
		String resource = "myBatis.xml";
		// 1加载mybatis的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		// 2构建sqlSession的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		// 3创建能执行映射文件中sql的sqlSession
		SqlSession session = sessionFactory.openSession(true);

		// 4映射sql的标识字符串
		String sql = "com.qftjy.dao.UsersDao.deleteById"; // 通过配置文件
															// namespace+statmentId
		// 5根据ID进行删除
		int num = session.delete(sql, "3b8c42fe-4b70-47b7-8fe8-45dc65d383db");
		System.out.println(num);
		// 事务提交
		session.commit();
		// 6关闭会话
		session.close();
	}
	
	//添加用户
	public void addTest(){
		SqlSession session = MyBatisUtils.getSession();
		String sql="com.qftjy.dao.UsersDao.add";
		Users u=new Users(UUID.randomUUID().toString(),"Mr liu", "123","刘健良", new Date(),
				"这是一位先生 ");
		int num=session.insert(sql,u);
		System.out.println(num);
		
	}
	//根据进行修改，
	public void updateTest(){
		SqlSession session = MyBatisUtils.getSession();
		String sql="com.qftjy.dao.UsersDao.update";
		Users u=new Users();
		u.setId("2");
		u.setUname("sum");
		u.setUpass("1111111");
		u.setRealname("阳光小王子");
		int num=session.update(sql,u);
		System.out.println(num);
	}
	//传递多个参数值
	public void login(){
		SqlSession session=MyBatisUtils.getSession();
			String sql="com.qftjy.dao.UsersDao.loginUsers";
			//根据用户名和密码传递参数
			//public Users loginUsers(String uname,String upass);
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("aaa","sum");
			map.put("bbb","1111111");
			Users u=session.selectOne(sql,map);
			System.out.println(u);
		session.close();
	}
	//列表数据排序 操作，但是：根据排序规则：由用户在前端进行操作
	public void sortList(){
		SqlSession session=MyBatisUtils.getSession();
		String sql="com.qftjy.dao.UsersDao.getListSort";
		String sort="uname";
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("uname", sort);
		map.put("upass","upass");
		List<Users> list=session.selectList(sql,map);
		for(Users u:list){
			System.out.println(u);
		}
		session.close();
	}
	public void sql(){
		//登录功能，根据用户名和密码进行登录
		String uname="a";
		String upass="a' or '1'='1";
		//sql语句拼接方式
		String sql="select * from users where uname='"+uname+"'"
				+" and upass='"+upass+"'";
		System.out.println(sql);
	}
	//测试mybatis一级缓存  SqlSession
	public void testSqlSessionCache(){
		SqlSession session=MyBatisUtils.getSession();
		UsersDao uDao=session.getMapper(UsersDao.class);
		/*
		 * 查询执行SQL前，先到缓存区域中(Map)查找是否存在，如果不存在：请求数据库完成查询操作
		 */
		//根据ID查询Users实体
		Users u=uDao.getUsersById("2");
		System.out.println(u);	
		/*
		 * 查询执行SQL前，先到缓存区域中(Map)查找是否存在，如果存在：直接从缓存区域读取数据（不经过数据库）
		 */
		//根据ID查询Users实体
		Users u2=uDao.getUsersById("2");
		System.out.println(u2);
		
		//如果执行了增删改、myBatis缓存会清空
		int num=uDao.update(u);
		System.out.println("修改结果："+num);
		
		
		session.close();
	}
	// myBatis二级缓存 Mapper或namespace
	/*MyBatis默认没有开启二级缓存
	 * 1开启二级缓存开关
	 * <!-- 开启二级缓存 总开关   这个配置使全局的映射器启用或禁用缓存 -->
		<setting name="cacheEnabled" value="true"/>
		
	   2、	在对应的 映射文件中，加入以下内容，给其开启二级缓存开关 <cache/>
	   3、对该类实现序列化操作Serializable
	   	由于二级缓存的数据不一定都是存储到内存中，它的存储介质多种多样，所以需要给缓存的对象执行序列化。
		如果该类存在父类，那么父类也要实现序列化

	 */
	public void testSecondCache(){
		//二级缓存 
		SqlSession session=MyBatisUtils.getSession();
		UsersDao uDao=session.getMapper(UsersDao.class);		
		Users u=uDao.getUsersById("2");
		System.out.println(u);
		session.close();
	
		SqlSession session1=MyBatisUtils.getSession();
		UsersDao uDao1=session1.getMapper(UsersDao.class);		
		Users u1=uDao1.getUsersById("2");
		System.out.println(u1);
		session1.close();
	
	}
	
}
