package com.service.ningliusercenter.service.impl.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.ningliusercenter.pojo.user.UserOpenApiDO;
import com.service.ningliusercenter.repository.user.UserOpenApiRepository;
import com.service.ningliusercenter.service.user.UserOpenApiService;

/**
 * 
 * @ClassName: UserOpenApiServiceImpl
 * @Description:开放API用户业务实现类
 * @author: 宁黎
 * @date: 2019年5月16日 下午7:11:57
 */
@Service
public class UserOpenApiServiceImpl implements UserOpenApiService {
	@Autowired
	private UserOpenApiRepository useroPenApiRepository;

	/**
	 * 
	 * <p>
	 * Title: getUserOpenApiDO
	 * </p>
	 * <p>
	 * Description: 根据APPID获取UserOpenApiDO对象
	 * </p>
	 * 
	 * @author 宁黎
	 * @param appId
	 * @return
	 * @see com.service.ningliusercenter.service.user.UserOpenApiService#getUserOpenApiDO(java.lang.String)
	 */
	@Override
	public UserOpenApiDO getUserOpenApiDO(String appId) {
		return useroPenApiRepository.findByAppId(appId);
	}

	/**
	 * 
	 * <p>
	 * Title: addUserOpenApiDO
	 * </p>
	 * <p>
	 * Description:增加开放性API用户
	 * </p>
	 * 
	 * @author 宁黎
	 * @param userOpenApiDO
	 * @see com.service.ningliusercenter.service.user.UserOpenApiService#addUserOpenApiDO(com.service.ningliusercenter.pojo.user.UserOpenApiDO)
	 */
	@Override
	public void addUserOpenApiDO(UserOpenApiDO userOpenApiDO) {
		useroPenApiRepository.save(userOpenApiDO);
	}

}
