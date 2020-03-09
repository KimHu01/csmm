package com.letsfly.csmm.platform.student.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.letsfly.common.util.StringUtil;
import com.letsfly.csmm.platform.student.dao.StudentDao;
import com.letsfly.csmm.platform.student.model.StudentDO;
import com.letsfly.csmm.platform.student.service.StudentService;
import com.letsfly.mainstay.exception.CoreException;
import com.letsfly.mainstay.mvc.page.Pagination;
import com.letsfly.mainstay.mvc.service.AbstractService;

/**
 * Student Service实现
 * @author KimHu
 * @create 2020/01/07
 * @version 1.0
 */
@Service
public class StudentServiceImpl extends AbstractService<StudentDO, StudentDao> implements StudentService {
    
    /**
     * 条件查询
     * @param name
     * @param gender
     * @param age
     * @return
     * @throws CoreException
     */
    @Override
    public List<StudentDO> selectListByCondition(String name, Integer gender, Integer age) throws CoreException {
        if(StringUtil.isEmpty(name) && null == gender && null == age) {
            throw new CoreException("Illegal Parameters");
        }
        
        StudentDO studentDO = new StudentDO();
        studentDO.setName(name);
        studentDO.setGender(gender);
        studentDO.setAge(age);
        
        return super.selectListByModel(studentDO);
    }
    
    /**
     * 分页查询student列表
     * @param pageNum
     * @param pageSize
     * @param student
     * @return
     * @throws CoreException
     */
    @Override
    public Pagination<StudentDO> selectPageListByJson(Integer pageNum, Integer pageSize, StudentDO student) throws CoreException {
        if(null == pageNum || null == pageSize || null == student) {
            throw new CoreException("Illegal Parameters");
        }
        
        return super.selectListByPage(new Pagination<StudentDO>(pageNum, pageSize, student));
    }
    
    /**
     * 根据名字查询学生
     * @param name
     * @return
     * @throws CoreException
     */
    @Override
    public List<StudentDO> selectByName(String name) throws CoreException {
        if(StringUtil.isEmpty(name)) {
            throw new CoreException("name can not be null.");
        }
        
        return this.baseDao.selectByName(name);
    }
}
