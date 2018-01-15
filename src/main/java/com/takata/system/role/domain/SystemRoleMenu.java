package com.takata.system.role.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author lzf
 **/
@Data
public class SystemRoleMenu {

    private Integer id;

    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 菜单ID
     */
    private Integer menuId;

    /**
     * 删除状态（0-未删除，1-已删除）
     */
    private Integer deleteState;

    private Integer createBy;

    private Date createTime;

    private Integer updateBy;

    private Date updateTime;

}
