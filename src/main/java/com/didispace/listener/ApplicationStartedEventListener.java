package com.didispace.listener;

import lombok.extern.log4j.Log4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

import lombok.extern.slf4j.Slf4j;

@Log4j
public class ApplicationStartedEventListener implements ApplicationListener<ApplicationStartedEvent>{

	@Override
	public void onApplicationEvent(ApplicationStartedEvent paramE) {
		log.info("==================ApplicationStartedEventListener=====================");
	}

}
