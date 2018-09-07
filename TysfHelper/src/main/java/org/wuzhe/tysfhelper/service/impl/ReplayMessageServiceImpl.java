package org.wuzhe.tysfhelper.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.wuzhe.tysfhelper.dao.IReplayMessageDao;
import org.wuzhe.tysfhelper.pojo.ReplayMessage;
import org.wuzhe.tysfhelper.service.IReplayMessageService;
@Service
public class ReplayMessageServiceImpl implements IReplayMessageService {
	@Resource
   private IReplayMessageDao  messageDao;
	@Override
	public List<ReplayMessage> queryRepalyMessage(String mid) {
		return messageDao.queryRepalyMessage(mid);
	}

	@Override
	public void addRepalyMessage(ReplayMessage replayMessage) {
         messageDao.addRepalyMessage(replayMessage);
	}

}
