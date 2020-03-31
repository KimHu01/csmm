package com.letsfly.csmm.platform.leleTest.service.impl;


import org.springframework.stereotype.Service;

import com.letsfly.common.util.StringUtil;
import com.letsfly.csmm.platform.leleTest.dao.UserDao;
import com.letsfly.csmm.platform.leleTest.model.UserDO;
import com.letsfly.csmm.platform.leleTest.service.UserService;
import com.letsfly.mainstay.exception.CoreException;
import com.letsfly.mainstay.mvc.service.AbstractService;

@Service
public class UserServiceImpl extends AbstractService<UserDO, UserDao> implements UserService{

	/**
	 * 根据主键查询用户
     * @param id
     * @return
     * @throws CoreException
	 */
	@Override
    public UserDO selectById(String id) throws CoreException {
        if(StringUtil.isEmpty(id)) {
            throw new CoreException("Id can not be null.");
        }
        
        return this.baseDao.selectById(id);
    }
	
	/**
	 * 新增userDo
      * @param userDO
      * @return
      * @throws CoreException
	 */
	@Override
	public UserDO insert(UserDO userDO) throws CoreException{
		if(StringUtil.isEmpty(userDO.getUserId())) {
            throw new CoreException("Id can not be null.");
		}
		int rows = this.baseDao.insert(userDO);
		if(rows == 1) {
			return userDO;
		}
		return null;
	}
	
	/**
	 * 根据主键删除用户
     * @param id
     * @return
     * @throws CoreException
	 */
	@Override
    public int deleteById(String id) throws CoreException {
        if(StringUtil.isEmpty(id)) {
            throw new CoreException("Id can not be null.");
        }
        
        return this.baseDao.deleteById(id);
    }
	
	/**
     * 更新userDO
     * @param userDO
     * @return
     * @throws CoreException
     */
	@Override
	public int update(UserDO userDO) throws CoreException{
		if(StringUtil.isEmpty(userDO.getUserId())) {
            throw new CoreException("Id can not be null.");
		}
		return this.baseDao.update(userDO);
		
	}
}
