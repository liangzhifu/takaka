package com.takata.system.user.query;

import lombok.Data;

/**
 * @author lzf
 **/
@Data
public class SystemUserQuery {

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
    private String userCode;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 分公司ID
     */
    private Integer companyId;

}
