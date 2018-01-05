package com.takata.kirikae.question.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author lzf
 **/
@Data
public class KirikaeQuestion {

    private Integer id;

    //确认项目
    private String confirmProject;

    //确认内容
    private String confirmContent;

    //删除状态（0-未删除，1-已删除）
    private Integer deleteState;

    private Integer createBy;

    private Date createTime;

    private Integer updateBy;

    private Date updateTime;

}
