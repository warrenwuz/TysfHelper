package org.wuzhe.tysfhelper.service;

import org.wuzhe.tysfhelper.pojo.ClassroomInterationRecord;

import java.util.List;

public interface IClassroomInterationRecordService {
    public void addClassroomInterationRecord(ClassroomInterationRecord classroomInterationRecord);//添加互动记录
    public List<ClassroomInterationRecord> queryClassroomInterationRecord(ClassroomInterationRecord classroomInterationRecord);
}
