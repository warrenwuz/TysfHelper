package org.wuzhe.tysfhelper.controller.utils;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class GetVerificationCodeUtils {
	@RequestMapping("ValidateCode.do")
	public void init(HttpServletRequest request, HttpServletResponse response,String t) {
		CookieStore cookieStore=(CookieStore) request.getSession().getAttribute("cookieStore");
		CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
		String uri="http://jwc.tynu.edu.cn/sys/ValidateCode.aspx";
		if(t!=null){
			uri = "http://jwc.tynu.edu.cn/sys/ValidateCode.aspx?t="+t;
		}
		HttpGet post = new HttpGet(uri);
		post.setHeader("Accept", "*/*");
		post.setHeader("Accept-Encoding", "gzip, deflate");
		post.setHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
		post.setHeader("Connection", "keep-alive");
		post.setHeader("Host", "jwc.tynu.edu.cn");
		post.setHeader("Referer", "http://jwc.tynu.edu.cn/_data/login.aspx");
		post.setHeader("Connection", "keep-alive");
		post.setHeader("User-Agent", request.getHeader("User-Agent"));
		CloseableHttpResponse resp = null;
		OutputStream out = null;
		try {
			resp = httpClient.execute(post);
			HttpEntity entity = resp.getEntity();
			byte[] byteArray = EntityUtils.toByteArray(entity);
			out = response.getOutputStream();
			out.write(byteArray);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				resp.close();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
