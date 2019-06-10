package com.didispace;

import com.didispace.entity.Article;
import com.didispace.entity.Test;
import com.didispace.stateMachine.Events;
import com.didispace.stateMachine.States;
import com.spring4all.mongodb.EnableMongoPlus;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateMachine;

import java.util.List;
//import lombok.extern.slf4j.Slf4j;

@EnableMongoPlus
@SpringBootApplication
@EntityScan("com.didispace.entity")
@ComponentScan(value = {"com.didispace.*", "com.didispace.jpa"})
@EnableAutoConfiguration()
@EnableCaching//开启ecaching缓存
@Configuration
@Log4j
public class Chapter1Application implements CommandLineRunner {

    public static void main(String[] args) {
        log.info("这是日志，你看到l ?");
        ApplicationContext application = SpringApplication.run(Chapter1Application.class, args);
        //获取应用绑定的参数
        Binder binder = Binder.get(application.getEnvironment());
        //绑定properties中设定的参数
        Test test = binder.bind("com.didispace", Bindable.of(Test.class)).get();
        System.out.println(test);
        //绑定properties中设定的集合
        List<String> list = binder.bind("com.didispace.string-list", Bindable.listOf(String.class)).get();
        System.out.println(list);

        List<Article> list2 = binder.bind("com.didispace.articles", Bindable.listOf(Article.class)).get();
        System.out.println(list2);
    }

    @Bean
    public DataLoader dataLoader() {
        return new DataLoader();
    }

    @Autowired
    private StateMachine<States, Events> stateMachine;

    @Override
    public void run(String... args) throws Exception {
        stateMachine.start();
        stateMachine.sendEvent(Events.PAY);
        stateMachine.sendEvent(Events.RECEIVE);
    }

    public static class DataLoader implements CommandLineRunner {

        @Override
        public void run(String... strings) throws Exception {
            log.info(strings);
        }
    }
}
