package org.wuzhe.tysfhelper.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.wuzhe.tysfhelper.dao.IWxStudentDao;
import org.wuzhe.tysfhelper.pojo.WxStudent;
import org.wuzhe.tysfhelper.service.IWxStudentService;

import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.bean.result.WxOAuth2AccessTokenResult;
import com.soecode.wxtools.exception.WxErrorException;
@Service
public class WxStudentServiceImpl implements IWxStudentService {
	@Resource
	private IService iService;
	@Resource
	private IWxStudentDao wxDao;

	@Override
	public void saveIWxStudent(WxStudent wx) {
		wxDao.saveIWxStudent(wx);
	}

	@Override
	public WxStudent selectWxStduent(String openid) {
		return wxDao.selectWxStduent(openid);
	}

	@Override
	public String authorityWxStudent(String code) throws WxErrorException {
		WxOAuth2AccessTokenResult oauth2ToGetAccessToken = iService.oauth2ToGetAccessToken(code);
		String openid = oauth2ToGetAccessToken.getOpenid();
		return openid;
	}

}
