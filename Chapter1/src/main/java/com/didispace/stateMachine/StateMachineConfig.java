package com.didispace.stateMachine;

import lombok.extern.log4j.Log4j;
import org.apache.log4j.spi.LoggerFactory;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigBuilder;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.transition.Transition;

import java.util.EnumSet;

/**
 * Created by v-yangxu on 2019/4/29.
 * configure(StateMachineStateConfigurer<States, Events> states)方法用来初始化当前状态机拥有哪些状态，
 * 其中initial(States.UNPAID)定义了初始状态为UNPAID，states(EnumSet.allOf(States.class))则指定了使用
 * 上一步中定义的所有状态作为该状态机的状态定义。
 */
@Configuration
@EnableStateMachine//注解用来启用Spring StateMachine状态机功能
@Log4j
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<States, Events> {


    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states) throws Exception {
        // 定义状态机中的状态
        states.withStates().
                initial(States.UPDAID).// 初始状态
                states(EnumSet.allOf(States.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions) throws Exception {
        transitions.withExternal().
                source(States.UPDAID).target(States.WAITING_FOR_RECEIVE)//指定状态来源和目标
                .event(Events.PAY)//指定触发事件
                .and()
                .withExternal()
                .source(States.WAITING_FOR_RECEIVE).target(States.DONE)
                .event(Events.RECEIVE);
    }

//    @Override
//    public void configure(StateMachineConfigurationConfigurer<States, Events> config) throws Exception {
//        config.withConfiguration().listener(listener());//指定状态机的处理监听器
//    }

//    @Bean
//    public StateMachineListener<States, Events> listener() {
//        return new StateMachineListenerAdapter<States, Events>() {
//            @Override
//            public void transition(Transition<States, Events> transition) {
//                if (transition.getTarget().getId() == States.UPDAID) {
//                    log.info("订单创建，待支付");
//                    return;
//                }
//                if (transition.getSource().getId() == States.UPDAID && transition.getTarget().getId() == States.WAITING_FOR_RECEIVE) {
//                    log.info("用户完成支付，待收货");
//                    return;
//                }
//                if (transition.getSource().getId() == States.WAITING_FOR_RECEIVE && transition.getTarget().getId() == States.DONE) {
//                    log.info("用户已收货，订单完成");
//                    return;
//                }
//            }
//        };
//    }
}
