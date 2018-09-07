package org.wuzhe.tysfhelper.controller.student;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
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
import org.wuzhe.tysfhelper.service.IWxStudentService;

@Controller
@RequestMapping("queryClassroom.do")
public class DayfreeSel_SYFB {
	/**
	 * 初始化查询界面
	 */
	@Resource
	private IWxStudentService wxStudentService;

	@RequestMapping(method = RequestMethod.GET)
	public String init(String openid, HttpServletRequest request) {
		request.getSession().setAttribute("openid", openid);
		return "student/queryClassroom";
	}
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView Free(HttpServletRequest request, HttpServletResponse response,
			@RequestParam Map<String, String> params) {
		// 创建httpClient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 创建响应对象
		CloseableHttpResponse resp = null;
		// 链接地址用于空教室查询
		String uri = "http://jwc.tynu.edu.cn/ZNPK/DayfreeSel_SYFB_rpt.aspx";
		// 建立post请求，传输表单数据
		HttpPost post = new HttpPost(uri);
		// 浏览器能够处理的内容类型
		post.setHeader("Accept",
				"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
		// 浏览器能够处理的压缩编码
		post.setHeader("Accept-Encoding", "gzip, deflate");
		// 浏览器当前设置的语言
		post.setHeader("Accept-Language", "zh-CN,zh;q=0.8");
		// 用来指定当前的请求/回复中的，是否使用缓存机制。
		post.setHeader("Cache-Control", "no-cache");
		// 浏览器与服务器之间连接的类型
		post.setHeader("Connection", "keep-alive");
		// 请求体的MIME类型 （用于POST和PUT请求中）
		post.setHeader("Content-Type", "application/x-www-form-urlencoded");
		// 表示服务器的域名以及服务器所监听的端口号。如果所请求的端口是对应的服务的标准端口（80），则端口号可以省略
		post.setHeader("Host", "jwc.tynu.edu.cn");
		// 发起一个针对跨域资源共享的请求（该请求要求服务器在响应中加入一个Access-Control-Allow-Origin的消息头，表示访问控制所允许的来源）
		post.setHeader("Origin", "http://jwc.tynu.edu.cn");
		// 与具体的实现相关，这些字段可能在请求/回应链中的任何时候产生。
		post.setHeader("Pragma", "no-cache");
		// 发出请求的页面的URL
		post.setHeader("Referer", "http://jwc.tynu.edu.cn/ZNPK/DayfreeSel_SYFB.aspx");
		// 浏览器可以处理https协议，然后服务器返回Content-Security-Policy:
		// upgrade-insecure-requests头，或者通过meta头设置，告诉浏览器，对于页面的http资源，请求时可以自动升级到https
		post.setHeader("Upgrade-Insecure-Requests", "1");
		// 浏览器的用户代理字符串
		post.setHeader("User-Agent", request.getHeader("User-Agent"));
		// 设置参数
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		// 获取表单的键
		Set<String> keys = params.keySet();
		// 通过循环键，得到值，并添加到参数中 剔除教学楼姓名
		for (String key : keys) {
			if (!"JXL_Name".equals(key)) {
				list.add(new BasicNameValuePair(key, params.get(key)));
			}
		}
		// 将参数打包成请求体
		UrlEncodedFormEntity entity = null;
		Map<String, List<String>> resultMap = null;
		try {
			entity = new UrlEncodedFormEntity(list, "gb2312");
			// 将请求体传入
			post.setEntity(entity);
			resp = httpClient.execute(post);
			// 获取响应码
			int statusCode = resp.getStatusLine().getStatusCode();
			// 200为链接成功
			if (statusCode == 200) {
				// 获取网页数据
				String html = EntityUtils.toString(resp.getEntity(), "gb2312");
				// 解析网页数据得到doc对象
				Document doc = Jsoup.parse(html);
				// 通过正则表达式获取响应td内容 必须有字母组成的任意字符串
				Elements elements = doc.select("td:matchesOwn(.*[a-zA-Z]+.*)");
				// 处理结果总集合
				resultMap = new LinkedHashMap<>();// 为了保证读取顺序
				List<String> list1 = new ArrayList<>();// 1层
				List<String> list2 = new ArrayList<>();// 2层
				List<String> list3 = new ArrayList<>();// 3层
				List<String> list4 = new ArrayList<>();// 4层
				List<String> list5 = new ArrayList<>();// 4层
				// 循环获得的结果集
				for (Element e : elements) {
					// 获取td中的字符串
					int len = e.text().length();
					// 截取字符串获得所需要的内容
					String result = e.text().substring(len - 4, len);
					// 获取关键字判断楼层
					String keyword = result.substring(1, 2);
					if (keyword.contains("1")) {
						list1.add(result);
					} else if (keyword.contains("2")) {
						list2.add(result);
					} else if (keyword.contains("3")) {
						list3.add(result);
					} else if (keyword.contains("4")) {
						list4.add(result);
					} else if (keyword.contains("5")) {
						list5.add(result);
					}
				}

				// 判断该楼层是否有空教室
				if (list1.size() > 0) {
					resultMap.put("一", list1);
				}
				if (list2.size() > 0) {
					resultMap.put("二", list2);
				}
				if (list3.size() > 0) {
					resultMap.put("三", list3);
				}
				if (list4.size() > 0) {
					resultMap.put("四", list4);
				}
				if (list5.size() > 0) {
					resultMap.put("五", list5);
				}
			} else {
				throw new Exception("教务网链接失败");
			}
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (ClientProtocolException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 获取请求的教学楼姓名
		String floor = params.get("JXL_Name");
		// 建立对象
		ModelAndView mv = new ModelAndView();
		// 传入楼名参数
		mv.addObject("floor", floor);
		// 传入结果集参数
		mv.addObject("resultMap", resultMap);
		// 设置响应页面
		mv.setViewName("student/resultShow");
		return mv;
	}
}
