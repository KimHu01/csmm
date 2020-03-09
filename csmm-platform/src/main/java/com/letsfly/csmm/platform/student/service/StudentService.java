package com.letsfly.csmm.platform.student.service;

import java.util.List;

import com.letsfly.csmm.platform.student.model.StudentDO;
import com.letsfly.mainstay.exception.CoreException;
import com.letsfly.mainstay.mvc.page.Pagination;
import com.letsfly.mainstay.mvc.service.base.Service;

/**
 * Student Service接口定义
 * @author KimHu
 * @create 2020/01/07
 * @version 1.0
 */
public interface StudentService extends Service<StudentDO> {
    
    /**
     * 条件查询
     * @param name
     * @param gender
     * @param age
     * @return
     * @throws CoreException
     */
    List<StudentDO> selectListByCondition(String name, Integer gender, Integer age) throws CoreException;
    
    /**
     * 分页查询student列表
     * @param pageNum
     * @param pageSize
     * @param student
     * @return
     * @throws CoreException
     */
    Pagination<StudentDO> selectPageListByJson(Integer pageNum, Integer pageSize, StudentDO student) throws CoreException;
    
    /**
     * 根据名字查询学生
     * @param name
     * @return
     * @throws CoreException
     */
    List<StudentDO> selectByName(String name) throws CoreException;
}
