package com.service.ningliusercenter.service.impl.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.ningliusercenter.pojo.system.SystemPlatformDO;
import com.service.ningliusercenter.repository.system.SystemPlatformRepository;
import com.service.ningliusercenter.service.system.SystemPlatformService;

@Service
public class SystemPlatformServiceImpl implements SystemPlatformService {
	@Autowired
	private SystemPlatformRepository systemPlatformRepository;

	/**
	 * 
	 * <p>
	 * Title: getById
	 * </p>
	 * <p>
	 * Description: 根据ID获取SystemPlateformDO对象
	 * </p>
	 * 
	 * @author 宁黎
	 * @param id
	 * @return
	 * @see com.service.ningliusercenter.service.system.SystemPlatformService#getById(java.lang.Integer)
	 */
	@Override
	public SystemPlatformDO getById(Integer id) {
		return systemPlatformRepository.findOne(id);
	}

}
