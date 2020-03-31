package com.letsfly.csmm.platform.leleTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letsfly.common.constant.GlobalConstant;
import com.letsfly.common.snowflake.KeyGenerator;
import com.letsfly.common.util.DateUtil;
import com.letsfly.common.util.StringUtil;
import com.letsfly.csmm.platform.leleTest.model.UserDO;
import com.letsfly.csmm.platform.leleTest.service.UserService;
import com.letsfly.mainstay.mvc.HttpResult;
import com.letsfly.monomer.AbstractMonomerController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * User API
 * @author 乐乐
 * @create 2020/03/26
 * @version 1.0
 */
@Api(tags="用户信息API")
@RestController
@RequestMapping("/api/user")
public class UserController extends AbstractMonomerController{
	
	@Autowired
	private UserService userService;
	/**
	 * 新增userDo(@RequestBody)
	 * @param userDO
	 * @return
	 */
	
	@ApiOperation(value="新增userDO(@RequestBody)")
    @PostMapping("/addUserByBody")
    public Object addUserByBody(@RequestBody UserDO userDO) {
        if(StringUtil.isEmpty(userDO.getUserId())) {
        	userDO.setUserId(KeyGenerator.generateStringKey());
        }
        userDO.setAge(userDO.getAge());
        userDO.setName(userDO.getName());
        userDO.setEnabled(GlobalConstant.ONE);
        userDO.setGmtCreated(DateUtil.getCurrentTimestamp());
        userDO.setGmtModified(userDO.getGmtCreated());
        
        userDO = userService.insert(userDO);
        return HttpResult.ofSuccess(userDO);
    }
	
	/**
	 * 根据主键查询user
     * @param id
     * @return
	 */
	
	@ApiOperation(value="根据主键查询user")
    @GetMapping("/selectById/{id}")
    public Object selectById(@PathVariable String id) {
        UserDO userDO = userService.selectById(id);
        return HttpResult.ofSuccess(userDO);
    }
	
	/**
	 * 根据主键删除user
     * @param userId
     * @return
	 */
	
	@ApiOperation(value="根据主键删除user")
    @PostMapping("/deleteById/{id}")
    public Object deleteById(@PathVariable String id) {
		int rows  = userService.deleteById(id);
        return HttpResult.ofSuccess(rows);
    }
	
	/**
	 * 更新userDO(@RequestBody)
	 * @param userDO
	 * @return
	 */
	
	@ApiOperation(value="更新userDO(@RequestBody)")
	@PostMapping("updateUserByBody")
	public Object updateUserByBody(@RequestBody UserDO userDO) {
		if(StringUtil.isEmpty(userDO.getUserId())) {
            return HttpResult.ofFailure(110501, "主键id不可为空");
        }
        
        int rows = userService.update(userDO);
        return HttpResult.ofSuccess(rows);
	}
}
