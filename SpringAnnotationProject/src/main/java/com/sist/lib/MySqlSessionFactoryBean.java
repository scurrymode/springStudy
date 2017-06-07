package com.sist.lib;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component("ssf")
public class MySqlSessionFactoryBean extends SqlSessionFactoryBean {
/*
	<bean id="ssf"
		class="org.mybatis.spring.SqlSessionFactoryBean"
		p:dataSource-ref="ds"
		p:configLocation="classpath:Config.xml"
		/>
*/
	@Resource(name="ds")
	public void setDataSource(DataSource dataSource){
		super.setDataSource(dataSource);
	}
	
	public MySqlSessionFactoryBean(){
		try {
			org.springframework.core.io.Resource res = new ClassPathResource("Config.xml");
			setConfigLocation(res);
		} catch (Exception e) {
			
		}
	}
	
	
}
