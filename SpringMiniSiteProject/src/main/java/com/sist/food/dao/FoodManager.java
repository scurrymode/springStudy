package com.sist.food.dao;

/*
 * <div class="top_list_slide">
              <ul class="list-toplist-slider" style="width: 531px;">
                    <li>
                      <img class="center-croping"
                           src="https://mp-seoul-image-production-s3.mangoplate.com/keyword_search/meta/pictures/6mthe-5w3p5tg67w.jpg?fit=around|600:400&amp;crop=600:400;*,*&amp;output-format=jpg&amp;output-quality=80"
                           alt="6월의 핫한 카페 베스트 20곳 사진"
                           onerror="this.src='https://mp-seoul-image-production-s3.mangoplate.com/web/resources/kssf5eveeva_xlmy.jpg?fit=around|*:*&amp;crop=*:*;*,*&amp;output-format=jpg&amp;output-quality=80'"
                      />


                      <a href="/top_lists/1571_cafe_june"
                         onclick="common_ga('PG_MAIN','CLICK_LIST');">
                        <figure class="ls-item">
                          <figcaption class="info">
                            <div class="info_inner_wrap">
                              <span class="title">6월의 핫한 카페 베스트 20곳</span>

                              <p class="desc">"안 가볼 수 없을걸요?"</p>
 * */
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
@Component
public class FoodManager {
	public static void main(String[] args) {
		FoodManager fm = new FoodManager();
		fm.categoryAllData();
	}
	public List<CategoryVO> categoryAllData(){
		List<CategoryVO> list = new ArrayList<CategoryVO>();
		
		try {
			Document doc = Jsoup.connect("http://www.mangoplate.com/").get();
			Elements pelem = doc.select("ul.list-toplist-slider li img.center-croping"); //포스터
			Elements lelem = doc.select("ul.list-toplist-slider li a "); //링크
			Elements telem = doc.select("figure.ls-item div.info_inner_wrap span.title"); //타이틀
			Elements selem = doc.select("figure.ls-item div.info_inner_wrap p.desc"); //서브젝트
			for(int i=0; i<9;i++){
				Element pe=pelem.get(i);
				String poster = pe.attr("src");
				
				Element le = lelem.get(i);
				String link=le.attr("href");
				
				Element te = telem.get(i);
				String title = te.text();
				
				Element se = selem.get(i);
				String subject = se.text();
				
				CategoryVO vo = new CategoryVO();
				vo.setCate_no(i+1); //시퀀스를 직접 만들어서 넣는다. 
				vo.setPoster(poster);
				vo.setLink(link);
				vo.setCategory(title);
				vo.setSubject(subject);
				list.add(vo);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}
	
	public List<FoodVO> categoryDetailData(String link){
		List<FoodVO> list = new ArrayList<FoodVO>();
		try {
			Document doc=Jsoup.connect("http://www.mangoplate.com"+link).get();
			Elements nElem=doc.select("div.info span.title h3");
			Elements sElem=doc.select("div.info strong.point span");
			Elements aElem=doc.select("div.info p.etc");
			Elements pElem=doc.select("div.thumb img");
			Elements lElem=doc.select("div.info span.title a");
			for(int i=0; i<nElem.size();i++){
				Element name=nElem.get(i);
				Element poster = pElem.get(i);
				Element address = aElem.get(i);
				Element score = sElem.get(i);
				Element link2 = lElem.get(i);

				FoodVO vo = new FoodVO();
				vo.setName(name.text().trim());
				vo.setPoster(poster.attr("src"));
				vo.setAddress(address.text());
				vo.setScore(Double.parseDouble(score.text().trim()));
				vo.setLink(link2.attr("href"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public FoodVO foodDetailData(String link){
		FoodVO vo= new FoodVO();
		
		try{
			Document doc = Jsoup.connect("http://www.mangoplate.com"+link).get();
			Element name=doc.select("span.title h1.restaurant_name").first();
			Element score=doc.select("span.title span.rate-point").first();
			Element poster=doc.select("div.list-photo_wrap figure.restaurant-photos-item img").first();
			Element address=doc.select("tbody td a.addr-txt").first();
			Element tel=doc.select("tbody td a.tel_area").first();
			Element type=doc.select("tbody tr:eq(2) td").first();
			Element price=doc.select("tbody tr:eq(3) td").first();
			Elements temp = doc.select("div.title_fliter_wrap li.review_fliter_item button");
			vo.setName(name.text());
			vo.setScore(Double.parseDouble(score.text().trim()));
			vo.setPoster(poster.attr("src"));
			vo.setAddress(address.text());
			vo.setTel(tel.text());
			vo.setType(type.text());
			vo.setPrice(price.text());
			for(int i=0;i<temp.size();i++){
				Element elem=temp.get(i);
				if(i==1) vo.setGood(elem.text());
				else if(i==2) vo.setSoso(elem.text());
				else if(i==3) vo.setBad(elem.text());
			}
						
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return vo;
	}
	
}
