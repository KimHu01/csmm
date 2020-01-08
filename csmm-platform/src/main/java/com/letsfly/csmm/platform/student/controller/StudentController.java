package com.letsfly.csmm.platform.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.letsfly.common.annotation.JsonParam;
import com.letsfly.common.constant.GlobalConstant;
import com.letsfly.common.snowflake.KeyGenerator;
import com.letsfly.common.util.DateUtil;
import com.letsfly.common.util.StringUtil;
import com.letsfly.csmm.platform.student.model.StudentDO;
import com.letsfly.csmm.platform.student.service.StudentService;
import com.letsfly.mainstay.mvc.HttpResult;
import com.letsfly.mainstay.mvc.page.Pagination;
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
     * 新增studentDO(@RequestBody)
     * @param studentDO
     * @return
     */
    @ApiOperation(value="新增studentDO(@RequestBody)")
    @PostMapping("/addStudentByBody")
    public Object addStudentByBody(@RequestBody StudentDO studentDO) {
        if(StringUtil.isEmpty(studentDO.getStuId())) {
            studentDO.setStuId(KeyGenerator.generateStringKey());
        }
        
        studentDO.setEnabled(GlobalConstant.ONE);
        studentDO.setGmtCreated(DateUtil.getCurrentTimestamp());
        studentDO.setGmtModified(studentDO.getGmtCreated());
        
        studentDO = studentService.insert(studentDO);
        return HttpResult.ofSuccess(studentDO);
    }
    
    /**
     * 新增studentDO(@JsonParam)
     * @param studentDO
     * @return
     */
    @ApiOperation(value="新增studentDO(@JsonParam)")
    @PostMapping("/addStudentByJson")
    public Object addStudentByJson(@JsonParam StudentDO studentDO) {
        if(StringUtil.isEmpty(studentDO.getStuId())) {
            studentDO.setStuId(KeyGenerator.generateStringKey());
        }
        
        studentDO.setEnabled(GlobalConstant.ONE);
        studentDO.setGmtCreated(DateUtil.getCurrentTimestamp());
        studentDO.setGmtModified(studentDO.getGmtCreated());
        
        studentDO = studentService.insert(studentDO);
        return HttpResult.ofSuccess(studentDO);
    }
    
    /**
     * 删除studentDO(@RequestBody)
     * @param stuId
     * @return
     */
    @ApiOperation(value="删除studentDO(@RequestBody)")
    @PostMapping("/deleteStudentByBody")
    public Object deleteStudentByBody(@RequestBody String stuId) {
        int rows = studentService.deleteById(stuId);
        return HttpResult.ofSuccess(rows);
    }
    
    /**
     * 删除studentDO(@JsonParam)
     * @param stuId
     * @return
     */
    @ApiOperation(value="删除studentDO(@JsonParam)")
    @PostMapping("/deleteStudentByJson")
    public Object deleteStudentByJson(@JsonParam String stuId) {
        int rows = studentService.deleteById(stuId);
        return HttpResult.ofSuccess(rows);
    }
    
    /**
     * 更新studentDO(@RequestBody)
     * @param studentDO
     * @return
     */
    @ApiOperation(value="更新studentDO(@RequestBody)")
    @PostMapping("/updateStudentByBody")
    public Object updateStudentByBody(@RequestBody StudentDO studentDO) {
        if(StringUtil.isEmpty(studentDO.getStuId())) {
            return HttpResult.ofFailure(110501, "主键id不可为空");
        }
        
        int rows = studentService.update(studentDO);
        return HttpResult.ofSuccess(rows);
    }
    
    /**
     * 更新studentDO(@JsonParam)
     * @param studentDO
     * @return
     */
    @ApiOperation(value="更新studentDO(@JsonParam)")
    @PostMapping("/updateStudentByJson")
    public Object updateStudentByJson(@JsonParam StudentDO studentDO) {
        if(StringUtil.isEmpty(studentDO.getStuId())) {
            return HttpResult.ofFailure(110601, "主键id不可为空");
        }
        
        int rows = studentService.update(studentDO);
        return HttpResult.ofSuccess(rows);
    }
    
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
    
    /**
     * 条件查询student列表(前端传递json格式参数)
     * @param student 
     * @return
     */
    @ApiOperation(value="条件查询student列表(前端传递json格式参数)")
    @GetMapping("/selectListByJson")
    public Object selectListByJson(@JsonParam StudentDO student) {
        List<StudentDO> studentDOList = studentService.selectListByModel(student);
        return HttpResult.ofSuccess(studentDOList);
    }
    
    /**
     * 条件查询student列表(前端传递参数列表)
     * @param name
     * @param gender
     * @param age
     * @return
     */
    @ApiOperation(value="条件查询student列表(前端传递参数列表)")
    @GetMapping("/selectListByCondition")
    public Object selectListByCondition(@RequestParam String name, @RequestParam Integer gender, @RequestParam Integer age) {
        List<StudentDO> studentDOList = studentService.selectListByCondition(name, gender, age);
        return HttpResult.ofSuccess(studentDOList);
    }
    
    /**
     * 分页查询student列表(前端传递json格式参数)
     * @param student 
     * @return
     */
    @ApiOperation(value="分页查询student列表(前端传递json格式参数)")
    @GetMapping("/selectPageListByJson")
    public Object selectPageListByJson(@JsonParam Integer pageNum, @JsonParam Integer pageSize, @JsonParam StudentDO student) {
        Pagination<StudentDO> pagination = studentService.selectPageListByJson(pageNum, pageSize, student);
        return HttpResult.ofSuccess(pagination);
    }
}
