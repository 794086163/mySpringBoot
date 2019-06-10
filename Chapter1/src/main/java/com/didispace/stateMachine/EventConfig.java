package com.didispace.stateMachine;

import lombok.extern.log4j.Log4j;
import org.springframework.statemachine.annotation.OnStateChanged;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

/**
 * Created by v-yangxu on 2019/4/29.
 */
@WithStateMachine
@Log4j
public class EventConfig {
    @OnTransition(target = "UPDAID")
    public void create() {
        log.info("创建订单，待支付");
    }

    @OnTransition(source = "UPDAID", target = "WAITING_FOR_RECEIVE")
    public void pay() {
        log.info("用户完成支付，待收货");
    }

    @OnTransition(source = "WAITING_FOR_RECEIVE", target = "DONE")
    public void receive() {
        log.info("用户已收货，订单完成");
    }
}
