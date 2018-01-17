package com.takata.kirikae.order.domain;

import lombok.Data;

import java.util.Date;

/**
 * 切替单品号变更
 *
 * @author lzf
 **/
@Data
public class KirikaeOrderPartsNumber {

    private Integer id;

    private String oldPartsNumber;

    private String newPattsNumber;

    private Integer deleteState;

    private Integer createBy;

    private Date createTime;

    private Integer updateBy;

    private Date updateTime;

    private Integer kirikaeOrderId;

}
