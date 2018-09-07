package org.wuzhe.tysfhelper.service;

import org.wuzhe.tysfhelper.pojo.AttachFile;

public interface IAttachFileService {
	 public void addAttachFile(AttachFile attachfile);
	 public String queryAttachFileName(String afid);
}
