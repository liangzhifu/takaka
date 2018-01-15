package com.takata.system.user.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author lzf
 **/
@Data
public class SystemUserRole {

    private Integer id;

    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 删除状态（0-未删除，1-已删除）
     */
    private Integer deleteState;

    private String roleName;

    private String explaination;

    private Integer createBy;

    private Date createTime;

    private Integer updateBy;

    private Date updateTime;

}
