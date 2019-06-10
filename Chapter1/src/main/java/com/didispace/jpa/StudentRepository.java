package com.didispace.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.didispace.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{
	Student findByName(String name);
	
	Student findByNameAndAge(String name,int age);
	
//	void deleteByName(String name);
	
	@Query("select name from Student where name=:name")
	Student findByStudentName(@Param("name")String name);
}
