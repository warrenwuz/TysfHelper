package org.wuzhe.tysfhelper.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.wuzhe.tysfhelper.dao.IHomeworkDao;
import org.wuzhe.tysfhelper.pojo.Homework;
import org.wuzhe.tysfhelper.pojo.HomeworkNotice;
import org.wuzhe.tysfhelper.pojo.TemplateContent;
import org.wuzhe.tysfhelper.pojo.TemplateData;
import org.wuzhe.tysfhelper.service.IHomeworkService;

import com.soecode.wxtools.bean.TemplateSender;
@Service
public class HomeworkServiceImpl implements IHomeworkService {
	@Resource
   private IHomeworkDao homeworkDao;
	@Override
	public void addHomework(Homework homework) {
      homeworkDao.addHomework(homework);
	}
	@Override
	public void addHomeworkNotice(List<HomeworkNotice> list) {
		homeworkDao.addHomeworkNotice(list)	;	
	}
	@Override
	public List<TemplateSender> queryOpenidListBySCid(String[] cid, Homework homework, String tname) {
		String []list=homeworkDao.queryOpenidListBySCid(cid);
		List<TemplateSender> senderList=new ArrayList<>();
		for(String openid:list){
			TemplateContent first = new TemplateContent(homework.getHtitle(), "#173177");
			TemplateContent keynote1 = new TemplateContent(tname+"老师", "#173177");
			TemplateContent keynote2= new TemplateContent(homework.getTimestamp().toString().substring(0, 19), "#173177");
			TemplateContent keynote3 = new TemplateContent(homework.getDate().toString(), "#173177");
			TemplateContent remark = new TemplateContent("点击详情查看");
			TemplateData  data=new TemplateData(first, keynote1, keynote2, keynote3, remark);
			TemplateSender sender=new TemplateSender();
			sender.setData(data);
			sender.setTouser(openid);
			sender.setTemplate_id("Oe--g6OG_iV9GjJKelK2rgpc2QzLdn96pLMai4g9yHw");
			sender.setUrl("www.baidu.com");
			senderList.add(sender);
		}
		return 	senderList;
	}

}
