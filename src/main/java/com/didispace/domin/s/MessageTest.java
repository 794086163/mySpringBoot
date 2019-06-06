package com.didispace.domin.s;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 程序猿DD
 * @version 1.0.0
 * @date 16/3/21 下午3:35.
 * @blog http://blog.didispace.com
 */
@Entity
@Table(name="MessageTest4")
public class MessageTest {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String content;

    public MessageTest(){}

    public MessageTest(String name, String content) {
        this.name = name;
        this.content = content;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
