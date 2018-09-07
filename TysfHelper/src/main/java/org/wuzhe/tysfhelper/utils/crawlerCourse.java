package org.wuzhe.tysfhelper.utils;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/**
 * 课程爬虫
 * @author wuzhe
 *
 */
public class crawlerCourse {
 public static void main(String[] args) throws IOException {
	  CloseableHttpClient httpClient=HttpClients.createDefault();
	     String uri="http://jwc.tynu.edu.cn/ZNPK/Private/List_XNXQKC.aspx?xnxq=20170";
	     HttpGet httpGet=new HttpGet(uri);
	     CloseableHttpResponse response = httpClient.execute(httpGet);
	     HttpEntity entity = response.getEntity();
	     String html=EntityUtils.toString(entity);
	     Document doc = Jsoup.parse(html);
	     Elements elements= doc.select("script");
	     for(Element e:elements){
	    	String val=e.html();
	     String newHtml=val.substring(val.indexOf("<select"));
	     Elements select=Jsoup.parse(newHtml).select("option");
	   for(int i=1;i<select.size();i++){
	    	   System.out.println(select.get(i).val());
	    	   System.out.println(select.get(i).html());
	    	   String []spit=select.get(i).html().split("|");
	    	   System.out.println(spit.length);
	    	   System.out.println();
	       }
	     }
	
}
}
