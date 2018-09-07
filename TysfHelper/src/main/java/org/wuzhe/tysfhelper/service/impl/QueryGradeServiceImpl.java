package org.wuzhe.tysfhelper.service.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
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
import org.springframework.stereotype.Service;
import org.wuzhe.tysfhelper.pojo.WxStudent;
import org.wuzhe.tysfhelper.service.IQueryGradeService;
import org.wuzhe.tysfhelper.utils.IdentifiyCodeUtils;
@Service
public class QueryGradeServiceImpl implements IQueryGradeService {
	private String VIEWSTATE;
	private CookieStore cookieStore;
    private String imgSrc;    
	/**
	 * 模拟初始化登陆页面 获取__VIEWSTATE值
	 */
	@Override
	public void LoginInit() throws Exception {
		cookieStore = new BasicCookieStore();// 建立CookieStore 跟踪会话
		CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
		CloseableHttpResponse response = null;
		String uri1 = "http://jwc.tynu.edu.cn/_data/login.aspx";
		HttpGet httpGet = new HttpGet(uri1);
		httpGet.setHeader("Host", "jwc.tynu.edu.cn");
		httpGet.setHeader("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36");
		httpGet.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		httpGet.setHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
		httpGet.setHeader("Accept-Encoding", "gzip, deflate");
		httpGet.setHeader("Connection", "keep-alive");
		httpGet.setHeader("Upgrade-Insecure-Requests", "1");
		httpGet.setHeader("Cache-Control", "max-age=0");
		response = httpClient.execute(httpGet);
		HttpEntity entity = response.getEntity();
		String html = EntityUtils.toString(entity, "gb2312");
		Document doc = Jsoup.parse(html);
		Elements elementsByAttribute = doc.getElementsByTag("input");
		for (Element e : elementsByAttribute) {
			if (e.val() != "") {
				setVIEWSTATE(e.val());
			}
		}
	}

	/**
	 * 模拟登陆教务网
	 */
	@Override
	public int LoginSystem(WxStudent wxStudent) throws Exception {
		System.out.println("cookieStore11="+cookieStore);
		CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
		CloseableHttpResponse resp = null;
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
		// 设置参数
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		list.add(new BasicNameValuePair("__VIEWSTATE", VIEWSTATE));
		list.add(new BasicNameValuePair("pcInfo",
				"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36undefined5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36 SN:NULL"));
		list.add(new BasicNameValuePair("typeName", "学生"));
		list.add(new BasicNameValuePair("dsdsdsdsdxcxdfgfg", wxStudent.getPassword()));// 密码
		list.add(new BasicNameValuePair("Sel_Type", "STU"));
		list.add(new BasicNameValuePair("txt_asmcdefsddsd", wxStudent.getStuId()));// 学号
		list.add(new BasicNameValuePair("txt_pewerwedsdfsdff", ""));
		list.add(new BasicNameValuePair("txt_sdertfgsadscxcadsads", ""));
		while (true) {
			int i = 0;
			String code = IdentifiyCodeUtils.IdentifiyCodeString(cookieStore, i);
			System.out.println("code="+code);
			list.add(new BasicNameValuePair("fgfggfdgtyuuyyuuckjg", code));// 验证码
			for(NameValuePair b:list){
				System.out.println(b);
			}
			UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(list, "gb2312");
			post.setEntity(urlEncodedFormEntity);
			resp = httpClient.execute(post);
			resp.getEntity();
			int statusCode = resp.getStatusLine().getStatusCode();
			if (statusCode == 200) {
				HttpEntity entity = resp.getEntity();
				String html = EntityUtils.toString(entity);
				System.out.println(html);
				Document doc = Jsoup.parse(html);
				Elements elements = doc.select("font");// 通过解析获取响应的页面信息
				String statusResult = elements.get(0).html();
				System.out.println("statusResult=" + statusResult);
				if (statusResult.contains("正在加载权限数据")) {
					return 0;
				}
			}
			return 1;
		}
	}

	@Override
	public void queryGrade(Map<String, String> param) throws Exception {
		CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
		CloseableHttpResponse resp = null;
		String uri = "http://jwc.tynu.edu.cn/xscj/Stu_MyScore_rpt.aspx";
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
		post.setHeader("Referer", "http://jwc.tynu.edu.cn/xscj/Stu_MyScore.aspx");
		post.setHeader("Upgrade-Insecure-Requests", "1");
		post.setHeader("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36");
		// 设置参数
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		Set<String> keys = param.keySet();
		for (String key : keys) {
			list.add(new BasicNameValuePair(key, param.get(key)));
		}
		UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(list, "gb2312");
		post.setEntity(urlEncodedFormEntity);
		resp = httpClient.execute(post);
		HttpEntity entity = resp.getEntity();
		String html=EntityUtils.toString(entity);
		System.out.println(html);
		Document doc = Jsoup.parse(html);
		Elements elements = doc.select("img");
		for(Element e:elements){
			imgSrc= e.attr("src");
			System.out.println("src="+imgSrc);
		}

	}

	@Override
	public byte[] showGrade() throws Exception {
		CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
		String uri = "http://jwc.tynu.edu.cn/xscj/"+imgSrc;
		HttpGet post = new HttpGet(uri);
		post.setHeader("Host", "jwc.tynu.edu.cn");
		post.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:56.0) Gecko/20100101 Firefox/56.0");
		post.setHeader("Accept", "*/*");
		post.setHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
		post.setHeader("Accept-Encoding", "gzip, deflate");
		post.setHeader("Referer", "http://jwc.tynu.edu.cn/xscj/Stu_MyScore_rpt.aspx");
		post.setHeader("Connection", "keep-alive");
		CloseableHttpResponse resp = null;
		byte[] byteArray = null;
		resp = httpClient.execute(post);
		HttpEntity entity = resp.getEntity();
	   byteArray = EntityUtils.toByteArray(entity);
	   return byteArray;
	}

	public String getVIEWSTATE() {
		return VIEWSTATE;
	}

	public void setVIEWSTATE(String vIEWSTATE) {
		this.VIEWSTATE = vIEWSTATE;
	}

	public CookieStore getCookieStore() {
		return cookieStore;
	}

	public void setCookieStore(CookieStore cookieStore) {
		this.cookieStore = cookieStore;
	}

	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
	

}
