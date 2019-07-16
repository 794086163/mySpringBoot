package com.didispace.es.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;


/**
 * Created by v-yangxu on 2019/7/15.
 */
@Document(indexName = "megacorp",type = "employee" ,shards = 1,replicas = 0,refreshInterval = "-1")
public class Employee {
    @Id
    private int id;
    private String name;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
