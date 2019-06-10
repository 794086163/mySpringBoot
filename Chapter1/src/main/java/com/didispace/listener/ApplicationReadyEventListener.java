package com.didispace.listener;

import lombok.extern.log4j.Log4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

import lombok.extern.slf4j.Slf4j;

@Log4j
public class ApplicationReadyEventListener implements ApplicationListener<ApplicationReadyEvent>{

	@Override
	public void onApplicationEvent(ApplicationReadyEvent arg0) {
		log.info("==============ApplicationReadyEventListener================");
	}
	
	


}
