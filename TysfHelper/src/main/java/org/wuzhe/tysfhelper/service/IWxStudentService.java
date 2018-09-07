package org.wuzhe.tysfhelper.service;

import org.wuzhe.tysfhelper.pojo.WxStudent;

import com.soecode.wxtools.exception.WxErrorException;

public interface IWxStudentService {
  //保存用户
	public void saveIWxStudent(WxStudent wx);
	//查找用户
	public WxStudent selectWxStduent(String openid);
	//权限认证登陆
	public String authorityWxStudent(String code)throws WxErrorException;
}
