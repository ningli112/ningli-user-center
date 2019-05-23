package com.service.ningliusercenter.service.system;

import com.service.ningliusercenter.pojo.system.SystemPlatformDO;

public interface SystemPlatformService {
	/**
	 * 
	 * @Title: getById
	 * @Description: 根据ID获取SystemPlatformDO对象
	 * @param id
	 * @return
	 * 		SystemPlatformDO
	 * @author: 宁黎
	 * @date:2019年5月22日上午9:48:55
	 *
	 */
	SystemPlatformDO getById(Integer id);
}
