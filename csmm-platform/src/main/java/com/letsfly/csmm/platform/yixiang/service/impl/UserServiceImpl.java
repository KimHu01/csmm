package com.letsfly.csmm.platform.yixiang.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.letsfly.common.util.StringUtil;
import com.letsfly.csmm.platform.yixiang.dao.UserDao;
import com.letsfly.csmm.platform.yixiang.model.UserDO;
import com.letsfly.csmm.platform.yixiang.service.UserService;
import com.letsfly.mainstay.exception.CoreException;
import com.letsfly.mainstay.mvc.service.AbstractService;

@Service
public class UserServiceImpl extends AbstractService<UserDO, UserDao> implements UserService {

	@Override
	public List<UserDO> selectByName(String name) throws CoreException {
		if(StringUtil.isEmpty(name)) {
            throw new CoreException("name can not be null.");
        }
        
		return this.baseDao.selectByName(name);
	}
}
