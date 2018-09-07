package org.wuzhe.tysfhelper.utils;
import java.util.Calendar;
import org.apache.http.HttpEntity;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.soecode.wxtools.util.crypto.MD5;

import net.sf.json.JSONObject;

public class IdentifiyCodeUtils {
	public static String IdentifiyCodeString(CookieStore cookieStore ,int i) throws Exception {
		CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
		String uri = "http://jwc.tynu.edu.cn/sys/ValidateCode.aspx";
		if ( i!= 0) {
			Calendar c=Calendar.getInstance();
			uri = "http://jwc.tynu.edu.cn/sys/ValidateCode.aspx?t=" + c.get(Calendar.MILLISECOND);
		}
		HttpGet post = new HttpGet(uri);
		post.setHeader("Accept", "*/*");
		post.setHeader("Accept-Encoding", "gzip, deflate");
		post.setHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
		post.setHeader("Connection", "keep-alive");
		post.setHeader("Host", "jwc.tynu.edu.cn");
		post.setHeader("Referer", "http://jwc.tynu.edu.cn/_data/login.aspx");
		post.setHeader("Connection", "keep-alive");
		post.setHeader("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36");
		CloseableHttpResponse resp = null;
		resp = httpClient.execute(post);
		HttpEntity entity = resp.getEntity();
		byte[] byteArray = EntityUtils.toByteArray(entity);
		String postPic = ChaoJiYing.PostPic("wuzhe1214", "wuzhe1206.", "894052", "1902", "0",
			byteArray);
		JSONObject jsonObject = JSONObject.fromObject(postPic);
		String key = jsonObject.getString("pic_str");
		String result = MD5.getMD5(MD5.getMD5(key.toUpperCase(), "").substring(0, 30).toUpperCase() + "10119", "")
				.substring(0, 30).toUpperCase();
		return result;
	}

}
