package com.company.demo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Teacher 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int tid;
	private String tname;
	@Transient
	private int gid;
	//��ʦ�Ͱ༶����һ��һ����
	/**
	 * �Ͷ��һ�����ü�����ͬ��һ��һ�ı�Ĺ�ϵ���Ķ�ά��������
	 */
	@OneToOne(targetEntity=Grade.class,fetch=FetchType.LAZY)
	@JoinColumn(name="gid")
	private Grade grade;
	
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", tname=" + tname + ", gid=" + gid + "]";
	}
	

}
