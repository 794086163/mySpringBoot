package com.didispace.domin.p;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


/**
 * 多数据源配置的dao
 * @author v-yangxu
 *
 */
@Repository
@CacheConfig(cacheNames="users")//在数据访问接口中，增加缓存配置注解
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Cacheable(key = "#p0")
	User findByName(String name);
	
	@Cacheable
	List<User> findAll();
	
	@Query(value="select * from user where name=?1",nativeQuery=true)
	User findUserByName(String name);
	
	@CachePut(key = "#p0.name")
	User save(User user);
}
