package org.wuzhe.tysfhelper.controller.student;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.wuzhe.tysfhelper.pojo.WxStudent;
import org.wuzhe.tysfhelper.service.IQueryGradeService;
import org.wuzhe.tysfhelper.service.IWxStudentService;

@Controller
public class QueryGrade {
	@Resource
	private IWxStudentService wxStudentService;
	private WxStudent wxStudent;
	@Resource
	private IQueryGradeService queryGradeService;

	@RequestMapping(value = "queryGrade.do", method = RequestMethod.GET)
	public String init(String openid) {
		try {
			wxStudent = wxStudentService.selectWxStduent(openid);
			queryGradeService.LoginInit();
			queryGradeService.LoginSystem(wxStudent);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "student/queryGrade";
	}

	@RequestMapping(value = "queryGrade.do", method = RequestMethod.POST)
	public void queryStudentGrade(@RequestParam Map<String, String> param, HttpServletResponse response) {
		PrintWriter out = null;
		try {
			queryGradeService.queryGrade(param);
			out = response.getWriter();
			out.write("1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping("showGrade.do")
	public void queryStudentGrade(HttpServletResponse response) {
		OutputStream out = null;
		try {
			byte[] imgByte = queryGradeService.showGrade();
			out = response.getOutputStream();
			out.write(imgByte);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
