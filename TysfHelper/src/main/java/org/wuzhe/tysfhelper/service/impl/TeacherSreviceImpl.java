package org.wuzhe.tysfhelper.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.wuzhe.tysfhelper.dao.ITeacherDao;
import org.wuzhe.tysfhelper.pojo.SchoolClass;
import org.wuzhe.tysfhelper.pojo.Teacher;
import org.wuzhe.tysfhelper.service.ITeacherService;
@Service

public class TeacherSreviceImpl implements ITeacherService{
  @Resource
   private ITeacherDao teacherDao;
	@Override
	public Teacher queryTeacher(Teacher teacher) {
		return teacherDao.queryTeacher(teacher);
	}
	@Override
	public void addTeacher(Teacher teacher) {
		teacherDao.addTeacher(teacher);
		
	}
	@Override
	public Teacher queryTeacherByTid(String tid) {
		return teacherDao.queryTeacherByTid(tid);
	}
	@Override
	public List<SchoolClass> queryScoolClassByTid(String tid) {
		return teacherDao.queryScoolClassByTid(tid).getSchoolCLass();
	}

}
