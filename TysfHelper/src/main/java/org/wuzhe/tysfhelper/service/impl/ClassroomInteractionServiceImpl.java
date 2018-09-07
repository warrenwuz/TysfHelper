package org.wuzhe.tysfhelper.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.wuzhe.tysfhelper.dao.IClassroomInteractionDao;
import org.wuzhe.tysfhelper.pojo.ClassroomInteraction;
import org.wuzhe.tysfhelper.service.IClassroomInteractionService;
@Service
public class ClassroomInteractionServiceImpl implements IClassroomInteractionService {
    @Resource
	private IClassroomInteractionDao classroomInteractionDao;
	@Override
	public void addClassroomInteraction(ClassroomInteraction classroomInteraction) {
		classroomInteractionDao.addClassroomInteraction(classroomInteraction);
	}
	@Override
	public List<ClassroomInteraction> queryClassroomInteractions() {
		return classroomInteractionDao.queryClassroomInteractions();
	}
	@Override
	public void updateClassroomInteraction(ClassroomInteraction classroomInteraction) {
		classroomInteractionDao.updateClassroomInteraction(classroomInteraction);
		
	}

	@Override
	public List<ClassroomInteraction> queryClassroomInteractionByTid(String tid) {
		return classroomInteractionDao.queryClassroomInteractionByTid(tid);
	}

	@Override
	public ClassroomInteraction findClassroomInterationByCiId(String ciid) {
		return null;
	}
}
