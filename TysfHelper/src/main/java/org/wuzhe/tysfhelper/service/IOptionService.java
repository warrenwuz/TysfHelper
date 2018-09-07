package org.wuzhe.tysfhelper.service;

import org.wuzhe.tysfhelper.pojo.Option;

public interface IOptionService {
    //添加选项
    public void addOption(Option option);
    //添加选项并返回主键
    public Long addOptionGetQuestionOptionId(Option option);
}
