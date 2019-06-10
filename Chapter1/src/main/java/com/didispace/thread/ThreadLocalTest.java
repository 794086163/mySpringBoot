package com.didispace.thread;

import lombok.Data;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by v-yangxu on 2019/5/15.
 */
@Data
public class ThreadLocalTest {
    private String string;

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalTest.test();
    }

    public static void test() throws InterruptedException {
        final int totalThread = 10;
        CountDownLatch countDownLatch = new CountDownLatch(totalThread);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < totalThread; i++) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executorService.execute(() -> {
                System.out.println("run.."+countDownLatch.getCount());
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        System.out.println("end");
        executorService.shutdown();
    }
}
