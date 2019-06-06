package com.didispace.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.annotation.Version;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.didispace.entity.User;
import com.didispace.service.UserService;

@Service
public class UserServiceImpl implements UserService {

//	@Autowired
//	private JdbcTemplate dao;
	
	@Autowired
	@Qualifier("primaryJdbcTemplate")
	private JdbcTemplate t1;
	
	@Autowired
	@Qualifier("secondaryJdbcTemplate")
	private JdbcTemplate t2;
	
//	@Override
//	public void createUser(User user) {
//		dao.update("insert into user(user_name,email) values(?,?)",user.getUser_name(),user.getEmail());
//	}

//	@Override
//	public void deleteByName(String name) {
//		dao.update("delete from user where name=?",name);
//	}

//	@Override
//	public void updateUser(Integer id, User user) {
//		dao.update("update user set user_name=?,email=? where id=?",user.getNick_name(),user.getEmail(),id);
//	}

//	@Override
//	public List<Map<String, Object>> listAll() {
//		return dao.queryForList("select * from user");
//	}

	@Override
	public List<Map<String, Object>> listAllT1() {
		return t1.queryForList("select * from user");
	}

	@Override
	public List<Map<String, Object>> listAllT2() {
		return t2.queryForList("select * from user");
	}

}
