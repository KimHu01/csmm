package com.letsfly.csmm.platform.student.model;

import java.io.Serializable;
import java.sql.Timestamp;

import com.letsfly.common.model.AbstractDO;

/**
 * Student DO
 * @author KimHu
 * @create 2020/01/07
 * @version 1.0
 */
public class StudentDO extends AbstractDO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** 主键ID */
    private String stuId;
    
    /** 姓名 */
    private String name;
    
    /** 性别 */
    private Integer gender;
    
    /** 年龄 */
    private Integer age;
    
    /** 是否删除 */
    private Integer enabled;
    
    /** 创建时间 */
    private Timestamp gmtCreated;
    
    /** 更新时间 */
    private Timestamp gmtModified;
    
    /**
     * 构造方法
     */
    public StudentDO() {}

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
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
