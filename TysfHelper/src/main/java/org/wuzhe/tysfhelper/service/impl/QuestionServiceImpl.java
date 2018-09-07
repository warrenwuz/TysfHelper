package org.wuzhe.tysfhelper.service.impl;

import org.springframework.stereotype.Service;
import org.wuzhe.tysfhelper.controller.teacher.QuestionController;
import org.wuzhe.tysfhelper.dao.IQuestionDao;
import org.wuzhe.tysfhelper.pojo.Question;
import org.wuzhe.tysfhelper.service.IQuestionService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class QuestionServiceImpl implements IQuestionService {
    @Resource
    private IQuestionDao questionDao;
    @Override
    public List<QuestionController> findQuestionByCiid(String ciid) {
        return questionDao.findQuestionByCiid(ciid);
    }

    @Override
    public Long addQuestion(Question question) {
        return questionDao.addQuestion(question);
    }

    @Override
    public void setCorrectOptionByQuestionId(Question question) {
        questionDao.setCorrectOptionByQuestionId(question);
    }

    @Override
    public Long findCorrectOptionById() {
        return null;
    }
}
