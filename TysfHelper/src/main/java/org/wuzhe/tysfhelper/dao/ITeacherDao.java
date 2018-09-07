package org.wuzhe.tysfhelper.dao;

import org.wuzhe.tysfhelper.pojo.Teacher;

public interface ITeacherDao {
    public Teacher queryTeacher(Teacher teacher);

	public void addTeacher(Teacher teacher);	
	public Teacher  queryTeacherByTid(String tid);
	public Teacher queryScoolClassByTid(String tid);//查询老师所教班级
}
