//package com.didispace.es;
//
//import org.elasticsearch.client.transport.TransportClient;
//import org.elasticsearch.common.settings.Settings;
//import org.elasticsearch.common.transport.InetSocketTransportAddress;
//import org.elasticsearch.transport.client.PreBuiltTransportClient;
//import org.junit.After;
//import org.junit.Before;
//
//import java.net.InetAddress;
//import java.net.UnknownHostException;
//
///**
// * Created by v-yangxu on 2019/7/12.
// */
//public class  ElasticSearchClient {
//    protected TransportClient client;
//
//    @Before
//    public void setUp(){
//        Settings settings = Settings.builder().put("cluster.name", "elasticsearch") //设置ES实例的名称
//                .put("client.transport.sniff", true) //自动嗅探整个集群的状态，把集群中其他ES节点的ip添加到本地的客户端列表中
//                .build();
//        try {
//            client = new PreBuiltTransportClient(settings)
//                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300) {
//                    });
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("ElasticsearchClient 连接成功");
//    }
//
//
//    @After
//    public void tearDown() throws Exception {
//        if (client != null) {
//            client.close();
//        }
//
//    }
//
//
//    public static void main(String[] args){
//        new ElasticSearchClient().setUp();
//    }
//}
