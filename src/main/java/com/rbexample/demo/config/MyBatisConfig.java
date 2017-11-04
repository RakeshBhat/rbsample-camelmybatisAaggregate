package com.rbexample.demo.config;

import org.apache.camel.component.mybatis.MyBatisComponent;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.rbexample.demo.mybatis.mapper")
public class MyBatisConfig {

	@Bean(name = "mybatis")
	public MyBatisComponent myBatisComponent(SqlSessionFactory sqlSessionFactory){
		MyBatisComponent myBatisComponent = new MyBatisComponent();
		myBatisComponent.setSqlSessionFactory(sqlSessionFactory);
		
		return myBatisComponent;
	}
}
