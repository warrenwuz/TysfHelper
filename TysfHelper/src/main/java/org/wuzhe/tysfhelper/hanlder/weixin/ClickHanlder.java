package org.wuzhe.tysfhelper.hanlder.weixin;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.wuzhe.tysfhelper.pojo.WxStudent;
import org.wuzhe.tysfhelper.service.IWxStudentService;
import org.wuzhe.tysfhelper.utils.AddressApi;

import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxMessageHandler;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.bean.WxXmlOutMessage;
import com.soecode.wxtools.exception.WxErrorException;
@Repository
public class ClickHanlder implements WxMessageHandler {
	@Resource
	private IWxStudentService studentService;
	//主机地址
	private static final String address = AddressApi.Address;
	@Override
	public WxXmlOutMessage handle(WxXmlMessage wxMessage, Map<String, Object> context, IService iService)
			throws WxErrorException {
		String openid = wxMessage.getFromUserName();
		String linkStr = "";
		WxXmlOutMessage xmlOutMsg = null;
		if (judgeAuthorization(openid)) {
			String eventKey=wxMessage.getEventKey();
			String text=matchesKey(eventKey, openid);
			xmlOutMsg = WxXmlOutMessage.TEXT().content(text).toUser(wxMessage.getFromUserName())
					.fromUser(wxMessage.getToUserName()).build();	
			return xmlOutMsg;
		}
		linkStr += "<a href='"+address+"/TysfHelper/bindWxSystem.do?openid="+openid+"'>点击绑定教务系统</a>";
		xmlOutMsg = WxXmlOutMessage.TEXT().content("你还未绑定教务系统"+linkStr).toUser(wxMessage.getFromUserName())
				.fromUser(wxMessage.getToUserName()).build();
		return xmlOutMsg;
	}

	/**
	 * 用户身份判断
	 * 
	 * @param openid
	 * @return
	 */
	public boolean judgeAuthorization(String openid) {
		WxStudent wxStduent = studentService.selectWxStduent(openid);
		if (wxStduent != null) {
			return true;
		}
		return false;
	}

	/**
	 * 匹配事件key
	 */
	public String matchesKey(String eventKey, String openid) {
		String text = "";
		if ("Button11".equals(eventKey)) {
			text = "<a href='"+address+"/TysfHelper/queryClassroom.do'>点击查询空教室</a>";
		} else if ("Button12".equals(eventKey)) {
			text = "<a href='"+address+"/TysfHelper/queryGrade.do?openid="+openid + "'>点击查询成绩</a>";
		} else if ("Button13".equals(eventKey)) {
			text = "<a href='"+address+"/TysfHelper/bindWxSystem.do?openid="+ openid +"'>点击解除绑定</a>";
		}else if("Button21".equals(eventKey)){
			text = "<a href='"+address+"/TysfHelper/writerMessage.do?openid="+ openid +"'>点击写下你对老师想说的话</a>";
		}
		return text;

	}
}
