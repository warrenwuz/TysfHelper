package org.wuzhe.tysfhelper.Interceptor;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxMessageInterceptor;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.exception.WxErrorException;
@Repository
public class ClickInterceptor implements WxMessageInterceptor {
	@Override
	public boolean intercept(WxXmlMessage wxMessage, Map<String, Object> context, IService iService)
			throws WxErrorException {
		String event=wxMessage.getEvent();
		if("CLICK".equals(event)){
			return true;
		}
		return false;
	}

}
