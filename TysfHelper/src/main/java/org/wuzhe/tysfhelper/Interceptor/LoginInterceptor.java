package org.wuzhe.tysfhelper.Interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.wuzhe.tysfhelper.service.IMessageService;
/**
 * 登陆拦截器
 * @author wuzhe
 *
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
	@Resource
	private IMessageService messageService;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session=request.getSession();
		String id = (String)session.getAttribute("id");
		if(id==null&&"".equals("")){
			/*String path=request.getContextPath();
			System.out.println(path);*/
			request.getRequestDispatcher("/WEB-INF/error/errorLogin.jsp").forward(request, response);
			return false;
		}
		/**
		 * 利用拦截每次对未读消息进行渲染
		 */
		String unreadcount = messageService.queryIsReadCount(id);
		session.setAttribute("unreadcount", unreadcount);
		return true;
	}
}
