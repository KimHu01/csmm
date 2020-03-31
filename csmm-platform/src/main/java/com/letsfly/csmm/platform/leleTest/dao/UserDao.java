package com.letsfly.csmm.platform.leleTest.dao;


import org.springframework.stereotype.Repository;

import com.letsfly.csmm.platform.leleTest.model.UserDO;
import com.letsfly.mainstay.exception.CoreException;
import com.letsfly.mainstay.exception.DataAccessException;
import com.letsfly.mainstay.mvc.dao.MyBatisDao;

@Repository
public interface UserDao extends MyBatisDao<UserDO>{
	
	/**
     * 根据主键查询用户
     * @param id
     * @return
     * @throws DataAccessException
     */
	UserDO selectById(String id) throws DataAccessException;

	
	/**
	 * 新增userDo
      * @param userDO
      * @return
      * @throws DataAccessException
	 */
	int insert(UserDO userDO) throws DataAccessException;
	
	/**
     * 根据主键删除用户
     * @param id
     * @return
     * @throws DataAccessException
     */
	int deleteById(String id) throws DataAccessException;

	/**
	 * 更新userDo
      * @param userDO
      * @return
      * @throws DataAccessException
	 */
	int update(UserDO uesrDO) throws DataAccessException;
}
