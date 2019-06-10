package com.didispace;

import com.didispace.rabbitMQService.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by v-yangxu on 2019/4/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RabbitServiceTest {
    @Autowired
    private Sender sender;

    @Test
    public void hello(){
        sender.send();
    }
}
