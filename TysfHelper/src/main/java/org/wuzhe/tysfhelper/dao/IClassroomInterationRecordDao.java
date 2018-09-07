package org.wuzhe.tysfhelper.dao;

import org.wuzhe.tysfhelper.pojo.ClassroomInterationRecord;

import java.util.List;

public interface IClassroomInterationRecordDao {
    public void addClassroomInterationRecord(ClassroomInterationRecord classroomInterationRecord);

    List<ClassroomInterationRecord> queryClassroomInterationRecord(ClassroomInterationRecord classroomInterationRecord);
}
