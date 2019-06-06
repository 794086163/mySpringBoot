package com.didispace.listener;

import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;

import lombok.extern.slf4j.Slf4j;

/**
 * 监听失败
 * @author v-yangxu
 *
 */
@Slf4j
public class ApplicationFailedEventListener implements ApplicationListener<ApplicationFailedEvent>{

	@Override
	public void onApplicationEvent(ApplicationFailedEvent arg0) {
		log.info("=================ApplicationFailedEvent=================");
	}

}
