package com.service.ningliusercenter.pojo.base;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * 
 * @ClassName: AbstractPojoProperty
 * @Description:所有POJO类公共属性抽象类
 * @author: 宁黎
 * @date: 2019年5月16日 下午5:51:06
 */

@MappedSuperclass
public abstract class AbstractPojoProperty {
	/**
	 * 主键ID
	 */
	@Id
	@GeneratedValue
	private Integer id;
	/**
	 * 创建时间
	 */
	@Column(name = "create_time", nullable = false)
	private Date createTime;
	/**
	 * 更新时间
	 */
	@Column(name = "update_time")
	private Date updateTime;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
