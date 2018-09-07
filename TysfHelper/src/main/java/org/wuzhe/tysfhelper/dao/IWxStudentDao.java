package org.wuzhe.tysfhelper.dao;

import org.springframework.stereotype.Repository;
import org.wuzhe.tysfhelper.pojo.WxStudent;
@Repository
public interface IWxStudentDao {
	// 保存用户
	public void saveIWxStudent(WxStudent wx);

	// 查找用户
	public WxStudent selectWxStduent(String openid);
}
