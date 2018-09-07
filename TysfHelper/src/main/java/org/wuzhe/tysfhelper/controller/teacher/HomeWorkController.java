package org.wuzhe.tysfhelper.controller.teacher;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wuzhe.tysfhelper.controller.thread.TemplateSenderThread;
import org.wuzhe.tysfhelper.pojo.Homework;
import org.wuzhe.tysfhelper.pojo.HomeworkAttachFile;
import org.wuzhe.tysfhelper.pojo.HomeworkNotice;
import org.wuzhe.tysfhelper.service.IHomeworkAttachFileService;
import org.wuzhe.tysfhelper.service.IHomeworkService;
import org.wuzhe.tysfhelper.utils.UUIDUtils;

import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.bean.TemplateSender;

@Controller
@RequestMapping("teacher")
public class HomeWorkController {
	@Resource
	private ThreadPoolTaskExecutor taskExecutor;// Spring 线程池
	@Resource
	private IService IService;
	@Resource
	private IHomeworkService homeworkService;
	@Resource
	private IHomeworkAttachFileService homeworkAttachFileService;

	@RequestMapping(value = "releasehomework.do", method = RequestMethod.GET)
	public String initHomework() {
		return "teacher/releasehomework";
	}

	@RequestMapping(value = "releasehomework.do", method = RequestMethod.POST)
	public void releaseHomework(String[] file, String title, String content, HttpServletRequest request,
			HttpServletResponse response, String[] schoolclass, String sumbitdate) {
		PrintWriter out = null;
		try {
			HttpSession session = request.getSession();
			String tid = (String) session.getAttribute("id");
			String tname = (String) session.getAttribute("name");
			String hid = UUIDUtils.getUUID();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date(simpleDateFormat.parse(sumbitdate).getTime());
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			Homework homework = new Homework(title, content, timestamp, hid, tid, date);
			homeworkService.addHomework(homework);
			// 添加作业附件
			if (file != null) {
				for (String afid : file) {
					homeworkAttachFileService.addHomeworkAttachFile(new HomeworkAttachFile(afid, hid));
				}
			}
			// 通知设置的通知班级,查找需要通知的学生的集合
			List<TemplateSender> senderList = homeworkService.queryOpenidListBySCid(schoolclass, homework, tname);
			/**
			 * 通过线程进行群发
			 */
			for (int i = 0; i < senderList.size(); i++) {
				taskExecutor.execute(new TemplateSenderThread(IService, senderList.get(i)));
			}
			List<HomeworkNotice> list = new ArrayList<>();
			for (String cid : schoolclass) {
				list.add(new HomeworkNotice(hid, cid));
			}
			homeworkService.addHomeworkNotice(list);
			out = response.getWriter();
			out.write("1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}
	}
}
