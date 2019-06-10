package com.didispace.web;

import org.apache.log4j.TTCCLayout;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by v-yangxu on 2019/6/5.
 */
@RestController
public class RestZkController {

    @GetMapping("/zkGet")
    public String zkGet(String nodeName) {
        Watcher watcher = new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println("监听：" + event);
            }
        };
        String value = null;
        try {
            final ZooKeeper zookeeper=new ZooKeeper("localhost:2181",999999,watcher);
            final byte[] data=zookeeper.getData("/"+nodeName,watcher,null);
            value=new String(data);
            zookeeper.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "get value from zookeeper ["+value+"]";
    }

    @GetMapping("/zkDel")
    public String zkDel(String nodeName) {
        Watcher watcher = new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println("监听：" + event);
            }
        };
        String value = null;
        try {
            final ZooKeeper zookeeper=new ZooKeeper("localhost:2181",999999,watcher);
            zookeeper.delete("/"+nodeName,0);
            zookeeper.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "delete value from zookeeper ["+nodeName+"]";
    }

}
