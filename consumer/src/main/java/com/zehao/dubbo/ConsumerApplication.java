package com.zehao.dubbo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import com.netflix.hystrix.contrib.javanica.aop.aspectj.HystrixCommandAspect;
import com.zehao.dubbo.component.ServiceComponent;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDubboConfiguration
public class ConsumerApplication {
	
	public static void main(String[] args) {
		System.out.println("Hello World!");
		SpringApplication.run(ConsumerApplication.class, args);
	}

	@Configuration
	@EnableAspectJAutoProxy
	static public class ProviderConfiguration {

		@Bean
		public HystrixCommandAspect hystrixCommandAspect() {
			return new HystrixCommandAspect();
		}

	}
	
	@Autowired
	private ServiceComponent serviceComponent;
	
	@PostConstruct
	public void init() {
		System.out.println(serviceComponent.helloWorld());
		
		System.out.println(serviceComponent.sayHello("zehao"));
		
		for (int i = 3; i >= 0; i--) { // 模拟调用扣减库存服务
			System.out.println(serviceComponent.subStore(i));
		}
	}
}
