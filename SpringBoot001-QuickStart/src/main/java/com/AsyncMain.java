package com;

import java.util.concurrent.Future;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import com.async.AsyncTask;

/**
 * @EnableAsync 开启异步
 */
@Configuration
@EnableAutoConfiguration
@EnableAsync
@ComponentScan("com.async")
public class AsyncMain {

    public static void main(String[] args) throws Exception {
	ConfigurableApplicationContext context = SpringApplication.run(AsyncMain.class, args);
	com.async.AsyncTask asyncTask = context.getBean(AsyncTask.class);
	// 正常异步
//	asyncTask.doTaskOne();
//	asyncTask.doTaskTwo();
//	asyncTask.doTaskThree();
	// 回调
	Future<String> future = asyncTask.doTaskOneFuture();
	System.out.println("=Result=>" + future.get());
    }

}
