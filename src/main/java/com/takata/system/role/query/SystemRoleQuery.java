package com.takata.system.role.query;

import lombok.Data;

/**
 * @author lzf
 **/
@Data
public class SystemRoleQuery {

    /**
     * 分页使用，开始位置
     */
    private Integer start;

    /**
     * 分页使用，数量
     */
    private Integer size;

    /**
     * 工号
     */
    private String roleName;

}
