package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CxfMain {
	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = SpringApplication.run(CxfMain.class, args);
		// JaxWsDynamicClientFactory dcf =JaxWsDynamicClientFactory.newInstance();
		// org.apache.cxf.endpoint.Client client
		// =dcf.createClient("http://localhost:8080/test/user?wsdl");
		// //getUser 为接口中定义的方法名称 张三为传递的参数 返回一个Object数组
		// Object[] objects=client.invoke("getUser","411001");
		// //输出调用结果
		// System.out.println("*****"+objects[0].toString());
	}
}
