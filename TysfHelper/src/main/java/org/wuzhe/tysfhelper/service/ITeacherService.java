package org.wuzhe.tysfhelper.service;

import java.util.List;

import org.wuzhe.tysfhelper.pojo.SchoolClass;
import org.wuzhe.tysfhelper.pojo.Teacher;

public interface ITeacherService {
	public Teacher queryTeacher(Teacher teacher);

	public void addTeacher(Teacher teacher);

	public Teacher queryTeacherByTid(String tid);
	public List<SchoolClass> queryScoolClassByTid(String tid);
}
