package com.didispace.generic;

import java.util.concurrent.*;

/**
 * Created by v-yangxu on 2019/5/16.
 */
public class Apple extends Fruit implements Runnable{


    public static void main(String[] args){
        ExecutorService pool=Executors.newCachedThreadPool();
        pool.execute(new Apple());
    }

    @Override
    public void run() {
        while (true){
            try {
                String s="";
                Thread.sleep(2000);
                System.out.println("apple");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
