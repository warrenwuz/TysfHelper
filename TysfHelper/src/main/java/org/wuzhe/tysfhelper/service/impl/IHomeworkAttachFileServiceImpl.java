package org.wuzhe.tysfhelper.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.wuzhe.tysfhelper.dao.IHomeworkAttachFileDao;
import org.wuzhe.tysfhelper.service.IHomeworkAttachFileService;
@Service
public class IHomeworkAttachFileServiceImpl  implements IHomeworkAttachFileService{
    @Resource 
	private IHomeworkAttachFileDao  homeworkAttachFileDao;
	@Override
	public void addHomeworkAttachFile(org.wuzhe.tysfhelper.pojo.HomeworkAttachFile homeworkAttachFile) {
		homeworkAttachFileDao.addHomeworkAttachFile(homeworkAttachFile);
	}

}
