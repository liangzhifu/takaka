package com.takata.system.org.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author lzf
 **/
@Data
public class SystemOrg {

    private Integer id;

    /**
     * 父级ID
     */
    private Integer parentId;

    /**
     * 父级名称
     */
    private String parentOrgName;

    /**
     * 分公司ID
     */
    private Integer companyId;

    /**
     * 组织名称
     */
    private String orgName;

    /**
     * 组织路径
     */
    private String orgPathCode;

    /**
     * 组织类型
     */
    private Integer orgType;

    /**
     * 删除状态（0-未删除，1-已删除）
     */
    private Integer deleteState;

    private Integer createBy;

    private Date createTime;

    private Integer updateBy;

    private Date updateTime;

}
