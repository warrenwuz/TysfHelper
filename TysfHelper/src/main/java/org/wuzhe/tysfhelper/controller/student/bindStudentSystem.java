package org.wuzhe.tysfhelper.controller.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.wuzhe.tysfhelper.pojo.WxStudent;
import org.wuzhe.tysfhelper.service.IQueryGradeService;
import org.wuzhe.tysfhelper.service.IWxStudentService;

@Controller
/**
 * 绑定系统
 * 
 */
@RequestMapping("bindWxSystem.do")
public class bindStudentSystem {
	@Resource
	private IWxStudentService wxStudentService;
	@Resource
	private IQueryGradeService  queryGradeService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView init(HttpServletRequest request, String openid) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		CookieStore cookieStore = new BasicCookieStore();// 建立CookieStore
		try {
			// 建立连接模拟请求
			CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
			String uri = "http://jwc.tynu.edu.cn/_data/login.aspx";
			HttpGet httpGet = new HttpGet(uri);
			httpGet.setHeader("Host", "jwc.tynu.edu.cn");
			httpGet.setHeader("User-Agent",
					"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36");
			httpGet.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
			httpGet.setHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
			httpGet.setHeader("Accept-Encoding", "gzip, deflate");
			httpGet.setHeader("Connection", "keep-alive");
			httpGet.setHeader("Upgrade-Insecure-Requests", "1");
			httpGet.setHeader("Cache-Control", "max-age=0");
			CloseableHttpResponse response = null;
			response = httpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			String html = EntityUtils.toString(entity, "gb2312");
			Document doc = Jsoup.parse(html);
			Elements elementsByAttribute = doc.getElementsByTag("input");
			for (Element e : elementsByAttribute) {
				if (e.val() != "") {
					System.out.println("e.val=" + e.val());
					mv.addObject("__VIEWSTATE", e.val());
				}
			}

		} catch (ClientProtocolException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		session.setAttribute("cookieStore", cookieStore);
		session.setAttribute("openid", openid);
		mv.setViewName("student/bindSystem");
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public void getLogin(HttpServletRequest request, HttpServletResponse response,
			@RequestParam Map<String, String> param) {
		CookieStore cookieStore = (CookieStore) request.getSession().getAttribute("cookieStore");
		String openid = (String) request.getSession().getAttribute("openid");
		CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
		CloseableHttpResponse resp = null;
		PrintWriter out = null;
		String uri = "http://jwc.tynu.edu.cn/_data/login.aspx";
		HttpPost post = new HttpPost(uri);
		post.setHeader("Accept",
				"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
		post.setHeader("Accept-Encoding", "gzip, deflate");
		post.setHeader("Accept-Language", "zh-CN,zh;q=0.8");
		post.setHeader("Cache-Control", "no-cache");
		post.setHeader("Connection", "keep-alive");
		post.setHeader("Content-Type", "application/x-www-form-urlencoded");
		post.setHeader("Host", "jwc.tynu.edu.cn");
		post.setHeader("Origin", "http://jwc.tynu.edu.cn");
		post.setHeader("Pragma", "no-cache");
		post.setHeader("Referer", "http://jwc.tynu.edu.cn/_data/login.aspx");
		post.setHeader("Upgrade-Insecure-Requests", "1");
		post.setHeader("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36");
		System.out.println(request.getHeader("User-Agent"));
		// 设置参数
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		Set<String> keys = param.keySet();
		for (String key : keys) {
			System.out.println("key=" + key + "=====" + param.get(key));
			list.add(new BasicNameValuePair(key, param.get(key)));
		}
		try {
			UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(list, "gb2312");
			post.setEntity(urlEncodedFormEntity);
			resp = httpClient.execute(post);
			int statusCode = resp.getStatusLine().getStatusCode();
			out = response.getWriter();
			if (statusCode == 200) {
				HttpEntity entity = resp.getEntity();
				String html = EntityUtils.toString(entity);
				System.out.println(html);
				Document doc = Jsoup.parse(html);
				Elements elements = doc.select("font");// 通过解析获取响应的页面信息
				String statusResult = elements.get(0).html();
				System.out.println("statusResult=" + statusResult);
				if (statusResult.contains("正在加载权限数据")) {
					out.write("0");
					String stuId = param.get("txt_asmcdefsddsd");
					String password = param.get("dsdsdsdsdxcxdfgfg");
					WxStudent wx = new WxStudent(openid, stuId, password);
					wxStudentService.saveIWxStudent(wx);
				} else if (statusResult.contains("帐号或密码不正确")) {
					out.write("1");
				} else if (statusResult.contains("验证码错误")) {// 验证码错误
					out.write("2");
				} else {
					out.write("3");
				}
			} else {
				out.write("3");
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				resp.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
