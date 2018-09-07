package org.wuzhe.tysfhelper.service;

import java.util.List;

import org.wuzhe.tysfhelper.pojo.ReplayMessage;

public interface IReplayMessageService {
	public List<ReplayMessage> queryRepalyMessage(String mid);
	  public void addRepalyMessage(ReplayMessage replayMessage);
}
