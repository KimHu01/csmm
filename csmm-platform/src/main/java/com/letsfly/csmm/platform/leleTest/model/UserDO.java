package com.letsfly.csmm.platform.leleTest.model;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.letsfly.common.model.AbstractDO;

/**
 * UserDO
 * @author 乐乐
 * @create 2020/03/26
 * @version 1.0
 */

public class UserDO extends AbstractDO implements Serializable{
	private static final long serialVersionUID = 1L;
    
    /** 主键ID */
    private String userId;
    
    /** 姓名 */
    private String name;
    
    /** 性别 */
    private Integer gender;
    
    /** 是否可用(0/1:否/是) */
    private Integer enabled;
    
    /** 创建时间 */
    private Timestamp gmtCreated;
    
    /** 更新时间 */
    private Timestamp gmtModified;

    /**
     * 构造方法
     */
    public UserDO() {}
	/** 年龄 */
	private Integer age;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public Timestamp getGmtCreated() {
		return gmtCreated;
	}

	public void setGmtCreated(Timestamp gmtCreated) {
		this.gmtCreated = gmtCreated;
	}

	public Timestamp getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Timestamp gmtModified) {
		this.gmtModified = gmtModified;
	}
    
    

}
