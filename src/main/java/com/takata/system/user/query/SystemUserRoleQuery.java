package com.takata.system.user.query;

import lombok.Data;

/**
 * @author lzf
 **/
@Data
public class SystemUserRoleQuery {

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 角色ID
     */
    private Integer roleId;

}
