package com.sist.news;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Component;
/*
 * 1 (16) =>1시간
 * 2 (23) =>2시간
 * 3 (30) =>4시간
 * 
 * */
@Component
//@Scope("prototype")
public class NewsManager {
	public List<Item> newsAllData(String data){
		List<Item> list = new ArrayList<Item>();
		try {
			
			// http://newssearch.naver.com/search.naver?where=rss&query=%EC%95%BC%EA%B5%AC
			URL url = new URL("http://newssearch.naver.com/search.naver?where=rss&query="+URLEncoder.encode(data, "UTF-8"));
			JAXBContext jc = JAXBContext.newInstance(Rss.class);
			Unmarshaller un = jc.createUnmarshaller();
			
			Rss rss=(Rss)un.unmarshal(url);
			list = rss.getChannel().getItem();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
