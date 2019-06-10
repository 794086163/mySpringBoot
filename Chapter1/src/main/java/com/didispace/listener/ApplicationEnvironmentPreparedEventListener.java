package com.didispace.listener;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;

import lombok.extern.slf4j.Slf4j;

/**
 *  监听顺序：
 * 	ApplicationStartingEvent 应用开始事件
	ApplicationEnvironmentPreparedEvent 应用环境准备事件
	ApplicationPreparedEvent 应用准备事件
	ApplicationStartedEvent 应用开始完毕事件
	ApplicationReadyEvent 应用读取事件
	ApplicationFailedEvent 应用失败事件
 * @author v-yangxu
 *
 */
@Slf4j
public class ApplicationEnvironmentPreparedEventListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent>{
	
	//事件监听准备阶段
	@Override
	public void onApplicationEvent(ApplicationEnvironmentPreparedEvent arg0) {
		log.info("===============准备监听事件====================");
	}
}
