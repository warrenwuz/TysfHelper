package org.wuzhe.tysfhelper.dao;

import org.wuzhe.tysfhelper.pojo.Option;

public interface IOptionDao {
    Long addOptionGetQuestionOptionId(Option option);

    void addOption(Option option);
}
