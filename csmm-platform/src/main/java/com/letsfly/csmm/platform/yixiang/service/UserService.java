package com.letsfly.csmm.platform.yixiang.service;

import java.util.List;

import com.letsfly.csmm.platform.yixiang.model.UserDO;
import com.letsfly.mainstay.exception.CoreException;
import com.letsfly.mainstay.mvc.service.base.Service;

public interface UserService extends Service<UserDO>{
	
	 /**
     * 根据名字查询用户
     * @param name
     * @return
     * @throws CoreException
     */
    List<UserDO> selectByName(String name) throws CoreException;

}
