package com.didispace.mongodb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UserDaoImpl implements UserDao {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public void save(User user) {
		log.info("添加:{}",user);
		mongoTemplate.save(user);
	}

	@Override
	public List<User> findAll() {
		log.info("查询所有");
		return mongoTemplate.findAll(User.class);
	}

	@Override
	public void delete(Long id) {
		MongoOperations mongoOps=mongoTemplate;
		mongoOps.remove(mongoOps.findById(id, User.class));
	}

	@Override
	public void update(User user) {
		Query query=Query.query(Criteria.where("id").is(2L));
		Update update = Update.update("age", user.getAge());
		MongoOperations mongoOps=mongoTemplate;		
		mongoOps.updateFirst(query,update,User.class);
	}


}
