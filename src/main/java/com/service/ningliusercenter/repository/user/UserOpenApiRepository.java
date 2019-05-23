package com.service.ningliusercenter.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.ningliusercenter.pojo.user.UserOpenApiDO;

public interface UserOpenApiRepository extends JpaRepository<UserOpenApiDO, Integer> {
	/**
	 * 
	 * @Title: findByAppId
	 * @Description: 根据appId获取UserOpenApiDO对象
	 * @param appId
	 * @return
	 * 		UserOpenApiDO
	 * @author: 宁黎
	 * @date:2019年5月16日下午7:07:01
	 *
	 */
	UserOpenApiDO findByAppId(String appId);
}
