package org.wuzhe.tysfhelper.hanlder.weixin;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxMessageHandler;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.bean.WxXmlOutMessage;
import com.soecode.wxtools.exception.WxErrorException;
import org.wuzhe.tysfhelper.pojo.WxStudent;

/**
 * 关注的推送内容
 * @author wuzhe
 *
 */
@Repository
public class SubscribeHanlder implements WxMessageHandler {

	@Override
	public WxXmlOutMessage handle(WxXmlMessage wxMessage, Map<String, Object> context, IService iService)
			throws WxErrorException {

		WxXmlOutMessage wxXmlOutMessage=WxXmlOutMessage.TEXT().content("欢迎关注太原师范学院\n在线报修公众平台\n<a href='http://io.tunnel.qydev.com/repairManager/wx/bindWxSystem.do?openid="+wxMessage.getFromUserName()+"'>点击绑定系统</a>\n用户名为学号\n密码为姓名首字母大写+学号 \n例如吴哲:WZ").toUser(wxMessage.getFromUserName())
				.fromUser(wxMessage.getToUserName()).build();
		return wxXmlOutMessage;
	}

}
