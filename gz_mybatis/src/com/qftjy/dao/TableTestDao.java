package com.qftjy.dao;

import com.qftjy.bean.TableTest;

public interface TableTestDao {
	/*
	 * 根据ID查询显示实体
	 */
	public TableTest getById(int id);
	/*
	 * 根据ID，进行删除
	 */
	public int del(int id);
}
