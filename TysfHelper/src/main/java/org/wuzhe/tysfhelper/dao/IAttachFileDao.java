package org.wuzhe.tysfhelper.dao;

import org.wuzhe.tysfhelper.pojo.AttachFile;

public interface IAttachFileDao {
  public void addAttachFile(AttachFile attachfile);

    public String queryAttachFileName(String afid);
}
