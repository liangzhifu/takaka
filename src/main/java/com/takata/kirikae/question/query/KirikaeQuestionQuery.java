package com.takata.kirikae.question.query;

import lombok.Data;

/**
 * @author lzf
 **/
@Data
public class KirikaeQuestionQuery {

    private Integer start;

    private Integer size;

    //确认项目
    private String confirmProject;

    //确认内容
    private String confirmContent;

}
