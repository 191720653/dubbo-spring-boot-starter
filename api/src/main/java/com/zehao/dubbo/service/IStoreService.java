package com.zehao.dubbo.service;

/**
 * 库存服务
 * @author zehao
 * @date 2019年2月12日
 */
public interface IStoreService {
	
	/**
	 * 库存扣减
	 * @param num
	 * @return
	 */
	public String subStore(int num);

}
