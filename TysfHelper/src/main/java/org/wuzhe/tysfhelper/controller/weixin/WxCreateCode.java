package org.wuzhe.tysfhelper.controller.weixin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.soecode.wxtools.api.WxService;
import com.soecode.wxtools.bean.WxQrcode;
import com.soecode.wxtools.bean.WxQrcode.WxQrActionInfo;
import com.soecode.wxtools.bean.WxQrcode.WxQrActionInfo.WxScene;

@Controller
public class WxCreateCode {
	@Resource
	private WxService wxService;
    public void init(){
    	  WxQrcode code = new WxQrcode();
          code.setAction_name("actionName");
          code.setAction_info(new WxQrActionInfo(new WxScene("scene_id/str")));
          code.setExpire_seconds(720);
    }
}
