package com.letsfly.csmm.platform.student.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.letsfly.csmm.platform.student.model.StudentDO;
import com.letsfly.mainstay.exception.DataAccessException;
import com.letsfly.mainstay.mvc.dao.MyBatisDao;

/**
 * Student Dao
 * @author KimHu
 * @create 2020/01/07
 * @version 1.0
 */
@Repository
public interface StudentDao extends MyBatisDao<StudentDO> {
    
    /**
     * 根据名字查询学生
     * @param name
     * @return
     * @throws DataAccessException
     */
    List<StudentDO> selectByName(String name) throws DataAccessException;
}
