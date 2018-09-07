package org.wuzhe.tysfhelper.service;

import org.wuzhe.tysfhelper.controller.teacher.QuestionController;
import org.wuzhe.tysfhelper.pojo.Question;

import java.util.List;

public interface IQuestionService {
    public List<QuestionController> findQuestionByCiid(String ciid);//通过互动ID查找问题

    public  Long addQuestion(Question question);//添加互动问题

    void setCorrectOptionByQuestionId(Question question);//设置正确答案

    Long findCorrectOptionById();
}
