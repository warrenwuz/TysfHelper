package org.wuzhe.tysfhelper.service;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

//添加教学楼
public class InsertJXL {
	public void init() {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String uri = "http://jwc.tynu.edu.cn/ZNPK/Private/List_JXL.aspx?w=150&id=4";
		HttpGet httpGet = new HttpGet(uri);
		try {
			CloseableHttpResponse response = httpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			String html = EntityUtils.toString(entity);
			Document doc = Jsoup.parse(html);
			// 解析js脚本
			Elements elements = doc.getElementsByTag("script");
			for (Element e : elements) {
				// 获取js脚本内容
				String text = e.html().substring(e.html().indexOf("<select"), e.html().length() - 2);
				// 重新构建页面
				Document document = Jsoup.parse(text);
				// 利用正则表达式获取指定标签
				Elements element = document.select("option:matchesOwn([\u4e00-\u9fa5])");
				for (Element e1 : element) {
					System.out.println(e1.val() + e1.text());
				}
			}

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
