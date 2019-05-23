package com.service.ningliusercenter.controller.user;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.ningliusercenter.dto.BaseJsonReturnDTO;
import com.service.ningliusercenter.enums.code.BaseJsonReturnCodeEnum;
import com.service.ningliusercenter.enums.user.UserOpenApiCodeEnum;
import com.service.ningliusercenter.exception.base.SignException;
import com.service.ningliusercenter.pojo.system.SystemPlatformDO;
import com.service.ningliusercenter.pojo.user.UserOpenApiDO;
import com.service.ningliusercenter.service.system.SystemPlatformService;
import com.service.ningliusercenter.service.user.UserOpenApiService;
import com.service.ningliusercenter.util.MD5Util;

/**
 * 
 * @ClassName: UserOpenApiController
 * @Description:开放性API 用户Controller类
 * @author: 宁黎
 * @date: 2019年5月21日 下午4:29:31
 */
@RestController
@RequestMapping("/api/user/open")
public class UserOpenApiController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserOpenApiController.class);
	@Autowired
	private UserOpenApiService userOpenApiService;
	@Autowired
	private SystemPlatformService systemPlatformService;

	/**
	 * 
	 * @Title: getUserOpenApi
	 * @Description: 校验APPID和APPKEY 是否正确
	 * @param userOpenApiDTO
	 * @return
	 * 		BaseJsonReturnDTO<UserOpenApiDO>
	 * @author: 宁黎
	 * @date:2019年5月21日下午4:29:24
	 *
	 */
	@PostMapping("/v1/check/appid")
	public BaseJsonReturnDTO<String> getUserOpenApi(@RequestBody UserOpenApiDO userOpenApiDTO) {
		String appId = userOpenApiDTO.getAppId();
		String secretKey = userOpenApiDTO.getSecretKey();
		// 校验入参是否为空
		if (StringUtils.isEmpty(appId)) {
			return new BaseJsonReturnDTO<String>(UserOpenApiCodeEnum.APPID_NOT_EMPTY.getCode(),
					UserOpenApiCodeEnum.APPID_NOT_EMPTY.getMsg());
		}
		if (StringUtils.isEmpty(secretKey)) {
			return new BaseJsonReturnDTO<String>(UserOpenApiCodeEnum.SECRET_KEY_NOT_EMPTY.getCode(),
					UserOpenApiCodeEnum.SECRET_KEY_NOT_EMPTY.getMsg());
		}
		// 校验查询的对象是否为空
		UserOpenApiDO userOpenApiDO = userOpenApiService.getUserOpenApiDO(appId);
		if (userOpenApiDO == null) {
			return new BaseJsonReturnDTO<String>(UserOpenApiCodeEnum.APPID_NO_EXIST.getCode(),
					UserOpenApiCodeEnum.APPID_NO_EXIST.getMsg());
		}
		// 检查APPKEY 是否正确
		if (!userOpenApiDO.getSecretKey().equals(secretKey)) {
			return new BaseJsonReturnDTO<String>(UserOpenApiCodeEnum.SECRET_KEY_ERROR.getCode(),
					UserOpenApiCodeEnum.SECRET_KEY_ERROR.getMsg());
		}
		return new BaseJsonReturnDTO<String>(BaseJsonReturnCodeEnum.SUCCESS.getCode(),
				BaseJsonReturnCodeEnum.SUCCESS.getMsg());
	}

	/**
	 * 
	 * @Title: addUserOpen
	 * @Description: 增加开放API用户
	 * @param userOpenApiDTO
	 * @return
	 * 		BaseJsonReturnDTO<String>
	 * @author: 宁黎
	 * @date:2019年5月22日上午9:57:21
	 *
	 */
	@PostMapping("/v1/add")
	public BaseJsonReturnDTO<String> addUserOpen(@RequestBody UserOpenApiDO userOpenApiDTO) {
		// 参数对象不能为空
		if (userOpenApiDTO == null) {
			return new BaseJsonReturnDTO<String>(BaseJsonReturnCodeEnum.PARAM_IS_NOT_NULL.getCode(),
					BaseJsonReturnCodeEnum.PARAM_IS_NOT_NULL.getMsg());
		}
		// 平台类型不能为空
		if (userOpenApiDTO.getSystemPlateformId() == null) {
			return new BaseJsonReturnDTO<String>(UserOpenApiCodeEnum.SYSTEM_PLATFORM_ID_NOT_NULL.getCode(),
					UserOpenApiCodeEnum.SYSTEM_PLATFORM_ID_NOT_NULL.getMsg());
		}
		Integer systemPlatformId = userOpenApiDTO.getSystemPlateformId();
		SystemPlatformDO systemPlatformDO = systemPlatformService.getById(systemPlatformId);
		// APPID查询出来的对象不能为空，为空则说明平台ID传入错误，在平台数据库中不存在
		if (systemPlatformDO == null) {
			return new BaseJsonReturnDTO<String>(UserOpenApiCodeEnum.SYSTEM_PLATFORM_NOT_EXIST.getCode(),
					UserOpenApiCodeEnum.SYSTEM_PLATFORM_NOT_EXIST.getMsg());
		}
		// 自动生成APPID 和APPKEY
		userOpenApiDTO.setAppId(MD5Util.getAppIdByUUId());
		userOpenApiDTO.setSecretKey(MD5Util.generateInviteCode());
		userOpenApiDTO.setCreateTime(new Date());
		userOpenApiDTO.setSystemPlatform(systemPlatformDO.getName());
		userOpenApiService.addUserOpenApiDO(userOpenApiDTO);
		return new BaseJsonReturnDTO<String>(BaseJsonReturnCodeEnum.SUCCESS.getCode(),
				BaseJsonReturnCodeEnum.SUCCESS.getMsg());
	}

}
