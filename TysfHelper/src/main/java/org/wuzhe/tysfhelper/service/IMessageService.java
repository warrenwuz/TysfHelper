package org.wuzhe.tysfhelper.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.wuzhe.tysfhelper.pojo.Message;

import com.soecode.wxtools.bean.TemplateSender;

public interface IMessageService {
  public void WriterMessage(Message message);
  public List<Message> queryMessageByOpenid(String openid);
  public List<Map<String,Object>> queryMessageByTid(String Tid);//通过教师ID查找学生留言
  public List<Map<String,Object>> queryUnReadMessageByTid(String Tid);//查找没有阅读的学生留言
  public String queryIsReadCount(String Tid);//查找没有阅读的留言
  public String queryOpenidByMid(String mid);//查询留言的微信用户
  public TemplateSender getTempateSender(String name,String content,String mid,Timestamp timestamp);
  public void updateUnReadMessage(String tid);//将未读的留言更正为已读留言
}
