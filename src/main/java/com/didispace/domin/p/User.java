package com.didispace.domin.p;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * 多数据源配置的实体
 * @author v-yangxu
 *
 */
@Entity
@Data
public class User implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 871143199086256289L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length=5)
    private String name;

    @Column(nullable = false)
    private Integer age;

    public User(){}

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
