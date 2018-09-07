package org.wuzhe.tysfhelper.dao;

import java.util.List;

import org.wuzhe.tysfhelper.pojo.JXL;

public interface IJXLDao {
	public void addJXl(JXL jxl);

	public List<JXL> queryAll();
}
