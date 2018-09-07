package org.wuzhe.tysfhelper.service;

import java.util.List;

import org.wuzhe.tysfhelper.pojo.Homework;
import org.wuzhe.tysfhelper.pojo.HomeworkNotice;

import com.soecode.wxtools.bean.TemplateSender;

public interface IHomeworkService {
	public void addHomework(Homework homework);
	public void addHomeworkNotice(List<HomeworkNotice>list);
	public List<TemplateSender> queryOpenidListBySCid(String[]cid, Homework homework, String tname);
}
