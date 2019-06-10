package com.didispace;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigService {
	
	@Value("${com.meizu.springboot}")
	private String springBoot;
	
	@Value("${com.meizu.name}")
	private String name;
	
	@Value("${com.meizu.project}")
	private String project;
	
	@Value("${com.meizu.int}")
	private int intValue;
	
	@Value("${com.meizu.int10}")
	private int int10;
	
	@Value("${com.meizu.int10To20}")
	private int int10To20;
	
	@Value("${com.meizu.value}")
	private String value;

	public String getSpringBoot() {
		return springBoot;
	}

	public void setSpringBoot(String springBoot) {
		this.springBoot = springBoot;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public int getIntValue() {
		return intValue;
	}

	public void setIntValue(int intValue) {
		this.intValue = intValue;
	}

	public int getInt10() {
		return int10;
	}

	public void setInt10(int int10) {
		this.int10 = int10;
	}

	public int getInt10To20() {
		return int10To20;
	}

	public void setInt10To20(int int10To20) {
		this.int10To20 = int10To20;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
