package com.didispace.config;

public enum Test {
    REQUIRED(0),
    SUPPORTS(1),
    MANDATORY(2),
    REQUIRES_NEW(3),
    NOT_SUPPORTED(4),
    NEVER(5),
    NESTED(6);
	
	private final int value;
	
	private Test(int value){
		this.value=value;
	}
	
	public int value(){
		return value;
	}
	public static void main(String[] args) {
		System.out.println(Test.MANDATORY.value);
	}
}

