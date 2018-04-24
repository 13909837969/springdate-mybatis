package com.qftjy.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.qftjy.bean.Teacher;
import com.qftjy.dao.TeacherDao;
import com.qftjy.dao.utils.MyBatisUtils;

import junit.framework.TestCase;

public class TestTeacher extends TestCase {
	/*
	 * myBatis 动态SQL
	 */
	//根据条件查询，姓名模糊查询、and  性别，
	public void test1(){
		//前端传递过的参数值
		Teacher t=new Teacher();
		t.setTname("张");
		//t.setSex("男");
		
		String sql="select * from teacher where 1=1";
		if(t.getTname() !=null && !"".equals(t.getTname())){
			sql+=" and tname like '%"+t.getTname()+"%'";
		}
		if(t.getSex()!=null && !"".equals(t.getSex())){
			sql+=" and sex ='"+t.getSex()+"'";
		}
		System.out.println(sql);
	}
	//用myBatis测试如上代码： if标签使用
	public void test2(){
		SqlSession session=MyBatisUtils.getSession();
		TeacherDao tDao=session.getMapper(TeacherDao.class);	
		Teacher t=new Teacher();
	t.setTname("老");
		t.setSex("男");
		
		List<Teacher> list=tDao.getListCont(t);
		System.out.println(list);
		session.close();
	}
	/*
	 * 更新 SQL
	 */
	public void testUpdate(){
		//前端传递过的参数值
		Teacher t=new Teacher();
		t.setTid("1");
		t.setTname("张");
		t.setSex("男");
		t.setRemark("aaaa");
		
		
		String sql=" update teacher set ";
		if(t.getTname()!=null){
			sql+=" tname='"+t.getTname()+"' ,";
		}
		if(t.getAge()!=null){
			sql+=" age="+t.getAge()+" ,";
		}
		if(t.getStatus()!=null){
			sql+=" status="+t.getStatus()+" ,";
		}
		if(t.getRemark()!=null){
			sql+=" remark='"+t.getRemark()+"',";
		}
		if(t.getSex()!=null){
			sql+=" sex='"+t.getSex()+"',";
		}
		System.out.println("根据传参生成的SQL:"+sql);
		sql=sql.substring(0,sql.length()-1);
		System.out.println("修改的SQL："+sql);
		sql+="  where tid='"+t.getTid()+"'";
		System.out.println("最终的SQL："+sql);
	}
	
	//测试上方的update set标签
	public void testUpdateSet(){
		SqlSession session=MyBatisUtils.getSession();
		TeacherDao tDao=session.getMapper(TeacherDao.class);	
		
		//前端传递过的参数值
				Teacher t=new Teacher();
				t.setTid("1");
				t.setTname("张");
				t.setSex("男");
				t.setRemark("aaaa");
				t.setAge(22);
				
		int num=tDao.updateTeacher(t);		
		System.out.println(num);
		session.close();
	}
	/*
	 * foreach
	 * 批量查询、批量删除
	 * 
	 */
	public void batchDelete(){
		//得到拼接的ID串
		String ids="aaaa,bbbb,cccc,dddd";
		String[] idsArr=ids.split(",");
		//批量删除的SQL语句
		//String sql="delete from Teacher where id in ('aaaaa','bbbb','ccc','ddd')";
		String sql=" delete from Teacher where id in (";
		for(int i=0;i<idsArr.length;i++){
			
			if(i==idsArr.length-1){
				sql+="'"+idsArr[i]+"'";
			}else{
				sql+="'"+idsArr[i]+"',";
			}
		}
		sql+=")";
		
		System.out.println(sql);
//		//另一种SQL语句
//		String sql1="delete from Teacher where 1!=1 ";
//		for(int i=0;i<idsArr.length;i++){
//			sql1+=" or tid='"+idsArr[i]+"'";
//		}
//		System.out.println(sql1);
	}
	//如上， myBatis批量删除  foreach 标签使用
	public void delBatchForeach(){
		SqlSession session=MyBatisUtils.getSession();
		TeacherDao tDao=session.getMapper(TeacherDao.class);	
		String ids="aaaa,bbbb,cccc,dddd";
		String[] idsArr=ids.split(",");
		int num=tDao.deletBatch(idsArr);
		System.out.println(num);
		session.close();
	}
	/*
	 * String  该类是用final修饰的  =>不能被继承，方法不能被重写...
	 * String str="aaa"  ==>在内存中 aaa
	 * String str1="aaa1" ==> aaa1
	 * StringBuffer sbStr="aaaa"  ==>aaaa123
	 * sbStr+="123"   ==>
	 */
	//测试mybatis 转入字符
	public void testAge(){
		SqlSession session=MyBatisUtils.getSession();
		TeacherDao tDao=session.getMapper(TeacherDao.class);	
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("min",20);
		map.put("max", 30);
		List<Teacher> list=tDao.getTeacherByAge(map);
		for(Teacher t:list){
			System.out.println(t);
		}
		session.close();
		
	}
}
