package com.company.demo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Student
{

	@Id
	private int sid;
	private String sname;
	@Transient
	private int gid;
	
	//���һӳ���������
	@ManyToOne(targetEntity=Grade.class,fetch=FetchType.LAZY)//���һ��һ������
	@JoinColumn(name="gid")//�ĸ�����й���targetEntity���͵����� ӳ���������gId
	private Grade grade ;
	
	
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	
}
