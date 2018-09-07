package org.wuzhe.tysfhelper.service;
import java.util.Map;

import org.wuzhe.tysfhelper.pojo.WxStudent;
public interface IQueryGradeService {
/**
 * 模拟初始化教务系统
 *
 */
	public void LoginInit() throws Exception ;
	/**
	 * 模拟登陆教务系统
	 */
	public int  LoginSystem(WxStudent wxStudent)throws Exception ;
	/**
	 * 查看查询成绩
	 */
	public void queryGrade(Map<String,String>param)throws Exception;
	/**
	 *显示成绩图片
	 */
	public byte[] showGrade()throws Exception;
	
}
