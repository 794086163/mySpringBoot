package com.didispace.listener;

import lombok.extern.log4j.Log4j;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;

import lombok.extern.slf4j.Slf4j;

@Log4j
public class ApplicationPreparedEventListener implements ApplicationListener<ApplicationPreparedEvent>{

	@Override
	public void onApplicationEvent(ApplicationPreparedEvent arg0) {
		log.info("=================ApplicationPreparedEvent================");
	}

}
