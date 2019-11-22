package com.api;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Feign;
import feign.okhttp.OkHttpClient;
import okhttp3.ConnectionPool;
import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Feign默认Http连接优化
 * 
 * @author chenkw
 *
 */
//@AutoConfigureBefore(FeignAutoConfiguration.class)
//@Configuration
//@ConditionalOnClass({ OkHttpClient.class, Feign.class })
//@ConditionalOnMissingBean({ okhttp3.OkHttpClient.class })
//@ConditionalOnProperty({ "feign.okhttp.enabled" })
public class FeignOkHttpConfig {
	private int feignOkHttpReadTimeout = 60;
	private int feignConnectTimeout = 60;
	private int feignWriteTimeout = 120;

	@Bean
	public okhttp3.OkHttpClient okHttpClient() {
		return new okhttp3.OkHttpClient.Builder().readTimeout(feignOkHttpReadTimeout, TimeUnit.SECONDS)
				.connectTimeout(feignConnectTimeout, TimeUnit.SECONDS).writeTimeout(feignWriteTimeout, TimeUnit.SECONDS)
				.connectionPool(new ConnectionPool(100, 20, TimeUnit.SECONDS)) // 自定义链接池
				.addInterceptor(new Interceptor() {

					@Override
					public Response intercept(Chain chain) throws IOException {
						System.out.println("---It's me Mario!!!----");// 自己的过滤器
						return chain.proceed(chain.request());
					}

				}) // 自定义拦截器
				.build();
	}
}
