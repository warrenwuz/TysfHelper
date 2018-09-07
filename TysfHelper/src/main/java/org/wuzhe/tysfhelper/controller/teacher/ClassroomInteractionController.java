package org.wuzhe.tysfhelper.controller.teacher;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.wuzhe.tysfhelper.pojo.ClassroomInteraction;
import org.wuzhe.tysfhelper.pojo.ClassroomInterationRecord;
import org.wuzhe.tysfhelper.pojo.Data;
import org.wuzhe.tysfhelper.service.IClassroomInteractionService;
import org.wuzhe.tysfhelper.service.IClassroomInterationRecordService;
import org.wuzhe.tysfhelper.utils.GsonUtils;
import org.wuzhe.tysfhelper.utils.UUIDUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.soecode.wxtools.api.WxConsts;
import com.soecode.wxtools.api.WxService;
import com.soecode.wxtools.bean.WxQrcode;
import com.soecode.wxtools.bean.WxQrcode.WxQrActionInfo;
import com.soecode.wxtools.bean.WxQrcode.WxQrActionInfo.WxScene;
import com.soecode.wxtools.bean.result.QrCodeResult;
import com.soecode.wxtools.exception.WxErrorException;
import com.soecode.wxtools.util.http.URIUtil;

@Controller
@RequestMapping("teacher")
public class ClassroomInteractionController {
	@Resource
	private WxService wxService;
	@Resource
	private IClassroomInteractionService classroomInteractionService;
	@Resource
	private IClassroomInterationRecordService iClassroomInterationRecordService;

	@RequestMapping("addClassroomInteraction.do")
	@ResponseBody
	public String addClassroomInteraction(String ciname, HttpSession httpSession) {
		    ClassroomInteraction classroomInteraction = new ClassroomInteraction();
			classroomInteraction.setCiid(UUIDUtils.getUUID());
			classroomInteraction.setCiname(ciname);
			classroomInteraction.setTid((String) httpSession.getAttribute("id"));
			classroomInteractionService.addClassroomInteraction(classroomInteraction);
		     return  classroomInteraction.getCiid();
	}

	@RequestMapping("classroomInteractionForJson.do")
	@ResponseBody
	public String classroomInteraction(@RequestParam(defaultValue = "1") Integer pageNumber,
									   @RequestParam(defaultValue = "10") Integer pageSize,HttpSession session) {
		PageHelper.startPage(pageNumber, pageSize);
		List<ClassroomInteraction> classroomInteractions = classroomInteractionService.queryClassroomInteractionByTid((String) session.getAttribute("id"));
		PageInfo<ClassroomInteraction> page = new PageInfo<ClassroomInteraction>(classroomInteractions);
		return new Data<ClassroomInteraction>(page.getTotal(),page.getList()).toJson();
	}

	@RequestMapping(value = "modifyClassroomInteraction.do", method = RequestMethod.POST)
	@ResponseBody
	public String modifyvClassroomInteraction(ClassroomInteraction classroomInteraction) {
		classroomInteractionService.updateClassroomInteraction(classroomInteraction);
		return "1";
	}

	@RequestMapping(value = "createClassroomInteraction.do")
	public ModelAndView createClassroomInteraction(String ciid,String[]schoolclass) {
		System.out.println(ciid+schoolclass.length);
		for(String cid:schoolclass){//添加互动课堂记录
			ClassroomInterationRecord classroomInterationRecord=new ClassroomInterationRecord();
			classroomInterationRecord.setCid(cid);
			classroomInterationRecord.setCiid(ciid);
			classroomInterationRecord.setEfficacy(true);
			iClassroomInterationRecordService.addClassroomInterationRecord(classroomInterationRecord);
		}
		ModelAndView mv = new ModelAndView();
		WxQrcode code = new WxQrcode();
		code.setAction_name("QR_STR_SCENE");
		code.setAction_info(new WxQrActionInfo(new WxScene(ciid)));
		code.setExpire_seconds(720);
		try {
			QrCodeResult result = wxService.createQrCode(code);
			wxService.downloadQrCode(new File("C://Temp"), result.getTicket());
			mv.addObject("ticket", result.getTicket());
			mv.setViewName("teacher/ReleaseClassroomInteraction");
		} catch (WxErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping(value = "downCodeImage.do")
	public void downCodeImage(String ticket, HttpServletResponse response) {
		String url = WxConsts.URL_DOWNLOAD_QR_CODE.replace("TICKET", URIUtil.encodeURIComponent(ticket));
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet get = new HttpGet(url);
		CloseableHttpResponse resp = null;
		OutputStream out = null;
		try {
			resp = httpClient.execute(get);
			HttpEntity entity = resp.getEntity();
			byte[] byteArray = EntityUtils.toByteArray(entity);
			out = response.getOutputStream();
			out.write(byteArray);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				resp.close();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
