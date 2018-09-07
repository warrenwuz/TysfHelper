package org.wuzhe.tysfhelper.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.wuzhe.tysfhelper.dao.ICourseDao;
import org.wuzhe.tysfhelper.pojo.Course;
import org.wuzhe.tysfhelper.service.ICourseService;
@Service
public class CourseServiceImpl implements ICourseService {
	@Resource
	private  ICourseDao courseDao;

	@Override
	public void addCourse(Course course) {
         courseDao.addCourse(course);
	}

}
