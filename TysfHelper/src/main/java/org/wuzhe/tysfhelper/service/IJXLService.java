package org.wuzhe.tysfhelper.service;


import java.util.List;

import org.wuzhe.tysfhelper.pojo.JXL;

public interface IJXLService {
	public void addJXl(JXL jxl);
	public List<JXL> queryAll();
}
