package com.takata.system.user.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author lzf
 **/
@Data
public class SystemUser {

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 工号
     */
    private String userCode;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String userPassword;

    /**
     * 邮箱
     */
    private String userEmail;

    /**
     * 删除状态，0-未删除，1-已删除
     */
    private Integer deleteState;

    /**
     * 所属分公司
     */
    private Integer companyId;

    /**
     * 创建人
     */
    private Integer createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人
     */
    private Integer updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

}
