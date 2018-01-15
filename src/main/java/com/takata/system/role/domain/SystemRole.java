package com.takata.system.role.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author lzf
 **/
@Data
public class SystemRole {

    private Integer id;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色说明
     */
    private String explaination;

    /**
     * 删除状态（0-未删除，1-已删除）
     */
    private Integer deleteState;

    private Integer createBy;

    private Date createTime;

    private Integer updateBy;

    private Date updateTime;

}
