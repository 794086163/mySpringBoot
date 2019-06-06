package com.didispace.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.didispace.domin.p.User;

@Mapper
public interface UserMapper {
	@Insert("insert into user(name,age) values(#{name},#{age}) ")
	void insert(@Param("name") String name, @Param("age") int age);

	@Select("select * from user where name=#{name}")
	User findByName(@Param("name") String name);

	@Results({ @Result(property = "name", column = "name"), @Result(property = "age", column = "age") })
	@Select("SELECT name, age FROM user")
	List<User> findAll();

	@Update("UPDATE user SET age=#{age} WHERE name=#{name}")
	void update(User user);
}
