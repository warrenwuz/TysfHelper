package org.wuzhe.tysfhelper.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.wuzhe.tysfhelper.dao.IClassroomDao;
import org.wuzhe.tysfhelper.pojo.Classroom;
import org.wuzhe.tysfhelper.service.IClassroomService;
@Service
public class ClassroomServiceImpl implements IClassroomService {
	@Resource
  private IClassroomDao classroomDao;
	@Override
	public void addClassroom(Classroom classroom) {
        classroomDao.addClassroom(classroom);
	}

}
