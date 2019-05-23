package com.service.ningliusercenter.pojo.system;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.service.ningliusercenter.pojo.base.AbstractPojoProperty;

/**
 * @ClassName: SystemPlatformDO
 * @Description:平台名称类
 * @author: 宁黎
 * @date: 2019年5月22日 上午9:25:27
 */
@Entity
@Table(name = "system_platform")
public class SystemPlatformDO extends AbstractPojoProperty {
	/**
	 * 平台名称
	 */
	@Column(name = "system_name", nullable = false, length = 30)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
