package org.wuzhe.tysfhelper.controller.weixin;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxConsts;
import com.soecode.wxtools.exception.WxErrorException;
/**
 * 微信认证登陆
 * @author wuzhe
 *
 */
@Controller
public class WexinAuthorzation {
	@Resource
	private IService iService;
	@RequestMapping("wxAuthor.do")
   public String init(String url){
		String uri="";
	   try {
		  String newUrl="http://wuzhe.s1.natapp.cc/TysfHelper/"+url;
		 uri=iService.oauth2buildAuthorizationUrl(newUrl, WxConsts.OAUTH2_SCOPE_BASE, "");
	} catch (WxErrorException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
		return "redirect:"+uri;
   }
}
