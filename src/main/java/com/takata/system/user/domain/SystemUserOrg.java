package com.takata.system.user.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author lzf
 **/
@Data
public class SystemUserOrg {

    private Integer id;

    /**
     * 组织ID
     */
    private Integer orgId;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 删除状态（0-未删除，1-已删除）
     */
    private Integer deleteState;

    private Integer createBy;

    private Date createTime;

    private Integer updateBy;

    private Date updateTime;

}
