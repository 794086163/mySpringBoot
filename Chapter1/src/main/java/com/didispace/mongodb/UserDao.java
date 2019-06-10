package com.didispace.mongodb;

import java.util.List;

public interface UserDao {
	void save(User user);
	List<User> findAll();
	void delete(Long id);
	void update(User user);
}
