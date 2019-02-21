package com.zehao.dubbo.component;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zehao.dubbo.service.IHelloService;
import com.zehao.dubbo.service.IStoreService;

@Component
public class ServiceComponent {

	@Reference
	private IHelloService iHelloService;
	
	@Reference
	private IStoreService iStoreService;
	
	public String helloWorld() {
		return iHelloService.helloWord();
	}
	
	@HystrixCommand(fallbackMethod = "sayHelloFallback")
	public String sayHello(String name) {
		return iHelloService.sayHello(name);
	}
	
	public String sayHelloFallback(String name) {
		return "请稍后再试";
	}

	@HystrixCommand(fallbackMethod = "subStoreFallback", commandProperties = { 
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "1"), // 熔断触发的最小个数默认20个/10s
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")}, // 超时时间
			threadPoolProperties = {@HystrixProperty(name = "coreSize", value = "50")}) // 线程池数，默认10
	public String subStore(int num) {
		return iStoreService.subStore(num);
	}
	
	public String subStoreFallback(int num) {
		return "购买火爆，请稍后再试";
	}
}
