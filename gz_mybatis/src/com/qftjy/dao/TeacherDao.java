package com.qftjy.dao;

import java.util.List;
import java.util.Map;

import com.qftjy.bean.Teacher;

public interface TeacherDao  {
	//根据  ID查询老师信息，并将该老师对应的班级查询出来
	public Teacher getTeacherById(String id);
	public int add(Teacher t);
	
	
	//根据条件查询，姓名模糊查询、  性别，
	public List<Teacher> getListCont(Teacher u);
	//根据ID更新老师数据
	public int updateTeacher(Teacher t);
	//批量删除，根据ID数据
	public int deletBatch(String[] ids);
	//查询 查询年龄指定年龄区间的老师信息
	public List<Teacher> getTeacherByAge(Map<String,Object> map);
}
