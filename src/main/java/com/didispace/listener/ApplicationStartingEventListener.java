package com.didispace.listener;

import lombok.extern.log4j.Log4j;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

@Log4j
public class ApplicationStartingEventListener implements ApplicationListener<ApplicationStartingEvent>{

	@Override
	public void onApplicationEvent(ApplicationStartingEvent paramE) {
//		log.info("==================ApplicationStartingEventListener==================");
	}

}
