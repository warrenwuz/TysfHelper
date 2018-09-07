package org.wuzhe.tysfhelper.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.wuzhe.tysfhelper.dao.IMessageDao;
import org.wuzhe.tysfhelper.dao.IReplayMessageDao;
import org.wuzhe.tysfhelper.pojo.Message;
import org.wuzhe.tysfhelper.pojo.ReplayMessage;
import org.wuzhe.tysfhelper.pojo.TemplateContent;
import org.wuzhe.tysfhelper.pojo.TemplateData;
import org.wuzhe.tysfhelper.service.IMessageService;

import com.soecode.wxtools.bean.TemplateSender;

@Service
public class MessageServiceImpl implements IMessageService {
	@Resource
	private IMessageDao messageDao;
	@Resource
	private IReplayMessageDao repalyMessageDao;

	@Override
	public void WriterMessage(Message message) {
		messageDao.writerMessage(message);
	}

	@Override
	public List<Message> queryMessageByOpenid(String openid) {
		return messageDao.queryMessageByOpenid(openid);
	}

	@Override
	public List<Map<String, Object>> queryMessageByTid(String Tid) {
		List<Map<String, Object>> list = messageDao.queryMessageByTid(Tid);
		for (int i = 0; i < list.size(); i++) {
			String time = ((Timestamp) list.get(i).get("timestamp")).toString();
			time = time.substring(0, time.lastIndexOf("."));
			list.get(i).put("timestamp", time);
			String mid = (String) list.get(i).get("mid");
			List<ReplayMessage> repalyMessageList = repalyMessageDao.queryRepalyMessage(mid);
			if (repalyMessageList.size() == 0) {
				list.get(i).put("repalyMessageList", null);
			} else {
				list.get(i).put("repalyMessageList", repalyMessageList);
			}
		}

		return list;
	}

	@Override
	public List<Map<String, Object>> queryUnReadMessageByTid(String Tid) {
		List<Map<String, Object>> list = messageDao.queryUnReadMessageByTid(Tid);
		for (int i = 0; i < list.size(); i++) {
			String time = ((Timestamp) list.get(i).get("timestamp")).toString();
			time = time.substring(0, time.lastIndexOf("."));
			list.get(i).put("timestamp", time);
			String mid = (String) list.get(i).get("mid");
			List<ReplayMessage> repalyMessageList = repalyMessageDao.queryRepalyMessage(mid);
			if (repalyMessageList.size() == 0) {
				list.get(i).put("repalyMessageList", null);
			} else {
				list.get(i).put("repalyMessageList", repalyMessageList);
			}
		}

		return list;
	}

	@Override
	public String queryIsReadCount(String Tid) {
		int count = messageDao.queryIsReadCount(Tid);
		if (count == 0) {
			return "";
		}
		return count + "";
	}

	@Override
	public String queryOpenidByMid(String mid) {
		return messageDao.queryOpenidByMid(mid);
	}

	/**
	 * @return 微信模板消息
	 */
	@Override
	public TemplateSender getTempateSender(String name, String content, String mid, Timestamp timestamp) {
		String openid = queryOpenidByMid(mid);
		TemplateContent first = new TemplateContent(name + "老师回复了你的留言", "#173177");
		TemplateContent keynote1 = new TemplateContent(content, "#173177");
		TemplateContent keynote2 = new TemplateContent(timestamp.toString().substring(0, 19), "#173177");
		TemplateData data = new TemplateData(first, keynote1, keynote2);
		TemplateSender template = new TemplateSender();
		template.setTemplate_id("8JFDzfGIdUUQJtvhEONLso7fF4Ek_9VmSH3JOjWXTHE");
		template.setTouser(openid);
		template.setUrl("www.baidu.com");
		template.setData(data);
		return template;
	}

	@Override
	public void updateUnReadMessage(String tid) {
		 messageDao.updateUnReadMessage(tid);
	}

}
