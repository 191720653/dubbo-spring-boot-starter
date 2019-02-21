package com.zehao.dubbo.service.impl;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.zehao.dubbo.service.IStoreService;

@Service(interfaceClass = IStoreService.class) // 需要暴露的接口
//loadbalance = "leastactive" // 负载均衡策略
//timeout = 1000 // 超时时间
//actives = 1 // 每服务每方法的最大并发数，达到最大后阻塞等待请求完成或者超时
@Component
public class StoreServiceImpl implements IStoreService {
	
	/**
	 * 模拟总库存
	 */
	public static volatile int totalStore = 2;

	public String subStore(int num) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (num > 0) {
			if (totalStore >= num) {
				totalStore = totalStore - num;
				return "扣减" + num + "个库存成功，剩余：" + totalStore;
			} else {
				return "库存不足，剩余：" + totalStore;
			}
		} else {
			// return "非法操作";
			throw new RuntimeException("非法操作");
		}
	}

}
