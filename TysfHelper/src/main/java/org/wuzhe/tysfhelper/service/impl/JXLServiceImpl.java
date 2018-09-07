package org.wuzhe.tysfhelper.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.wuzhe.tysfhelper.dao.IJXLDao;
import org.wuzhe.tysfhelper.pojo.JXL;
import org.wuzhe.tysfhelper.service.IJXLService;
@Service
public class JXLServiceImpl implements IJXLService {
	@Resource
  private IJXLDao jxlDao;
	@Override
	public void addJXl(JXL jxl) {
      jxlDao.addJXl(jxl);
	}
	@Override
	public List<JXL> queryAll() {
		
		return jxlDao.queryAll();
	}

}
