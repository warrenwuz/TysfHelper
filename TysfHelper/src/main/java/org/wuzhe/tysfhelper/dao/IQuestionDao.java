package org.wuzhe.tysfhelper.dao;

import org.wuzhe.tysfhelper.controller.teacher.QuestionController;
import org.wuzhe.tysfhelper.pojo.Question;

import java.util.List;

public interface IQuestionDao {
    public List<QuestionController> findQuestionByCiid(String ciid);//通过互动ID查找问题

    Long addQuestion(Question question);

    void setCorrectOptionByQuestionId(Question question);
}
