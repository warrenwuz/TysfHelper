package org.wuzhe.tysfhelper.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.wuzhe.tysfhelper.dao.ISchoolClassDao;
import org.wuzhe.tysfhelper.pojo.SchoolClass;
import org.wuzhe.tysfhelper.service.ISchoolClassService;
@Service
public class SchoolClassServiceImpl implements ISchoolClassService {
	@Resource
  private ISchoolClassDao schoolClassDao;
	@Override
	public void addSchoolClass(SchoolClass schoolClass) {
		schoolClassDao.addSchoolClass(schoolClass);

	}

}
