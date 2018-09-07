package org.wuzhe.tysfhelper.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.wuzhe.tysfhelper.dao.IAttachFileDao;
import org.wuzhe.tysfhelper.pojo.AttachFile;
import org.wuzhe.tysfhelper.service.IAttachFileService;
@Service
public class AttachFileServiceImpl implements IAttachFileService {
	@Resource
  private IAttachFileDao  attachFileDao;
	@Override
	public void addAttachFile(AttachFile attachfile) {
         attachFileDao.addAttachFile(attachfile);
	}
	@Override
	public String queryAttachFileName(String afid) {
		return attachFileDao.queryAttachFileName(afid);
	}

}
