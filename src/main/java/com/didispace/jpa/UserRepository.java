package com.didispace.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.didispace.domin.p.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	
	User findByName(String name);
	
	List<User> findAll();
	
	@Query(value="select * from user where name=?1")
	User findUserByName(String name);
}
