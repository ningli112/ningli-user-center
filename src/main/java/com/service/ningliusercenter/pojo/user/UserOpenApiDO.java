package com.service.ningliusercenter.pojo.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.service.ningliusercenter.pojo.base.AbstractPojoProperty;

/**
 * 
 * @ClassName: UserOpenApiDO
 * @Description:开放性API用户实体类
 * @author: 宁黎
 * @date: 2019年5月16日 下午6:38:20
 */
@Entity
@Table(name = "user_opern_api")
public class UserOpenApiDO extends AbstractPojoProperty {

	/**
	 * appId
	 */
	@Column(name = "app_id", nullable = false, unique = true, length = 32)
	private String appId;
	/**
	 * appId 对应的秘钥
	 */
	@Column(name = "secret_key", nullable = false, length = 50)
	private String secretKey;
	/**
	 * 公司名称
	 */
	@Column(name = "company_name", length = 50)
	private String companyName;
	/**
	 * 系统平台
	 */
	@Column(name = "system_platform", length = 30, nullable = false)
	private String systemPlatform;
	/**
	 * 系统平台ID
	 */
	@Column(name = "system_plateform_id", length = 15, nullable = false)
	private Integer systemPlateformId;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getSystemPlatform() {
		return systemPlatform;
	}

	public void setSystemPlatform(String systemPlatform) {
		this.systemPlatform = systemPlatform;
	}

	public Integer getSystemPlateformId() {
		return systemPlateformId;
	}

	public void setSystemPlateformId(Integer systemPlateformId) {
		this.systemPlateformId = systemPlateformId;
	}

}