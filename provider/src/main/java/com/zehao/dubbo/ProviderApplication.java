package com.zehao.dubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDubboConfiguration
public class ProviderApplication {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		SpringApplication.run(ProviderApplication.class, args);
	}
}
