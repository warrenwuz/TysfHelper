package org.wuzhe.tysfhelper.controller.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wuzhe.tysfhelper.pojo.Message;
import org.wuzhe.tysfhelper.pojo.Teacher;
import org.wuzhe.tysfhelper.pojo.TysfHelperTimestamp;
import org.wuzhe.tysfhelper.service.IMessageService;
import org.wuzhe.tysfhelper.service.ITeacherService;
import org.wuzhe.tysfhelper.utils.UUIDUtils;

import com.google.gson.Gson;

/**
 * 留言系统
 * 
 * @author wuzhe
 *
 */
@Controller
public class MessageController {
	@Resource
	private ITeacherService teacherSrevice;
	@Resource
	private IMessageService messageService;

	@RequestMapping(value = "writerMessage.do", method = RequestMethod.GET)
	public String initWriter(String openid, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("openid", openid);
		List<Message>list=messageService.queryMessageByOpenid(openid);
		request.setAttribute("messageList", list);
		return "student/message";
	}

	@RequestMapping(value = "writerMessage.do", method = RequestMethod.POST)
	public void writerMessage(String id, String text, HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out = null;
		try {
			Teacher teacher = teacherSrevice.queryTeacherByTid(id);
			out = response.getWriter();
			if (teacher == null) {
				out.write("1");
			} else {
				Timestamp timestamp=new TysfHelperTimestamp(System.currentTimeMillis());
				String openid = (String) request.getSession().getAttribute("openid");
				Message message = new Message(UUIDUtils.getUUID(), text, openid, id,timestamp,"0");
				messageService.WriterMessage(message);
				
				out.write("0");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			out.close();
		}

	}
	@RequestMapping("showMessage.do")
	public void showMessage(HttpServletRequest request,HttpServletResponse response){
		String openid=(String) request.getSession().getAttribute("openid");
		List<Message>list=messageService.queryMessageByOpenid(openid);
	     Gson gson=new Gson();
	     String json = gson.toJson(list);
	     System.out.println(json);
		try {
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
