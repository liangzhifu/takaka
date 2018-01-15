package com.takata.system.org.query;

import lombok.Data;

/**
 * @author lzf
 **/
@Data
public class SystemOrgQuery {

    /**
     * 分公司ID
     */
    private Integer companyId;

    /**
     * 路径
     */
    private String orgPathCode;

    /**
     * 组织类型
     */
    private Integer orgType;

}
