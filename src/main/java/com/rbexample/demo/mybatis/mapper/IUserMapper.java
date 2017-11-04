package com.rbexample.demo.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.rbexample.demo.bean.User;

@Mapper
public interface IUserMapper {

	@Select("SELECT * from User WHERE country = #{country}")
	User getUserByCountry(String country);
	@Select("SELECT * from User WHERE title = #{title}")
	User getUserByTitle(String title);
	@Select("SELECT * from User WHERE age = #{age}")
	User getUserByAge(int age);
}
