package com.zehao.dubbo.service;

/**
 * hello service
 * @author zehao
 * @date 2019年2月12日
 */
public interface IHelloService {
	
	/**
	 * hello world
	 * @return
	 */
	public String helloWord();
	
	/**
	 * say hello test
	 * @param name
	 * @return
	 */
	public String sayHello(String name);

}
