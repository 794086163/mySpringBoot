package com.didispace.entity;

import java.util.Map;

//@ConfigurationProperties
public class Test {
	private String foo;
	private String database_platform;
	
	private Map<String,Article> ArticleMap;

	public String getFoo() {
		return foo;
	}

	public void setFoo(String foo) {
		this.foo = foo;
	}

	public String getDatabase_platform() {
		return database_platform;
	}

	public void setDatabase_platform(String database_platform) {
		this.database_platform = database_platform;
	}

	public Map<String, Article> getArticleMap() {
		return ArticleMap;
	}

	public void setArticleMap(Map<String, Article> articleMap) {
		ArticleMap = articleMap;
	}
	
}
