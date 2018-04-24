package com.company.demo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Grade 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int gid;
	private String gname;
	//一对多 mappedBy="grade" 是学生表中的grade懒加载
	@OneToMany(mappedBy="grade",fetch=FetchType.LAZY)
	private List<Student> list;
	
	
	public List<Student> getList() {
		return list;
	}
	public void setList(List<Student> list) {
		this.list = list;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String sname) {
		this.gname = sname;
	}
	

}
