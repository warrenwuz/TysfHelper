package org.wuzhe.tysfhelper.dao;

import java.util.List;

import org.wuzhe.tysfhelper.pojo.ClassroomInteraction;

public interface IClassroomInteractionDao {
  //添加互动
  public void addClassroomInteraction(ClassroomInteraction classroomInteraction);
  //查询互动
  public List<ClassroomInteraction> queryClassroomInteractions();
  //修改互动主题
  public void updateClassroomInteraction(ClassroomInteraction classroomInteraction);

  List<ClassroomInteraction> queryClassroomInteractionByTid(String tid);
}
