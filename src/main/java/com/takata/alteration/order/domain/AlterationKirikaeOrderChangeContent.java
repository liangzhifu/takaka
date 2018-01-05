package com.takata.alteration.order.domain;

import lombok.Data;

import java.util.Date;

/**
 * 切替单设变内容
 *
 * @author lzf
 **/
@Data
public class AlterationKirikaeOrderChangeContent {

    private Integer id;

    private String beforeChange;

    private String afterChange;

    private Integer beforeFileId;

    private Integer newFileId;

    private Integer deleteState;

    private Integer createBy;

    private Date createTime;

    private Integer updateBy;

    private Date updateTime;

    private Integer kirikaeOrderId;

}
