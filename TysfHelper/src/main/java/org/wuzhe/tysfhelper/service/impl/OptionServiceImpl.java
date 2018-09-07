package org.wuzhe.tysfhelper.service.impl;

import org.springframework.stereotype.Service;
import org.wuzhe.tysfhelper.dao.IOptionDao;
import org.wuzhe.tysfhelper.pojo.Option;
import org.wuzhe.tysfhelper.service.IOptionService;

import javax.annotation.Resource;

@Service
public class OptionServiceImpl implements IOptionService {
    @Resource
    private IOptionDao iOptionDao;
    @Override
    public void addOption(Option option) {
        iOptionDao.addOption(option);
    }

    @Override
    public Long addOptionGetQuestionOptionId(Option option) {
        return iOptionDao.addOptionGetQuestionOptionId(option);
    }
}
