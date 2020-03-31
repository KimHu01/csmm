package com.letsfly.csmm.platform.leleTest.service;

import java.util.List;

import com.letsfly.csmm.platform.leleTest.model.UserDO;
import com.letsfly.mainstay.exception.CoreException;
import com.letsfly.mainstay.mvc.service.base.Service;

/**
 * User Service接口定义
 * @author 乐乐
 * @create 2020/03/27
 * @version 1.0
 */


public interface UserService extends Service<UserDO> {
	
	/**
     * 根据主键查询用户
     * @param id
     * @return
     * @throws CoreException
     */
      UserDO selectById(String id) throws CoreException;
      
     /**
      * 新增userDo
      * @param userDO
      * @return
      * @throws CoreException
      */
      UserDO insert(UserDO userDO) throws CoreException;
      
      /**
       * 根据主键删除用户
       * @param id
       * @return
       * @throws CoreException
       */
        int deleteById(String id) throws CoreException;  
        
        /**
         * 更新userDO
         * @param userDO
         * @return
         * @throws CoreException
         */
        int update(UserDO userDO) throws CoreException;

}
