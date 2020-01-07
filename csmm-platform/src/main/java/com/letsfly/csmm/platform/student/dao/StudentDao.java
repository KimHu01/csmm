package com.letsfly.csmm.platform.student.dao;

import org.springframework.stereotype.Repository;

import com.letsfly.csmm.platform.student.model.StudentDO;
import com.letsfly.mainstay.mvc.dao.MyBatisDao;

/**
 * Student Dao
 * @author KimHu
 * @create 2020/01/07
 * @version 1.0
 */
@Repository
public interface StudentDao extends MyBatisDao<StudentDO> {
    
}
