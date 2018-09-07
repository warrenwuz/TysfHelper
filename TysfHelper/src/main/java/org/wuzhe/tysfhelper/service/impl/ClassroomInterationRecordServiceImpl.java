package org.wuzhe.tysfhelper.service.impl;

import org.springframework.stereotype.Service;
import org.wuzhe.tysfhelper.dao.IClassroomInterationRecordDao;
import org.wuzhe.tysfhelper.pojo.ClassroomInterationRecord;
import org.wuzhe.tysfhelper.service.IClassroomInterationRecordService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClassroomInterationRecordServiceImpl implements IClassroomInterationRecordService {
    @Resource
    private IClassroomInterationRecordDao classroomInterationRecordDao;
    @Override
    public void addClassroomInterationRecord(ClassroomInterationRecord classroomInterationRecord) {
        classroomInterationRecordDao.addClassroomInterationRecord(classroomInterationRecord);
    }

    @Override
    public List<ClassroomInterationRecord> queryClassroomInterationRecord(ClassroomInterationRecord classroomInterationRecord) {
        return classroomInterationRecordDao.queryClassroomInterationRecord(classroomInterationRecord);
    }
}
