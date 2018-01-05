package com.takata.four.tache.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author lzf
 **/
@Data
public class FourTemplateTacheUser {

    private Integer id;

    private Integer tacheId;

    private Integer userId;

    private Integer deleteState;

    private Integer createBy;

    private Date createTime;

    private Integer updateBy;

    private Date updateTime;

}
