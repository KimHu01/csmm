package com.letsfly.csmm.platform.yixiang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.letsfly.common.constant.GlobalConstant;
import com.letsfly.common.snowflake.KeyGenerator;
import com.letsfly.common.util.DateUtil;
import com.letsfly.common.util.StringUtil;
import com.letsfly.csmm.platform.student.model.StudentDO;
import com.letsfly.csmm.platform.yixiang.model.UserDO;
import com.letsfly.csmm.platform.yixiang.service.UserService;
import com.letsfly.mainstay.mvc.HttpResult;
import com.letsfly.monomer.AbstractMonomerController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="用户信息API")
@RestController
@RequestMapping("/api/user")
public class UserController extends AbstractMonomerController{
	
	@Autowired
    private UserService userService;
	
	 /**
     * 新增studentDO(@RequestBody)
     * @param studentDO
     * @return
     */
    @ApiOperation(value="新增UserDO(@RequestBody)")
    @PostMapping("/addUserByBody")
    public Object addStudentByBody(@RequestBody UserDO userDO) {
        if(StringUtil.isEmpty(userDO.getUserId())) {
            userDO.setUserId(KeyGenerator.generateStringKey());
        }
        
        userDO.setEnabled(GlobalConstant.ONE);
        userDO.setGmtCreated(DateUtil.getCurrentTimestamp());
        userDO.setGmtModified(userDO.getGmtCreated());
        
        userDO = userService.insert(userDO);
        return HttpResult.ofSuccess(userDO);
    }
    /**
     * 通过名字查询数据库行
     * @param name
     * @return
     */
    @ApiOperation(value="查询")
    @GetMapping("/selectByName")
    public Object selectByName(@RequestParam String name) {
    	List<UserDO> userList = userService.selectByName(name);
        return HttpResult.ofSuccess(userList);
    }
    
    
    @ApiOperation(value="删除userDO(@RequestBody)")
    @PostMapping("/deleteStudentByBody")
    public Object deleteStudentByBody(@RequestBody String userId) {
        int rows = userService.deleteById(userId);
        return HttpResult.ofSuccess(rows);
    }
    
    /**
     * 
     * @param userDO
     * @return
     */
    @ApiOperation(value="更新userDO(@RequestBody)")
    @PostMapping("/updateUserByBody")
    public Object updateUserByBody(@RequestBody UserDO userDO) {
        if(StringUtil.isEmpty(userDO.getUserId())) {
            return HttpResult.ofFailure(110501, "主键id不可为空");
        }
        
        int rows = userService.update(userDO);
        return HttpResult.ofSuccess(rows);
    }
    
}
