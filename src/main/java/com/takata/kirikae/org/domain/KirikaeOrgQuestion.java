package com.takata.kirikae.org.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author lzf
 **/
@Data
public class KirikaeOrgQuestion {

    private Integer id;

    //组织ID
    private Integer orgId;

    //切替问题点ID
    private Integer questionId;

    private Integer deleteState;

    private Integer createBy;

    private Date createTime;

    private Integer updateBy;

    private Date updateTime;

}
