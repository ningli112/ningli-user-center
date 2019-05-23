package com.service.ningliusercenter.enums.code;

/**
 * @ClassName: BaseJsonReturnCodeEnum
 * @Description:基本返回结果信息枚举类
 * @author: 宁黎
 * @date: 2019年5月13日 下午4:51:53
 */
public enum BaseJsonReturnCodeEnum {
	SUCCESS(0, "SUCCESS"), PARAM_IS_NOT_NULL(1001, "参数传入为空"), CIPHERTEXT_DAMAGE(1004, "密文不正确或密文损坏");
	/**
	 * 状态值
	 */
	private int code;
	/**
	 * 状态消息
	 */
	private String msg;

	private BaseJsonReturnCodeEnum(int code, String msg) {
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
