package com.takata.alteration.order.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author lzf
 **/
@Data
public class AlterationOrder {

    private Integer id;

    private Integer orderChannel;

    private Integer deleteState;

    private Integer createBy;

    private Date createTime;

    private Integer updateBy;

    private Date updateTime;

    private String orderState;

    private String invalidateText;

    private AlterationFourOrder alterationFourOrder;

    private AlterationKirikaeOrder alterationKirikaeOrder;

}
