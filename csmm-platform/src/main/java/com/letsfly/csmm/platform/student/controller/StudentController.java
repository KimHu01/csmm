package com.letsfly.csmm.platform.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letsfly.csmm.platform.student.model.StudentDO;
import com.letsfly.csmm.platform.student.service.StudentService;
import com.letsfly.mainstay.mvc.HttpResult;
import com.letsfly.monomer.AbstractMonomerController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Student API
 * @author KimHu
 * @create 2020/01/07
 * @version 1.0
 */
@Api(tags="学生信息API")
@RestController
@RequestMapping("/api/student")
public class StudentController extends AbstractMonomerController {
    
    @Autowired
    private StudentService studentService;
    
    /**
     * 根据主键查询student
     * @param id
     * @return
     */
    @ApiOperation(value="根据主键查询student")
    @GetMapping("/selectById/{id}")
    public Object selectById(@PathVariable String id) {
        StudentDO studentDO = studentService.selectById(id);
        return HttpResult.ofSuccess(studentDO);
    }
}
