package org.wuzhe.tysfhelper.dao;

import java.util.List;

import org.wuzhe.tysfhelper.pojo.ReplayMessage;

public interface IReplayMessageDao {
  public List<ReplayMessage> queryRepalyMessage(String mid);
  public void addRepalyMessage(ReplayMessage replayMessage);
}
