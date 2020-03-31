package com.letsfly.csmm.platform.yixiang.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.letsfly.csmm.platform.yixiang.model.UserDO;
import com.letsfly.mainstay.exception.DataAccessException;
import com.letsfly.mainstay.mvc.dao.MyBatisDao;

@Repository
public interface UserDao extends MyBatisDao<UserDO>{
	
	/**
     * 根据名字查询用户
     * @param name
     * @return
     * @throws DataAccessException
     */
	List<UserDO> selectByName(String name) throws DataAccessException;
	
}
