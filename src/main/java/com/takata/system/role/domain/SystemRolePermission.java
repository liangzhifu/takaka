package com.takata.system.role.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author lzf
 **/
@Data
public class SystemRolePermission {

    private Integer id;

    //角色ID
    private Integer roleId;

    //权限ID
    private Integer permisssionId;

    //删除状态（0-未删除，1-已删除）
    private Integer deleteState;

    //权限名称
    private String permissionName;

    //权限说明
    private String explaination;

    private Integer createBy;

    private Date createTime;

    private Integer updateBy;

    private Date updateTime;

}
