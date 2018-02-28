package com.async;

import java.util.Random;
import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

/**
 * @Async 表名是异步方法.如果注释声明在类上,则类的所有public方法是异步的
 *
 */
@Component
public class AsyncTask {

    public static Random random = new Random();

    @Async
    public void doTaskOne() throws Exception {
	System.out.println("开始做任务一");
	long start = System.currentTimeMillis();
	Thread.sleep(random.nextInt(10000));
	long end = System.currentTimeMillis();
	System.out.println("完成任务一，耗时：" + (end - start) + "毫秒");
    }
    
    /**
     * Future,完成回调
     * @return
     * @throws Exception
     */
    @Async
    public Future<String> doTaskOneFuture() throws Exception {
        System.out.println("开始做任务一");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务一，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务一完成");
    }

    @Async
    public void doTaskTwo() throws Exception {
	System.out.println("开始做任务二");
	long start = System.currentTimeMillis();
	Thread.sleep(random.nextInt(10000));
	long end = System.currentTimeMillis();
	System.out.println("完成任务二，耗时：" + (end - start) + "毫秒");
    }

    @Async
    public void doTaskThree() throws Exception {
	System.out.println("开始做任务三");
	long start = System.currentTimeMillis();
	Thread.sleep(random.nextInt(10000));
	long end = System.currentTimeMillis();
	System.out.println("完成任务三，耗时：" + (end - start) + "毫秒");
    }

}