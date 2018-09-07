package org.wuzhe.tysfhelper.dao;

import java.util.List;

import org.wuzhe.tysfhelper.pojo.Homework;
import org.wuzhe.tysfhelper.pojo.HomeworkNotice;

/**
 * 
 * @author wuzhe
 *
 */
public interface IHomeworkDao {
	public void addHomework(Homework homework);
	public void addHomeworkNotice(List<HomeworkNotice> list);
	public String[] queryOpenidListBySCid(String[] cid);
}
