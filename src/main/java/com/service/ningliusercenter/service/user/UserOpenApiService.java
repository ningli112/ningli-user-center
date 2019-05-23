package com.service.ningliusercenter.service.user;

import com.service.ningliusercenter.pojo.user.UserOpenApiDO;

/**
 * 
 * @ClassName: UserOpenApiService
 * @Description:开发API用户业务接口
 * @author: 宁黎
 * @date: 2019年5月16日 下午7:12:23
 */
public interface UserOpenApiService {
	/**
	 * 
	 * @Title: getUserOpenApiDO
	 * @Description: 根据appId获取UserOpenApiDO对象
	 * @param appId
	 * @return
	 * 		UserOpenApiDO
	 * @author: 宁黎
	 * @date:2019年5月16日下午7:16:05
	 *
	 */
	UserOpenApiDO getUserOpenApiDO(String appId);

	/**
	 * 
	 * @Title: addUserOpenApiDO
	 * @Description: 增加开放性API用户
	 * @param userOpenApiDO
	 *                      void
	 * @author: 宁黎
	 * @date:2019年5月22日上午9:03:55
	 *
	 */
	void addUserOpenApiDO(UserOpenApiDO userOpenApiDO);
}
