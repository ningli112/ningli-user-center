package com.service.ningliusercenter.enums.user;

/**
 * 
 * @ClassName: UserOpenApiCodeEnum
 * @Description:开放性用户API错误码枚举类
 * @author: 宁黎
 * @date: 2019年5月16日 下午7:53:52
 */
public enum UserOpenApiCodeEnum {
	/**
	 * appId不能为空
	 */
	APPID_NOT_EMPTY(2001, "appId不能为空"),
	/**
	 * appId对应的KEY不能为空
	 */
	SECRET_KEY_NOT_EMPTY(2002, "appId对应的KEY不能为空"),
	/**
	 * appId对应的Key错误
	 */
	SECRET_KEY_ERROR(2003, "appId对应的Key错误"),
	/**
	 * APPID不存在
	 */
	APPID_NO_EXIST(2004, "APPID不存在"),
	/**
	 * 平台类型ID不能为空
	 */
	SYSTEM_PLATFORM_ID_NOT_NULL(2005, "平台类型ID不能为空"),
	/**
	 * 平台类型ID不存在
	 */
	SYSTEM_PLATFORM_NOT_EXIST(2006, "平台类型ID不存在");
	/**
	 * 状态值
	 */
	private int code;
	/**
	 * 状态消息
	 */
	private String msg;

	private UserOpenApiCodeEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
