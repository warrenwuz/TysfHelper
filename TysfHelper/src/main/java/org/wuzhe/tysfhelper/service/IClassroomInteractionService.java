package org.wuzhe.tysfhelper.service;

import java.util.List;

import org.wuzhe.tysfhelper.pojo.ClassroomInteraction;

public interface IClassroomInteractionService {
   //添加课堂互动
   public void addClassroomInteraction(ClassroomInteraction classroomInteraction);
   //查询互动
   public List<ClassroomInteraction> queryClassroomInteractions();
   //查询互动
   public List<ClassroomInteraction> queryClassroomInteractionByTid(String tid);
   //修改互动主题
   public void updateClassroomInteraction(ClassroomInteraction classroomInteraction);
   public ClassroomInteraction findClassroomInterationByCiId(String ciid);
}
