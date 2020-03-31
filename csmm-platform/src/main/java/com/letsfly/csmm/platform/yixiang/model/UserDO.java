package com.letsfly.csmm.platform.yixiang.model;

import java.io.Serializable;
import java.sql.Timestamp;

import com.letsfly.common.model.AbstractDO;
/**
 * 
 * @author wangy
 *
 */
public class UserDO extends AbstractDO implements Serializable {
	    
	    private static final long serialVersionUID = 1L;
	    
	    /** 主键ID */
	    private String userId;
	    
	    /** 名字  */
	    private String name;
	    
		/** 用户名 */
	    private String username;
	    
	    /** 用户名 */
	    private String password;
	    
	    /** 性别 */
	    private Integer gender;
	    
	    /** 年龄 */
	    private Integer age;
	    
	    /** 是否可用(0/1:否/是) */
	    private Integer enabled;
	    
	    /** 创建时间 */
	    private Timestamp gmtCreated;
	    
	    /** 更新时间 */
	    private Timestamp gmtModified;

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

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
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
