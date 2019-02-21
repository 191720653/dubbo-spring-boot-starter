
package com.zehao.dubbo.service.impl;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.zehao.dubbo.service.IHelloService;

@Service(interfaceClass = IHelloService.class)
@Component
public class HelloServiceImpl implements IHelloService {

	public String helloWord() {
		// TODO Auto-generated method stub
		return "Hello World!";
	}

	public String sayHello(String name) {
		// TODO Auto-generated method stub
		return "This is hello word from " + name;
	}

}
