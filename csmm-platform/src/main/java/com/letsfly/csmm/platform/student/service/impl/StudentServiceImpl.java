package com.letsfly.csmm.platform.student.service.impl;

import org.springframework.stereotype.Service;

import com.letsfly.csmm.platform.student.dao.StudentDao;
import com.letsfly.csmm.platform.student.model.StudentDO;
import com.letsfly.csmm.platform.student.service.StudentService;
import com.letsfly.mainstay.mvc.service.AbstractService;

/**
 * Student Service实现
 * @author KimHu
 * @create 2020/01/07
 * @version 1.0
 */
@Service
public class StudentServiceImpl extends AbstractService<StudentDO, StudentDao> implements StudentService {
    
}
