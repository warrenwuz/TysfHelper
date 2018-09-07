package org.wuzhe.tysfhelper.dao;

import java.util.List;
import java.util.Map;

import org.wuzhe.tysfhelper.pojo.Message;

public interface IMessageDao {
	public void writerMessage(Message message);
	public List<Message> queryMessageByOpenid(String openid);
	public List<Map<String,Object>> queryMessageByTid(String Tid);
	public List<Map<String,Object>> queryUnReadMessageByTid(String Tid);
	public int queryIsReadCount(String Tid);//查找没有阅读的留言
	public String queryOpenidByMid(String mid);
	public void updateUnReadMessage(String tid);
}
