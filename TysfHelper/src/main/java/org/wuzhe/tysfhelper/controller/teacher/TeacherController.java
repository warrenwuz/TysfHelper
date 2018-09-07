package org.wuzhe.tysfhelper.controller.teacher;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.wuzhe.tysfhelper.pojo.ReplayMessage;
import org.wuzhe.tysfhelper.pojo.SchoolClass;
import org.wuzhe.tysfhelper.pojo.Teacher;
import org.wuzhe.tysfhelper.pojo.TysfHelperTimestamp;
import org.wuzhe.tysfhelper.service.IClassroomInteractionService;
import org.wuzhe.tysfhelper.service.IMessageService;
import org.wuzhe.tysfhelper.service.IReplayMessageService;
import org.wuzhe.tysfhelper.service.ITeacherService;
import org.wuzhe.tysfhelper.utils.GsonUtils;
import org.wuzhe.tysfhelper.utils.UUIDUtils;

import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.bean.TemplateSender;
import com.soecode.wxtools.exception.WxErrorException;

@Controller
@RequestMapping("teacher")
public class TeacherController {
	@Resource
	private ITeacherService teacherService;
	@Resource
	private IMessageService messageService;
	@Resource
	private IReplayMessageService replayMessageService;
	@Resource
	private IService iservice;
	@Resource
	private IClassroomInteractionService classroomInteractionService;

	@RequestMapping("/login.do")
	public ModelAndView TeacherLogin(@RequestParam Map<String, String> params, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		Teacher teacher = new Teacher(params.get("username"), params.get("password"));
		teacher = teacherService.queryTeacher(teacher);
		if (teacher != null) {
			HttpSession session = request.getSession();
			session.setAttribute("id", teacher.getTid());
			session.setAttribute("name", teacher.getTname());
			mv.setViewName("redirect:teacher/showMessage.do");
			return mv;
		}
		mv.addObject("error", "用户名或密码错误,如果忘记密码请联系管理员");
		mv.setViewName("login");
		return mv;
	}
   /**
    * 展示学生留言
    * @param request
    * @return
    */
	@RequestMapping("/showMessage.do")
	public ModelAndView Message(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String tid = (String) session.getAttribute("id");
		List<Map<String, Object>> list = messageService.queryMessageByTid(tid);
		ModelAndView mv = new ModelAndView();
		mv.addObject("messageList", list);
		mv.setViewName("teacher/showMessage");
		return mv;
	}
	/**
	 * 删除留言
	 * @param request
	 * @param mid
	 */
    @RequestMapping("deleteMessage.do")
    public void deleteMessage(HttpServletRequest request,String mid){
    	
    }
    @RequestMapping("showUnreadMessage.do")
    public ModelAndView showUnreadMessage(HttpServletRequest request){
    	HttpSession session = request.getSession();
		String tid = (String) session.getAttribute("id");
		List<Map<String, Object>> list = messageService.queryUnReadMessageByTid(tid);
		ModelAndView mv = new ModelAndView();
		mv.addObject("messageList", list);
		mv.setViewName("teacher/showMessage");
		session.setAttribute("unreadcount", "");
		messageService.updateUnReadMessage(tid);
		return mv;
    }
    /**
     * 回复留言 并下发到公众号上
     * @param mid
     * @param content
     * @param date
     * @param request
     * @param response
     */
	@RequestMapping("writerReplayMessageService.do")
	public void writerReplayMessageService(String mid, String content, String date, HttpServletRequest request,
			HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
			long time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date).getTime();
			TysfHelperTimestamp timestamp = new TysfHelperTimestamp(time);
			ReplayMessage replayMessage = new ReplayMessage(UUIDUtils.getUUID(), content, mid, timestamp, "1");
			replayMessageService.addRepalyMessage(replayMessage);
			String tname = (String) request.getSession().getAttribute("name");
			// 微信模板消息
			TemplateSender template = messageService.getTempateSender(tname, content, mid, timestamp);
			out.write("1");
			/**
			 * 利用线程进行分布进行 提升响应速度
			 */
			wxTemplateSender wxSend=new wxTemplateSender(template);
			Thread sender=new Thread(wxSend);
			sender.start();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			out.close();
		}

	}
	/**
	 * 查找老师教的班级
	 * @param tid
	 * @param response
	 */
	@RequestMapping("querySchoolClass.do")
          public void queryScoolClassList(HttpServletResponse response,HttpSession session){
		     String tid=(String)session.getAttribute("id");
        	  List<SchoolClass> list = teacherService.queryScoolClassByTid(tid);
        	 String json=GsonUtils.getJsonStr(list);
        	response.setCharacterEncoding("utf-8");
        	 PrintWriter out=null;
        	  try {
				out=response.getWriter();
				out.write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				if(out!=null){
					out.close();
				}
			}
        	 
          }
	@RequestMapping("showTeacherMessage.do")
	public String showTeacherMessage(){
		return "teacher/teacherMessage";
	}
	/**
	 * 课堂互动
	 * @return
	 */
	@RequestMapping("classroomInteraction.do")
	public String classroomInteraction(){
		return "teacher/Hudong";
	}

	/**
	 * 发送作业通知的线程
	 * @author wuzhe
	 *
	 *
	 */
	class wxTemplateSender implements Runnable {
		private TemplateSender template;
		public wxTemplateSender(TemplateSender template) {
			super();
			this.template = template;
		}
		public void run() {
			try {
				iservice.templateSend(template);
			} catch (WxErrorException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
